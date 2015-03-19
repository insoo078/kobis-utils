package org.kobic.kobis.mybatis.services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.mybatis.dao.KobisDAO;

public class EmbryoServices extends AbstractKobisServices{

	public EmbryoServices(String insCd, XSSFSheet sheet, KobisDAO dao) {
		super(insCd, sheet, dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException,
			SecurityException, Exception {
		// TODO Auto-generated method stub
		
	}

}
