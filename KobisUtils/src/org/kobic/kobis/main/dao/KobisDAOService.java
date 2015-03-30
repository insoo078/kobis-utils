package org.kobic.kobis.main.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.main.mapper.KobisMapper;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.taxon.mapper.TaxonMapper;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;
import org.kobic.kobis.file.excel.obj.internal.CultureObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.PatentObj;
import org.kobic.kobis.file.excel.obj.internal.ReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.StoreObj;
import org.kobic.kobis.main.vo.D1BodyFluidVO;
import org.kobic.kobis.main.vo.D1CellStrainVO;
import org.kobic.kobis.main.vo.D1DnaRnaProteinDerivativesVO;
import org.kobic.kobis.main.vo.D1DnaSequenceVO;
import org.kobic.kobis.main.vo.D1EmbryoVO;
import org.kobic.kobis.main.vo.D1EtcVO;
import org.kobic.kobis.main.vo.D1ExpressionVO;
import org.kobic.kobis.main.vo.D1ExtractionVO;
import org.kobic.kobis.main.vo.D1IndividualVO;
import org.kobic.kobis.main.vo.D1ObservationVO;
import org.kobic.kobis.main.vo.D1ProteinSequenceVO;
import org.kobic.kobis.main.vo.D1SeedVO;
import org.kobic.kobis.main.vo.D1SourceVO;
import org.kobic.kobis.main.vo.D1SpecimenVO;
import org.kobic.kobis.main.vo.D1StrainVO;
import org.kobic.kobis.main.vo.D1StructureVO;
import org.kobic.kobis.main.vo.DBCommonInterface;

public class KobisDAOService extends CommonDAOService implements KobisDAO{

	public KobisDAOService(SqlSessionFactory sqlSessionFactory){
		super( sqlSessionFactory );
	}
    
	/**
	 * genus를 이용하여 환경부 분류체계를 조회하는 쿼리를 호출하는 메소드
	 * 
	 * @param genus 조회를 위한 genus 정보
	 * 
	 * @return genus로 조회된 분류체계 정보
	 */
	public List<PhylogeneticTreeVO> getPhylogeneticTreeByGenus( String genus) {
		List<PhylogeneticTreeVO> list = null;
		// autocommit is false
		SqlSession session = this.getSessionFactory().openSession();
		
		try {
			TaxonMapper taxonMapper = session.getMapper( TaxonMapper.class );
			list = taxonMapper.getPhylogeneticTreeByGenus(genus);
		}finally{
			session.close();
		}
		return list;
	}

    @Override
    public String getInstitutionId(String insCd) {
    	SqlSession session = this.getSessionFactory().openSession();
    	String result = null;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		result = kobisMapper.getInstitutionId(insCd);
	   	}finally{
	   		session.close();
	   	}
    	
