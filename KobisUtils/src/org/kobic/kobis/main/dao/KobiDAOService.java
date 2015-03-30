package org.kobic.kobis.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.taxon.vo.NameWithTaxonIdVO;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;

public class KobiDAOService implements KobisDAO{
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public KobiDAOService(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
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
    	SqlSession session = this.sqlSessionFactory.openSession();

    	try {
    		 list = session.selectList("Kobis.getPhylogeneticTreeByGenus", genus );
    	}finally{
    		session.close();
    	}
    	return list;
    }

    @Override
    public String getInstitutionId(String insCd) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	String result = null;
    	try {
        	result = session.selectOne("Kobis.getInstitutionId", insCd);
	   	}finally{
	   		session.close();
	   	}
    	
    	return Utils.emptyToNull( result );
    }
    @Override
    public String getAccessionNum(String accession_num) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	String result = null;
    	try {
        	result = session.selectOne("Kobis.getAccessionNum", accession_num);
	   	}finally{
	   		session.close();
	   	}
    	
    	return Utils.emptyToNull( result );
    }
    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromNcbiTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromNcbiTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   		

    	return result;
    }
    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromGbifTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	
    	try {
    		result = session.selectList("Taxon.getScientificNameFromGbifTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   	
    	
    	return result;
    }
    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromItisTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromItisTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}
    	
    	return result;
    }
    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromKobicTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}

    	return result;
    }
    @Override
    public int insertCommonSheet( D1CommonVO d1CommonVo, Map<String, String> crossTaxonMap ) {
    	SqlSession session = this.sqlSessionFactory.openSession( false );

    	int ret = 0;
    	try {
			// 기존 동일한 분류체계가 T1_ClassificationSystemTable에 존재하는지 여부를 조사
    		String tab_id = session.selectOne("Taxon.getT1ClassificationSystemTable", crossTaxonMap);

    		if( Utils.nullToEmpty( tab_id ).isEmpty() ) {
    			// 만약 T1_ClassificationSystemTable에 값이 존재하지 않는 경우 테이블에 데이터 등록후 등록번호 가져옴
    			ret += session.insert( "Taxon.insertT1ClassificationSystemTable", crossTaxonMap);

    			tab_id = session.selectOne("Taxon.getT1ClassificationSystemTable", crossTaxonMap);
    		}
    		d1CommonVo.setCode( tab_id );

    		ret += session.insert( "Kobis.insertD1Common", d1CommonVo );

    		if( !Utils.nullToEmpty( d1CommonVo.getSynonym().trim() ).isEmpty() )	 {
    			Map<String, String> synonynMap = new HashMap<String, String>();
    			synonynMap.put("accession_num", d1CommonVo.getAccess_num() );
    			synonynMap.put("synonym", d1CommonVo.getSynonym() );

    			ret += session.insert( "Kobis.insertSynonyms", synonynMap );
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
    public int insertMappedD1Common( D1CommonVO commonSheet ) {
    	SqlSession session = this.sqlSessionFactory.openSession( false );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertMappedD1Common", commonSheet);
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
    public int insertObservation( XObservationSheetObj observationSheet ) {
    	SqlSession session = this.sqlSessionFactory.openSession( false );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertObservation", observationSheet );
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

	@Override
	public int insertUnmappedD1Common(D1CommonVO commonSheet) {
		// TODO Auto-generated method stub
		return 0;
	}
}
