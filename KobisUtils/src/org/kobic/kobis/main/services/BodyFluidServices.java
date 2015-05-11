package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XBodyFluidSheetObj;
import org.kobic.kobis.main.vo.D1BodyFluidVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.util.Utils;
import org.kobic.kobis.utils.ReadExcel;

public class BodyFluidServices  extends AbstractKobisServices{
	private static Logger logger = Logger.getLogger(BodyFluidServices.class); 

	public BodyFluidServices(String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory) {
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

				XBodyFluidSheetObj bodyFluidSheetRecordObj = XBodyFluidSheetObj.getNewInstance( dataRow );

				if( Utils.nullToEmpty( bodyFluidSheetRecordObj.getAccess_num() ).isEmpty() )	continue;
				
				D1BodyFluidVO vo = new D1BodyFluidVO( bodyFluidSheetRecordObj );
				
				Rule rule = new Rule( this.getInsCd() );
				rule.rule( vo );

//				String accessionNumFromMapTab	= Utils.nullToEmpty( this.getKobisService().getAccessionNum( d1BodyFluidVo.getAccess_num(), this.getInsCd() ) );
//
//				if( !accessionNumFromMapTab.isEmpty() ) {
//					this.getKobisService().insertD1BodyFluid( d1BodyFluidVo, this.getInsCd() );
//				}else {
//					this.getUnmapService().insertT2UnmappedBodyFluid( d1BodyFluidVo );
//				}
				
				int uid = this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() );
				vo.setUid( uid );

				if( uid > 0 )	this.getKobisService().insertD1BodyFluid( vo, this.getInsCd() );
				else {
					uid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );
					vo.setUid( uid );

					if( uid > 0 )	this.getUnmapService().insertT2UnmappedBodyFluid(vo);
					else			logger.error( vo.getAccess_num() + " is not assigned ");
				}
				
				System.out.println( "("+totalCnt + "/" + (this.getSheet().getLastRowNum() - 3) + ")");
				totalCnt++;
			}
		}
	}

}
