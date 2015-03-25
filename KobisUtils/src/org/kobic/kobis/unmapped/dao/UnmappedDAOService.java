package org.kobic.kobis.unmapped.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.main.mapper.KobisMapper;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.unmapped.mapper.UnmappedMapper;
import org.kobic.kobis.util.Utils;

public class UnmappedDAOService extends CommonDAOService implements UnmappedDAO{
	public UnmappedDAOService(SqlSessionFactory sqlSessionFactory){
		super(sqlSessionFactory);
	}

	@Override
	public int insertUnmappedD1Common( D1CommonVO commonSheet ) {
    	SqlSession session = this.getSessionFactory().openSession( false );

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
    @Override
    public String getAccessionNum(String accession_num, String ins_cd) {
    	SqlSession session = this.getSessionFactory().openSession();
    	String result = null;
    	try {
    		KobisMapper kobisMapper = session.getMapper( KobisMapper.class );
    		Map<String, String> map = new HashMap<String, String>();
    		map.put("accession_num", accession_num);
    		map.put("ins_cd", ins_cd);

    		result = kobisMapper.getAccessionNum( map );
	   	}finally{
	   		session.close();
	   	}
    	
    	return Utils.emptyToNull( result );
    }
}
