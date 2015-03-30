package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.main.dao.KobisDAOService;
import org.kobic.kobis.unmapped.dao.UnmappedDAOService;

public abstract class AbstractKobisServices {
	private String insCd;
	private XSSFSheet sheet;
//	private KobisDAO dao;
	private SqlSessionFactory sessionFactory;
	
	private KobisDAOService kobisService;
	private UnmappedDAOService unmapService;
	
	public AbstractKobisServices( String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory ) {
		this.insCd = insCd;
		this.sheet = sheet;
		this.sessionFactory = sessionFactory;
		
		this.kobisService = new KobisDAOService( this.getSessionFactory() );
		this.unmapService = new UnmappedDAOService( this.getSessionFactory() );
//		this.dao = dao;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

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
	
	

	public KobisDAOService getKobisService() {
		return kobisService;
	}

	public UnmappedDAOService getUnmapService() {
		return unmapService;
	}

	public abstract void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception;
}
