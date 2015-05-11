package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.main.vo.D1CellStrainVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.util.Utils;

public class CellStrainServices extends AbstractKobisServices{
	private static Logger logger = Logger.getLogger(CellStrainServices.class);

	public CellStrainServices(String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory) {
		super(insCd, sheet, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		if( this.getSheet().getLastRowNum() > 3 ) {
			int totalCnt = 0;

			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XCellStrainSheetObj cellStrainSheetRecordObj = XCellStrainSheetObj.getNewInstance( dataRow );
				
				if( Utils.nullToEmpty( cellStrainSheetRecordObj.getAccess_num() ).isEmpty() )	continue;

				D1CellStrainVO vo = new D1CellStrainVO( cellStrainSheetRecordObj );
				
				Rule rule = new Rule( this.getInsCd() );
				rule.rule( vo );

//				String accessionNumFromMapTab	= Utils.nullToEmpty( this.getKobisService().getAccessionNum( d1CellStrainVo.getAccess_num(), this.getInsCd() ) );
//				
//				if( !accessionNumFromMapTab.isEmpty() ) {
//					this.getKobisService().insertD1CellStrain( d1CellStrainVo, this.getInsCd() );
//				}else {
//					this.getUnmapService().insertT2UnmappedCellStrain( d1CellStrainVo );
//				}
				
				int uid = this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() );
				vo.setUid( uid );

				if( uid > 0 )	this.getKobisService().insertD1CellStrain( vo, this.getInsCd() );
				else {
					uid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );
					vo.setUid( uid );

					if( uid > 0 )	this.getUnmapService().insertT2UnmappedCellStrain(vo);
					else			logger.error( vo.getAccess_num() + " is not assigned ");
				}
				
				System.out.println( "("+totalCnt + "/" + (this.getSheet().getLastRowNum() -3) + ")");
				totalCnt++;
			}
		}
	}
}
