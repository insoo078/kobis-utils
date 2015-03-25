package org.kobic.kobis.common.dao;

import org.apache.ibatis.session.SqlSessionFactory;

public class CommonDAOService {
	private SqlSessionFactory sqlSessionFactory = null;

	public CommonDAOService(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public SqlSessionFactory getSessionFactory() {
		return this.sqlSessionFactory;
	}
}
