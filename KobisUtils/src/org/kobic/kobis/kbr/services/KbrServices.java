package org.kobic.kobis.kbr.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.services.AbstractCommonServices;

public class KbrServices  extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(KbrServices.class);
	
	public KbrServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
	}

	public void read() throws NoSuchMethodException, SecurityException, Exception {
	}

}
