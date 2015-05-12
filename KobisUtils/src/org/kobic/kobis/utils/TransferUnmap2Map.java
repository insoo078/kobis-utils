package org.kobic.kobis.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;
import org.kobic.kobis.unmap2map.services.Unmap2MapServices;

public class TransferUnmap2Map {
	private static Logger logger = Logger.getLogger( TransferUnmap2Map.class ); 

	private SqlSessionFactory sessionFactory;
	
	public TransferUnmap2Map() {
		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public void doSomething() throws NoSuchMethodException, SecurityException, Exception {
		Unmap2MapServices service = new Unmap2MapServices( this.sessionFactory );
		service.read();
	}

	public static void main( String[] args ) {
		TransferUnmap2Map proc = new TransferUnmap2Map();
		
		try {
			proc.doSomething();
		}catch(Exception e) {
			logger.error( e.getMessage() );
		}
	}
}