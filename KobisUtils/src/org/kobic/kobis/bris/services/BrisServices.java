package org.kobic.kobis.bris.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.services.AbstractCommonServices;

public class BrisServices extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(BrisServices.class);
	
	public BrisServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
	}

	public void read() throws NoSuchMethodException, SecurityException, Exception {
	}
}
