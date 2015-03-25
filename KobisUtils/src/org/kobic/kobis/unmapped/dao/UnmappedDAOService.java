package org.kobic.kobis.unmapped.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.unmapped.mapper.UnmappedMapper;

public class UnmappedDAOService implements UnmappedDAO{
	private SqlSessionFactory sqlSessionFactory = null;

	public UnmappedDAOService(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int insertUnmappedD1Common( D1CommonVO commonSheet ) {
    	SqlSession session = this.sqlSessionFactory.openSession( false );

    	int ret = 0;
    	try {
    		UnmappedMapper unmappedMapper = session.getMapper( UnmappedMapper.class );
    		unmappedMapper.insertUnmappedD1Common(commonSheet);

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
}
