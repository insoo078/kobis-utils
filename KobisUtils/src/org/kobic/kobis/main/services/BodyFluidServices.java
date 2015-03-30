package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XBodyFluidSheetObj;
import org.kobic.kobis.main.vo.D1BodyFluidVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.util.Utils;

public class BodyFluidServices  extends AbstractKobisServices{

	public BodyFluidServices(String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory) {
		super(insCd, sheet, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		if( this.getSheet().getLastRowNum() > 3 ) {
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XBodyFluidSheetObj bodyFluidSheetRecordObj = XBodyFluidSheetObj.getNewInstance( dataRow );

				D1BodyFluidVO d1BodyFluidVo = new D1BodyFluidVO( bodyFluidSheetRecordObj );
				
				Rule rule = new Rule( this.getInsCd() );
				rule.rule( d1BodyFluidVo );

				String accessionNumFromMapTab	= Utils.nullToEmpty( this.getKobisService().getAccessionNum( d1BodyFluidVo.getAccess_num(), this.getInsCd() ) );
				String accessionNumFromUnmapTab	= Utils.nullToEmpty( this.getUnmapService().getAccessionNum( d1BodyFluidVo.getAccess_num(), this.getInsCd() ) );

				if( !accessionNumFromMapTab.isEmpty() && accessionNumFromUnmapTab.isEmpty() ) {
					this.getKobisService().insertD1BodyFluid( d1BodyFluidVo );
				}else if( accessionNumFromMapTab.isEmpty() && !accessionNumFromUnmapTab.isEmpty() ) {
					this.getUnmapService().insertT2UnmappedBodyFluid( d1BodyFluidVo );
				}
			}
		}
	}

}
