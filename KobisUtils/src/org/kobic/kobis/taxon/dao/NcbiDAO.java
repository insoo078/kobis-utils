package org.kobic.kobis.taxon.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.file.csv.obj.GbifObj;
import org.kobic.kobis.file.csv.obj.NcbiTaxonomyNameObj;
import org.kobic.kobis.mybatis.db.vo.D1CommonVO;
import org.kobic.kobis.taxon.vo.NameWithTaxonIdVO;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;

public class NcbiDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public NcbiDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int deleteTempNCBI() {
    	SqlSession session = this.sqlSessionFactory.openSession( true );

    	int ret = 0;
    	try {
    		ret = session.delete( "Ncbi.deleteTempNCBI");
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
	    	result = session.selectOne("Ncbi.getTempNCBI", map);
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

    		ret = session.insert( "Ncbi.insertTempGBIF", map );
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

    		ret = session.insert( "Ncbi.insertTempNCBIName", map );
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
