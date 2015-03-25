package org.kobic.kobis.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
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
    public String getAccessionNum(String accession_num) {
    	SqlSession session = this.getSessionFactory().openSession();
    	String result = null;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		result = kobisMapper.getAccessionNum(accession_num);
	   	}finally{
	   		session.close();
	   	}
    	
    	return Utils.emptyToNull( result );
    }
    @Override
    public int insertD1Common( D1CommonVO d1CommonVo, Map<String, String> crossTaxonMap ) {
    	SqlSession session = this.getSessionFactory().openSession( false );

    	TaxonMapper taxonMapper = session.getMapper( TaxonMapper.class );
    	int ret = 0;
    	try {
    		String tab_id = taxonMapper.getT1ClassificationSystemTable( crossTaxonMap );

    		if( Utils.nullToEmpty( tab_id ).isEmpty() ) {
    			// 만약 T1_ClassificationSystemTable에 값이 존재하지 않는 경우 테이블에 데이터 등록후 등록번호 가져옴
    			ret += session.insert( "org.kobic.kobis.taxon.mapper.TaxonMapper.insertT1ClassificationSystemTable", crossTaxonMap);

    			tab_id = taxonMapper.getT1ClassificationSystemTable( crossTaxonMap );
    			
        		d1CommonVo.setCode( tab_id );
    		}
    		if( !Utils.nullToEmpty( tab_id ).isEmpty() ) {
    			ret = session.insert( "org.kobic.kobis.main.mapper.KobisMapper.insertD1Common", d1CommonVo );

	    		if( !Utils.nullToEmpty( d1CommonVo.getSynonym().trim() ).isEmpty() ) {
	    			session.insert( "org.kobic.kobis.main.mapper.KobisMapper.insertSynonyms", d1CommonVo );
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

    @Override
    public int insertObservation( XObservationSheetObj observationSheet ) {
    	SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		ret = kobisMapper.insertObservation(observationSheet);
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
