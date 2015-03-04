package org.kobic.kobis.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.mybatis.db.vo.RuleVO;

public class RuleDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public RuleDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<RuleVO> getRulesByInsId( String ins_id) {
    	List<RuleVO> list = null;
    	// autocommit is false
    	SqlSession session = this.sqlSessionFactory.openSession( false );

    	try {
    		 list = session.selectList("Rule.getRulesByInsId", ins_id );
    	}finally{
    		session.close();
    	}
    	return list;
    }
}
