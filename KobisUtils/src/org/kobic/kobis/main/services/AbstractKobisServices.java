package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public abstract class AbstractKobisServices {
	private String insCd;
	private XSSFSheet sheet;
//	private KobisDAO dao;
	private SqlSessionFactory sessionFactory;
	
	public AbstractKobisServices( String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory ) {
		this.insCd = insCd;
		this.sheet = sheet;
		this.sessionFactory = sessionFactory;
//		this.dao = dao;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

//	public KobisDAO getDao() {
//		return dao;
//	}
//
//	public void setDao(KobisDAO dao) {
//		this.dao = dao;
//	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String getInsCd() {
		return insCd;
	}

	public void setInsCd(String insCd) {
		this.insCd = insCd;
	}

	public abstract void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception;
}
