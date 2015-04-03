package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XOrganSheetObj;
import org.kobic.kobis.main.vo.D1OrganVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.util.Utils;

public class OrganServices extends AbstractKobisServices{

	public OrganServices(String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory) {
		super(insCd, sheet, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException,
			SecurityException, Exception {
		// TODO Auto-generated method stub
		if( this.getSheet().getLastRowNum() > 3 ) {
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XOrganSheetObj sheetRecordObj = XOrganSheetObj.getNewInstance( dataRow );

				D1OrganVO vo = new D1OrganVO( sheetRecordObj );
				
				Rule rule = new Rule( this.getInsCd() );
				rule.rule( vo );

				String accessionNumFromMapTab	= Utils.nullToEmpty( this.getKobisService().getAccessionNum( vo.getAccess_num(), this.getInsCd() ) );
				
				if( !accessionNumFromMapTab.isEmpty() ) {
					this.getKobisService().insertD1Organ( vo, this.getInsCd() );
				}else {
					this.getUnmapService().insertT2UnmappedOrgan( sheetRecordObj );
				}

//				String accessionNumFromUnmapTab	= Utils.nullToEmpty( this.getUnmapService().getAccessionNum( vo.getAccess_num(), this.getInsCd() ) );
//
//				if( !accessionNumFromMapTab.isEmpty() && accessionNumFromUnmapTab.isEmpty() ) {
//					this.getKobisService().insertD1Organ( vo );
//				}else if( accessionNumFromMapTab.isEmpty() && !accessionNumFromUnmapTab.isEmpty() ) {
//					this.getUnmapService().insertT2UnmappedOrgan( sheetRecordObj );
//				}
			}
		}
	}

}
