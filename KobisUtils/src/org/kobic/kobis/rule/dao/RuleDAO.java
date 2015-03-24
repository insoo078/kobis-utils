package org.kobic.kobis.rule.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.rule.vo.RuleQueryVO;

public class RuleDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public RuleDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<RuleQueryVO> getRulesByInsId( String ins_id, String className ) {
    	List<RuleQueryVO> list = null;
    	// autocommit is false
    	SqlSession session = this.sqlSessionFactory.openSession( false );

    	Map<String, String> map = new HashMap<String, String>();
    	map.put( "ins_cd", ins_id );
    	map.put( "className", className);

    	try {
    		 list = session.selectList("Rule.getRulesByInsId", map );
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally{
    		session.close();
    	}
    	return list;
    }
}
