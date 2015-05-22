package org.kobic.kobis.utils;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.bris.services.BrisServices;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class ProcessBRIS {
	private static Logger logger = Logger.getLogger( ProcessKNRRC.class ); 

	private SqlSessionFactory sessionFactory;
	
	
	public ProcessBRIS() {
		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void doSomething( String insCd ) throws NoSuchMethodException, SecurityException, Exception {
		BrisServices service = new BrisServices( insCd, this.sessionFactory );
		
		service.read();
	}

	public static void main(String[] args) {
		ProcessBRIS proc = new ProcessBRIS();
		
		try {
			proc.doSomething( "INS00008" );
		}catch(Exception e) {
			logger.error( e.getMessage() );
		}
	}
}
