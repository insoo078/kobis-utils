package org.kobic.kobis.main.services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.main.dao.KobisDAO;

public class StructureServices extends AbstractKobisServices{

	public StructureServices(String insCd, XSSFSheet sheet, KobisDAO dao) {
		super(insCd, sheet, dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException,
			SecurityException, Exception {
		// TODO Auto-generated method stub
		
	}

}
