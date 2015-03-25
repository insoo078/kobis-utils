package org.kobic.kobis.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.file.excel.obj.XBodyFluidSheetObj;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.file.excel.obj.XDnaRnaProteinDerivativesSheetObj;
import org.kobic.kobis.file.excel.obj.XDnaSequenceSheetObj;
import org.kobic.kobis.file.excel.obj.XEmbryoSheetObj;
import org.kobic.kobis.file.excel.obj.XEtcSheetObj;
import org.kobic.kobis.file.excel.obj.XExpressionSheetObj;
import org.kobic.kobis.file.excel.obj.XExtractSheetObj;
import org.kobic.kobis.file.excel.obj.XIndividualSheetObj;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.file.excel.obj.XProteinSequenceSheetObj;
import org.kobic.kobis.file.excel.obj.XSeedSheetObj;
import org.kobic.kobis.file.excel.obj.XSourceSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.file.excel.obj.XStrainSheetObj;
import org.kobic.kobis.file.excel.obj.XStructureSheetObj;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.main.mapper.KobisMapper;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.taxon.mapper.TaxonMapper;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;

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
    
    public Map<String, Object> getE1Distribution( AbstractSheetObj sheet ) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if( sheet instanceof XObservationSheetObj ) {
    		XObservationSheetObj xoso = (XObservationSheetObj)sheet;
    		map.put("distribution", xoso.getExtra().getDist() );
    		map.put("reference", xoso.getExtra().getRef() );
    		map.put("patent", xoso.getExtra().getPatent() );
    		map.put("accession_num", xoso.getAccess_num() );
    		map.put("id", xoso.get)
    	}
    	return map;
    }

    @Override
    public int insertD1Observation( XObservationSheetObj observationSheet ) {
    	SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Observation(observationSheet);
    		
    		
    		
    		
    		
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
	public int insertD1Individual(XIndividualSheetObj individualSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Individual( individualSheet );
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
	public int insertD1Specimen(XSpecimenSheetObj specimenSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Specimen( specimenSheet );
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
	public int insertD1Source(XSourceSheetObj sourceSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Source( sourceSheet );
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
	public int insertD1Seed(XSeedSheetObj seedSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Seed( seedSheet );
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
	public int insertD1Embryo(XEmbryoSheetObj embryoSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Embryo( embryoSheet );
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
	public int insertD1DnaRnaProteinDerivatives( XDnaRnaProteinDerivativesSheetObj dnaRnaProteinDerivativeSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1DnaRnaProteinDerivatives( dnaRnaProteinDerivativeSheet );
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
	public int insertD1Strain(XStrainSheetObj strainSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Strain( strainSheet );
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
	public int insertD1CellStrain(XCellStrainSheetObj cellStrainSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1CellStrain( cellStrainSheet );
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
	public int insertD1BodyFluid(XBodyFluidSheetObj bodyFluidSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1BodyFluid( bodyFluidSheet );
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
	public int insertD1ProteinSequence( XProteinSequenceSheetObj proteinSequenceSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1ProteinSequence( proteinSequenceSheet );
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
	public int insertD1Expression(XExpressionSheetObj expressionSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Expression( expressionSheet );
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
	public int insertD1Structure(XStructureSheetObj structureSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Structure( structureSheet );
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
	public int insertD1DnaSequence(XDnaSequenceSheetObj dnaSequenceSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1DnaSequence( dnaSequenceSheet );
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
	public int insertD1Etc(XEtcSheetObj etcSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
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
	public int insertD1Extraction(XExtractSheetObj extractionSheet) {
		SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertD1Extraction( extractionSheet );
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
    
//
//  @Override
//  public int insertMappedD1Common( D1CommonVO commonSheet ) {
//  	SqlSession session = this.getSessionFactory().openSession( false );
//
//  	int ret = 0;
//  	try {
//  		ret = session.insert( "Kobis.insertMappedD1Common", commonSheet);
//  		session.commit();
//  	}catch(Exception e) {
//  		ret = 0;
//  		e.printStackTrace();
//  		session.rollback();
//  	}finally{
//  		session.close();
//  	}
//  	return ret;
//  }
//  public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomyDetail(Map<String, String> map) {
//	SqlSession session = this.sqlSessionFactory.openSession();
//	List<NameWithTaxonIdVO> result = null;
//	try {
//		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomyDetail", map);
//   	}finally{
//   		session.close();
//   	}   		
//
//	return result;
//}
//public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomyPure(String scientfic_name) {
//	SqlSession session = this.sqlSessionFactory.openSession();
//	List<NameWithTaxonIdVO> result = null;
//	try {
//		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomyPure", scientfic_name);
//   	}finally{
//   		session.close();
//   	}   		
//
//	return result;
//}
}
