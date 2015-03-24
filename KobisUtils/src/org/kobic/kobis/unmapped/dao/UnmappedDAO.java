package org.kobic.kobis.unmapped.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;

public class UnmappedDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public UnmappedDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<PhylogeneticTreeVO> getPhylogeneticTreeByGenus( String genus) {
    	List<PhylogeneticTreeVO> list = null;
    	// autocommit is false
    	SqlSession session = this.sqlSessionFactory.openSession();

    	try {
    		 list = session.selectList("UnMap.getPhylogeneticTreeByGenus", genus );
    	}finally{
    		session.close();
    	}
    	return list;
    }
}
