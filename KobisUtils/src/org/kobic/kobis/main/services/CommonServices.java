package org.kobic.kobis.main.services;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XCommonSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
//import org.kobic.kobis.mybatis.db.vo.NameWithTaxonIdVO;
import org.kobic.kobis.rule.Rule;
//import org.kobic.kobis.util.Utils;
import org.kobic.kobis.taxon.proc.MultipleClassificationProc;

public class CommonServices extends AbstractKobisServices{
	private static Logger logger = Logger.getLogger(CommonServices.class);

	public CommonServices( String insCd, XSSFSheet sheet, SqlSessionFactory sessionFactory ) {
		super( insCd, sheet, sessionFactory );
	}
	
	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception {
//		BufferedWriter bw = new BufferedWriter( new FileWriter("/Users/lion/Desktop/" + this.getInsCd() ) );

		if( this.getSheet().getLastRowNum() > 3 ) {
			int totalCnt = 0;
			int mappedCnt = 0;
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XCommonSheetObj commonSheetRecordObj = XCommonSheetObj.getNewInstance( dataRow );
				
//				String accession_num = Utils.nullToEmpty( this.getKobisService().getAccessionNum( commonSheetRecordObj.getAccess_num(), this.getInsCd() ) );
//				String unaccession_num = Utils.nullToEmpty( this.getUnmapService().getAccessionNum( commonSheetRecordObj.getAccess_num(), this.getInsCd() ) );
//
//				if( accession_num.isEmpty() && unaccession_num.isEmpty() ) {
					D1CommonVO d1CommonVo = new D1CommonVO( commonSheetRecordObj );
					d1CommonVo.setIns_cd( this.getInsCd() );
	
					// Rule 적용
					Rule rule = new Rule( d1CommonVo.getIns_cd() );
					rule.rule( d1CommonVo );
	
					String scientificName = d1CommonVo.getScientificName();
					
					MultipleClassificationProc classifyObj = new MultipleClassificationProc( this.getSessionFactory() );
	
					classifyObj.validate( scientificName );
	
					boolean canValidateToDatabase = classifyObj.updateDatabase( d1CommonVo, scientificName );
					if ( canValidateToDatabase ){	mappedCnt++;	}
//				}

				System.out.println( "("+totalCnt + "/" + this.getSheet().getLastRowNum() + ")");
				totalCnt++;
			}
//			bw.close();

			System.out.println( "=======================================================" );
			System.out.println( "== Total records : " + totalCnt);
			System.out.println( "== Mapped records : " + mappedCnt);
			System.out.println( "== Unmapped records : " + (totalCnt-mappedCnt) );
			System.out.println( "== Mapping ratio : " + ((double)mappedCnt/totalCnt) + "%");
			System.out.println( "=======================================================" );
		}
	}
}