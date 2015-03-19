package org.kobic.kobis.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.mybatis.db.vo.D1CommonVO;
import org.kobic.kobis.mybatis.db.vo.NameWithTaxonIdVO;
import org.kobic.kobis.mybatis.db.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;

public class KobisDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public KobisDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
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

    public List<NameWithTaxonIdVO> getScientificNameFromNcbiTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Kobis.getScientificNameFromNcbiTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   		

    	return result;
    }
    public List<NameWithTaxonIdVO> getScientificNameFromGbifTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	
    	try {
    		result = session.selectList("Kobis.getScientificNameFromGbifTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   	
    	
    	return result;
    }
    public List<NameWithTaxonIdVO> getScientificNameFromItisTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Kobis.getScientificNameFromItisTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}
    	
    	return result;
    }

    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}

    	return result;
    }

    public int insertCommonSheet( D1CommonVO d1CommonVo, Map<String, String> map ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
			// 기존 동일한 분류체계가 T1_ClassificationSystemTable에 존재하는지 여부를 조사
    		String tab_id = session.selectOne("Kobis.getT1ClassificationSystemTable", map);

    		if( tab_id.isEmpty() ) {
    			// 만약 T1_ClassificationSystemTable에 값이 존재하지 않는 경우 테이블에 데이터 등록후 등록번호 가져옴
    			ret += session.insert( "Kobis.insertT1ClassificationSystemTable", map);
    			
    			tab_id = session.selectOne("Kobis.getT1ClassificationSystemTable", map);
    		}
    		d1CommonVo.setCode( tab_id );

    		ret += session.insert( "Kobis.insertD1Common", d1CommonVo );

    		if( Utils.nullToEmpty( d1CommonVo.getSynonym().trim() ).isEmpty() )	
    			ret += session.insert( "Kobis.insertSynonyms", d1CommonVo );

    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
    }

    public int insertUnmappedD1Common( D1CommonVO commonSheet ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertUnmappedD1Common", commonSheet);
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

    public int insertMappedD1Common( D1CommonVO commonSheet ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

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
