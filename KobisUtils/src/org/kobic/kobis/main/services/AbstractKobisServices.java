package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.common.services.AbstractCommonServices;

public abstract class AbstractKobisServices extends AbstractCommonServices{
	private XSSFSheet sheet;
	
	public AbstractKobisServices( String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory ) {
		super(insCd, sessionFactory);
		this.sheet = sheet;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	public abstract void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception;
}
