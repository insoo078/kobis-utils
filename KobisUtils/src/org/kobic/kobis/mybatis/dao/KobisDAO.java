package org.kobic.kobis.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
    	String result = session.selectOne("Kobis.getInstitutionId", insCd);
    	
    	return Utils.emptyToNull( result );
    }
}
