package org.kobic.kobis.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;
import org.kobic.kobis.naris.services.NarisServices;

public class ProcessNARIS {
	private static Logger logger = Logger.getLogger( ProcessNARIS.class ); 

	private SqlSessionFactory sessionFactory;
	
	public ProcessNARIS() {
		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public void doSomething(String insCd) throws NoSuchMethodException, SecurityException, Exception {
		NarisServices service = new NarisServices( insCd, this.sessionFactory );
		service.read();
	}

	public static void main( String[] args ) {
		ProcessNARIS proc = new ProcessNARIS();
		
		try {
			proc.doSomething( "INS00007" );
		}catch(Exception e) {
			logger.error( e.getMessage() );
		}
	}
}
