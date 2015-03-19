package org.kobic.kobis.mybatis.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.file.csv.obj.GbifObj;
import org.kobic.kobis.file.csv.obj.NcbiTaxonomyNameObj;
import org.kobic.kobis.file.excel.obj.XCommonSheetObj;
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
//    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomyDetail(Map<String, String> map) {
//    	SqlSession session = this.sqlSessionFactory.openSession();
//    	List<NameWithTaxonIdVO> result = null;
//    	try {
//    		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomyDetail", map);
//	   	}finally{
//	   		session.close();
//	   	}   		
//
//    	return result;
//    }
//    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomyPure(String scientfic_name) {
//    	SqlSession session = this.sqlSessionFactory.openSession();
//    	List<NameWithTaxonIdVO> result = null;
//    	try {
//    		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomyPure", scientfic_name);
//	   	}finally{
//	   		session.close();
//	   	}   		
//
//    	return result;
//    }
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
    
    public int insertCommonSheet( XCommonSheetObj commonSheet ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertD1Common", commonSheet);
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

    public int insertTempNCBI( Map<String, String> map) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertTempNCBI", map);
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
    
    public String getT1ClassificationSystemTable( Map<String, String> map ) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	String result = null;

    	try {
    		result = session.selectOne("Kobis.getT1ClassificationSystemTable", map);
	   	}finally{
	   		session.close();
	   	}   	
    	
    	return result;
    }

    public int insertT1ClassificationSystemTable( Map<String, String> map ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertT1ClassificationSystemTable", map);
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
    
    public int deleteTempNCBI() {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
    		ret = session.delete( "Kobis.deleteTempNCBI");
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
    
    public String getTempNCBI( String lineage ) {
    	String result = "";
    	SqlSession session = this.sqlSessionFactory.openSession();
    	try {
	    	Map<String, String> map = new LinkedHashMap<String, String>();
	    	map.put("lineage", lineage);
	    	result = session.selectOne("Kobis.getTempNCBI", map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally{
    		session.close();
    	}
    	

    	return Utils.emptyToNull( result );
    }
    
    
    public int insertTempGBIF( List<GbifObj> list ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {

    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("list", list);

    		ret = session.insert( "Kobis.insertTempGBIF", map );
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
    
    public int insertTempNCBIName( List<NcbiTaxonomyNameObj> list ) {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {

    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("list", list);

    		ret = session.insert( "Kobis.insertTempNCBIName", map );
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
}
