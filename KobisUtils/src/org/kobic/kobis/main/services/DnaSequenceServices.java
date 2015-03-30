package org.kobic.kobis.main.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XDnaSequenceSheetObj;
import org.kobic.kobis.main.vo.D1DnaSequenceVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.util.Utils;

public class DnaSequenceServices extends AbstractKobisServices{

	public DnaSequenceServices(String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory) {
		super(insCd, sheet, sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		if( this.getSheet().getLastRowNum() > 3 ) {
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XDnaSequenceSheetObj sheetRecordObj = XDnaSequenceSheetObj.getNewInstance( dataRow );

				D1DnaSequenceVO d1DnaSequenceVo = new D1DnaSequenceVO( sheetRecordObj );
				
				Rule rule = new Rule( this.getInsCd() );
				rule.rule( d1DnaSequenceVo );

				String accessionNumFromMapTab	= Utils.nullToEmpty( this.getKobisService().getAccessionNum( d1DnaSequenceVo.getAccess_num(), this.getInsCd() ) );
				String accessionNumFromUnmapTab	= Utils.nullToEmpty( this.getUnmapService().getAccessionNum( d1DnaSequenceVo.getAccess_num(), this.getInsCd() ) );

				if( !accessionNumFromMapTab.isEmpty() && accessionNumFromUnmapTab.isEmpty() ) {
					this.getKobisService().insertD1DnaSequence(d1DnaSequenceVo);
				}else if( accessionNumFromMapTab.isEmpty() && !accessionNumFromUnmapTab.isEmpty() ) {
					this.getUnmapService().insertT2UnmappedDnaSequence(sheetRecordObj);
				}
			}
		}
	}

}