    	return Utils.emptyToNull( result );
    }
    @Override
    public String getAccessionNum(String accession_num, String ins_cd) {
    	SqlSession session = this.getSessionFactory().openSession();
    	String result = null;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("accession_num", accession_num);
    		map.put("ins_cd", ins_cd);

    		result = kobisMapper.getAccessionNum( map );
	   	}finally{
	   		session.close();
	   	}
    	
    	return Utils.emptyToNull( result );
    }
    @Override
    public int insertD1Common( D1CommonVO d1CommonVo, Map<String, String> crossTaxonMap ) {
    	SqlSession session = this.getSessionFactory().openSession( false );

    	KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    	TaxonMapper taxonMapper = session.getMapper( TaxonMapper.class );
    	int ret = 0;
    	try {
    		// T1_ClassificationSystemTable에서 입력된 환경부, ITIS, GBIF, NCBI의 분류체계로 코드가 존재하는지 조회
    		String tab_id = taxonMapper.getT1ClassificationSystemTable( crossTaxonMap );

    		if( Utils.nullToEmpty( tab_id ).isEmpty() ) {
    			// 만약 T1_ClassificationSystemTable에 값이 존재하지 않는 경우 테이블에 데이터 등록후 등록번호 가져옴
    			ret += taxonMapper.insertT1ClassificationSystemTable( crossTaxonMap );
    			tab_id = taxonMapper.getT1ClassificationSystemTable( crossTaxonMap );
    			
        		d1CommonVo.setCode( tab_id );
    		}
    		if( !Utils.nullToEmpty( tab_id ).isEmpty() ) {
    			// 매핑된 분류코드를 record에 삽입한뒤 D1_Common 테이블에 입력
    			ret = kobisMapper.insertD1Common(d1CommonVo);

	    		if( !Utils.nullToEmpty( d1CommonVo.getSynonym().trim() ).isEmpty() ) {
	    			// 만약 record에 Synonym이 존재하면 E1_Synonym 테이블에 등록
	    			kobisMapper.insertE1Synonyms(d1CommonVo);
	    		}
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		session.rollback();
    		e.printStackTrace();
    	}finally{
    		session.close();
    	}
    	return ret;
    }
    
    public Map<String, String> getE1Culture( DBCommonInterface sheet ) {
    	Map<String, String> map = new HashMap<String, String>();

		map.put("accession_num",	sheet.getAccess_num() );
		map.put("id",				sheet.getId() );
    	try {
    		Method getCulture = sheet.getClass().getMethod("getCulture" );

    		try {
    			Object cultureParam = getCulture.invoke( sheet );

    			if( cultureParam instanceof  CultureObj ) {
    				CultureObj param = (CultureObj)cultureParam;
    	    		map.put("culture_medium_name",	param.getCultureMediumName() );
    	    		map.put("condition",			param.getCondition() );
    	    		map.put("succeed_dt",			param.getSucceedDt() );
    	    		map.put("succeed_time",			param.getSucceedTime() );
    			}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}catch(NoSuchMethodException e) {
    		e.printStackTrace();
    	}

    	return map;
    }
    public Map<String, String> getE1Store( DBCommonInterface sheet ) {
    	Map<String, String> map = new HashMap<String, String>();
    	
		map.put("accession_num",	sheet.getAccess_num() );
		map.put("id",				sheet.getId() );
    	try {
    		Method getStore = sheet.getClass().getMethod("getStore" );

    		try {
    			Object storeParam = getStore.invoke( sheet );

    			if( storeParam instanceof  StoreObj ) {
    				StoreObj param = (StoreObj)storeParam;
            		map.put("store_no",			param.getStoreNo() );
            		map.put("store_place",		param.getStorePlace() );
    			}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}catch(NoSuchMethodException e) {
    		e.printStackTrace();
    	}

    	return map;
    }
    public Map<String, String> getE1Reference( DBCommonInterface sheet ) {
    	Map<String, String> map = new HashMap<String, String>();

		map.put("accession_num",	sheet.getAccess_num() );
		map.put("id",				sheet.getId() );
    	try {
    		Method getExtra = sheet.getClass().getMethod("getExtra" );

    		try {
    			Object distPatentRefParam = getExtra.invoke( sheet );

    			if( distPatentRefParam instanceof  DistPatentReferenceObj ) {
        			DistPatentReferenceObj param = (DistPatentReferenceObj)distPatentRefParam;
            		map.put("reference",		param.getRef().getReference() );
    			}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}catch(NoSuchMethodException e) {
    		try {
				Method getPatent = sheet.getClass().getMethod("getReference" );
				
				try {
	    			Object refObj = getPatent.invoke( sheet );

	    			if( refObj instanceof  ReferenceObj ) {
	    				ReferenceObj param = (ReferenceObj)refObj;
	            		map.put("reference",		param.getReference() );
	            		map.put("accession_num",	sheet.getAccess_num() );
	            		map.put("id",				sheet.getId() );
	    			}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}

    	return map;
    }
    public Map<String, String> getE1Patent( DBCommonInterface sheet ) {
    	Map<String, String> map = new HashMap<String, String>();
    	
		map.put("accession_num",	sheet.getAccess_num() );
		map.put("id",				sheet.getId() );
    	try {
    		Method getExtra = sheet.getClass().getMethod("getExtra" );

    		try {
    			Object distPatentRefParam = getExtra.invoke( sheet );

    			if( distPatentRefParam instanceof  DistPatentReferenceObj ) {
        			DistPatentReferenceObj param = (DistPatentReferenceObj)distPatentRefParam;
            		map.put("patent_no",		param.getPatent().getParentNo() );
            		map.put("reg_no",			param.getPatent().getRegNo() );
    			}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}catch(NoSuchMethodException e) {
    		try {
				Method getPatent = sheet.getClass().getMethod("getPatent" );
				
				try {
	    			Object patentObj = getPatent.invoke( sheet );

	    			if( patentObj instanceof  PatentObj ) {
	    				PatentObj param = (PatentObj)patentObj;
	            		map.put("patent_no",		param.getParentNo() );
	            		map.put("reg_no",			param.getRegNo() );
	            		map.put("accession_num",	sheet.getAccess_num() );
	            		map.put("id",				sheet.getId() );
	    			}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}

    	return map;
    }
    public Map<String, String> getE1Distribution( DBCommonInterface sheet ) {
    	Map<String, String> map = new HashMap<String, String>();

		map.put("accession_num",	sheet.getAccess_num() );
		map.put("id",				sheet.getId() );
    	try {
    		Method getExtra = sheet.getClass().getMethod("getExtra" );

    		try {
    			Object distPatentRefParam = getExtra.invoke( sheet );

    			if( distPatentRefParam instanceof  DistPatentReferenceObj ) {
        			DistPatentReferenceObj param = (DistPatentReferenceObj)distPatentRefParam;
	        		map.put("dist_url",			param.getDist().getDistUrl() );
	        		map.put("dist_yn",			param.getDist().getDistYn() );
    			}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}catch(NoSuchMethodException e) {
    		e.printStackTrace();
    	}

    	return map;
    }

    @Override
    public int insertD1Observation( D1ObservationVO observationSheet ) {
    	SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Observation( observationSheet );
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( observationSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( observationSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( observationSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;    	
    }

	@Override
	public int insertD1Individual( D1IndividualVO individualSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Individual( individualSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( individualSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( individualSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( individualSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Specimen(D1SpecimenVO specimenSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Specimen( specimenSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( specimenSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( specimenSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( specimenSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Source(D1SourceVO sourceSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Source( sourceSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( sourceSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( sourceSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( sourceSheet ) );
    			ret = kobisMapper.insertE1Store( this.getE1Store( sourceSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Seed(D1SeedVO seedSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Seed( seedSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( seedSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( seedSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( seedSheet ) );
    			ret = kobisMapper.insertE1Store( this.getE1Store( seedSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Embryo(D1EmbryoVO embryoSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Embryo( embryoSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( embryoSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( embryoSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( embryoSheet ) );
    			ret = kobisMapper.insertE1Store( this.getE1Store( embryoSheet ) );
    		}
    		
    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1DnaRnaProteinDerivatives( D1DnaRnaProteinDerivativesVO dnaRnaProteinDerivativeSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1DnaRnaProteinDerivatives( dnaRnaProteinDerivativeSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( dnaRnaProteinDerivativeSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( dnaRnaProteinDerivativeSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( dnaRnaProteinDerivativeSheet ) );
    			ret = kobisMapper.insertE1Store( this.getE1Store( dnaRnaProteinDerivativeSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Strain(D1StrainVO strainSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Strain( strainSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( strainSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( strainSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( strainSheet ) );
    			ret = kobisMapper.insertE1Culture( this.getE1Culture( strainSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1CellStrain(D1CellStrainVO cellStrainSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1CellStrain( cellStrainSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( cellStrainSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( cellStrainSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( cellStrainSheet ) );
    			ret = kobisMapper.insertE1Culture( this.getE1Culture( cellStrainSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1BodyFluid(D1BodyFluidVO bodyFluidSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1BodyFluid( bodyFluidSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( bodyFluidSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( bodyFluidSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( bodyFluidSheet ) );
    			ret = kobisMapper.insertE1Culture( this.getE1Culture( bodyFluidSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1ProteinSequence( D1ProteinSequenceVO proteinSequenceSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1ProteinSequence( proteinSequenceSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( proteinSequenceSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( proteinSequenceSheet ) );
    		}    		
    		
    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Expression(D1ExpressionVO expressionSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Expression( expressionSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( expressionSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( expressionSheet ) );
    		}   

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Structure(D1StructureVO structureSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Structure( structureSheet );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( structureSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( structureSheet ) );
    		}   

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1DnaSequence(D1DnaSequenceVO dnaSequenceSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1DnaSequence( dnaSequenceSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( dnaSequenceSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( dnaSequenceSheet ) );
    		}   

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Etc(D1EtcVO etcSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );

    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( etcSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( etcSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( etcSheet ) );
    		}

    		ret = kobisMapper.insertD1Etc( etcSheet );
    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertD1Extraction(D1ExtractionVO extractionSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Extraction( extractionSheet );
    		
    		if( ret > 0 ) {
    			ret = kobisMapper.insertE1Distribution( this.getE1Distribution( extractionSheet ) );
    			ret = kobisMapper.insertE1Patent( this.getE1Patent( extractionSheet ) );
    			ret = kobisMapper.insertE1Reference(  this.getE1Reference( extractionSheet ) );
    		}

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}

	@Override
	public int insertT2MappedCommon(D1CommonVO commonSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertT2MappedCommon( commonSheet );
    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}
}
