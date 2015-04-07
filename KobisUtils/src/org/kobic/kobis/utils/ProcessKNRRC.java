package org.kobic.kobis.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.knnrrc.services.KnnrrcServices;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class ProcessKNRRC {
	private static Logger logger = Logger.getLogger( ProcessKNRRC.class ); 

	private SqlSessionFactory sessionFactory;
	
	public ProcessKNRRC() {
		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public void doSomething(String insCd) throws NoSuchMethodException, SecurityException, Exception {
		KnnrrcServices service = new KnnrrcServices( insCd, this.sessionFactory );
		service.read();
	}

	public static void main( String[] args ) {
		ProcessKNRRC proc = new ProcessKNRRC();
		
		try {
			proc.doSomething( "INS00006" );
		}catch(Exception e) {
			logger.error( e.getMessage() );
		}
	}
}