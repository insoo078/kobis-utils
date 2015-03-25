package org.kobic.kobis.rule.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.rule.vo.RuleQueryVO;

public class RuleDAOService extends CommonDAOService implements RuleDAO{
    public RuleDAOService(SqlSessionFactory sqlSessionFactory){
        super( sqlSessionFactory );
    }
    
    @Override
	public List<RuleQueryVO> getRulesByInsId( String ins_id, String className ) {
    	List<RuleQueryVO> list = null;
    	// autocommit is false
    	SqlSession session = this.getSessionFactory().openSession( false );

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
