package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XExtractSheetObj;
import org.kobic.kobis.main.dao.KobisDAOService;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.unmapped.dao.UnmappedDAOService;
import org.kobic.kobis.util.Utils;

public class ExtractServices extends AbstractKobisServices{
	private KobisDAOService kobisService;
	private UnmappedDAOService unmapService;

	public ExtractServices(String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory) {
		super(insCd, sheet, sessionFactory);
		// TODO Auto-generated constructor stub
		
		this.kobisService = new KobisDAOService( this.getSessionFactory() );
		this.unmapService = new UnmappedDAOService( this.getSessionFactory() );
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

				String accessionNumFromMapTab = Utils.nullToEmpty( this.kobisService.getAccessionNum( extractSheetRecordObj.getAccess_num(), this.getInsCd() ) );
				String accessionNumFromUnmapTab = Utils.nullToEmpty( this.unmapService.getAccessionNum( extractSheetRecordObj.getAccess_num(), this.getInsCd() ) );

				if( !accessionNumFromMapTab.isEmpty() && accessionNumFromUnmapTab.isEmpty() ) {
					this.kobisService.insertD1Extraction( extractSheetRecordObj );
				}else if( accessionNumFromMapTab.isEmpty() && !accessionNumFromUnmapTab.isEmpty() ) {
//					this.unmapService.insert
				}
			}
		}
	}
}
