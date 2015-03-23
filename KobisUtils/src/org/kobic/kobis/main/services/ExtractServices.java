package org.kobic.kobis.main.services;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XExtractSheetObj;
import org.kobic.kobis.main.dao.KobisDAO;
import org.kobic.kobis.rule.Rule;

public class ExtractServices extends AbstractKobisServices{

	public ExtractServices(String insCd, XSSFSheet sheet, KobisDAO dao) {
		super(insCd, sheet, dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		if( this.getSheet().getLastRowNum() > 3 ) {
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XExtractSheetObj extractSheetRecordObj = XExtractSheetObj.getNewInstance( dataRow );

				Rule rule = new Rule( this.getInsCd() );
				rule.rule( extractSheetRecordObj );

				String accesssionNumFromDb = this.getDao().getAccessionNum( extractSheetRecordObj.getAccess_num() );
				if( !accesssionNumFromDb.isEmpty() ) {
//					this.getDao().in/
				}
			}
		}
	}
}
