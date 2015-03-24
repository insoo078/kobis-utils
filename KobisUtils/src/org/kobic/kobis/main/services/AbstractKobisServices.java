package org.kobic.kobis.main.services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.main.dao.KobisDAO;

public abstract class AbstractKobisServices {
	private String insCd;
	private XSSFSheet sheet;
	private KobisDAO dao;
	
	public AbstractKobisServices( String insCd, XSSFSheet sheet, KobisDAO dao ) {
		this.insCd = insCd;
		this.sheet = sheet;
		this.dao = dao;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	public KobisDAO getDao() {
		return dao;
	}

	public void setDao(KobisDAO dao) {
		this.dao = dao;
	}

	public String getInsCd() {
		return insCd;
	}

	public void setInsCd(String insCd) {
		this.insCd = insCd;
	}

	public abstract void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception;
}
