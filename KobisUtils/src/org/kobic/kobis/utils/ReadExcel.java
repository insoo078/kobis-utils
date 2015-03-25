package org.kobic.kobis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kobic.kobis.file.excel.obj.internal.ExcelWorksheetNameMap;
import org.kobic.kobis.main.mapper.KobisMapper;
import org.kobic.kobis.main.services.AbstractKobisServices;
import org.kobic.kobis.main.services.CommonServices;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class ReadExcel{
	private SqlSessionFactory sessionFactory;
	
	private String inFile;
	private String output;
	private String header;

	public ReadExcel() {
		this.inFile = null;
		this.output = null;
		this.header = null;

		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void run( String[] args ) {
		if( this.checkParameters(args) ) {
			try {
				this.readExcelFile( this.inFile, this.output, this.header );
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean checkParameters( String[] args ) {
		for(int i=0; i<args.length-1; i+=2) {
			if( args[i].equals("-i") || args[i].equals("-I") ) {
				this.inFile = args[i+1];
			}else if( args[i].equals("-o") || args[i].equals("-O") ) {
				this.output = args[i+1];
			}else if( args[i].equals("-header") ) {
				this.header = args[i+1];
			}else {
				System.err.println("Your option is not valid : " + args[i]);
				ReadExcel.usage();
				return false;
			}
		}

		if( this.output == null ) {	this.output = ".";		}
		if( this.header == null ) {	this.header = "none";	}
		if( this.inFile == null ) {
			System.err.println("You did not input a excel file : " + inFile);
			ReadExcel.usage();
			return false;
		}else if( !new File(this.inFile).exists() ) {
			System.err.println("There are no a excel file : " + inFile);
			ReadExcel.usage();
			return false;
		}

		if( !new File(this.output).isDirectory() ) {
			System.err.println("Output you input is not a directory : " + output);
			ReadExcel.usage();
			return false;
		}
		
		System.out.println("Checking institution code....");
		KobisMapper kobisMapper = this.sessionFactory.openSession().getMapper( KobisMapper.class );
		if( kobisMapper.getInstitutionId(header) == null ) {
			System.err.println( header + "는 기관코드가 아닙니다." );
			return false;
		}
		System.out.println("Pass : check institution code....");
		
		return true;
	}

	public void readExcelFile( String filePath, String output, String header ) throws Exception{

		File exelFile = new File( filePath );

		InputStream inp = new FileInputStream( exelFile );

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook( inp );  

		// Loop for worksheet
		for(int i=0; i<workbook.getNumberOfSheets(); i++) {
			String sheetName = workbook.getSheetName(i);

			XSSFSheet sheet = workbook.getSheetAt( i );

			String className = ExcelWorksheetNameMap.getInstance().getClassNameFromSheetName( sheetName );
  
			if( className != null ) {
				@SuppressWarnings("rawtypes")
				Class c = Class.forName(className);

				@SuppressWarnings({ "unchecked", "rawtypes" })
				Constructor cons = c.getConstructor( new Class[]{String.class, XSSFSheet.class, SqlSessionFactory.class} );

				Object obj = cons.newInstance( header, sheet, this.sessionFactory );
				
				AbstractKobisServices ks = (AbstractKobisServices) obj;
				
				if( ks instanceof CommonServices);
				else								continue;

				ks.readRecordsInSheet();
			}
		}

		inp.close();
	}

	public static void usage() {
		System.err.println("####################################");
		System.err.println("java ReadExel -i [input file] -o [output directory] -header header prefix");
	}

	public static void main( String[] args ) throws IOException {
//		String output = "/Users/lion/Desktop";
//		String inFile = "/Users/lion/Desktop/20150227_KOBIS_정보연계표준안_수정_ver9_한국식물추출물은행.xlsx";
//		String header = "cov";

//		-o /Users/lion/Desktop -i /Users/lion/git/kobis-utils/KobisUtils/sample/20150227_KOBIS_정보연계표준안_수정_ver9_한국식물추출물은행.xlsx -header INS00001

		String[][] params = new String[][]{
//				{"-o", "/Users/insoo078/Desktop", "-i", "/Users/insoo078/git/kobis-utils/KobisUtils/sample/20150227_KOBIS_정보연계표준안_수정_ver9_한국식물추출물은행.xlsx", "-header", "INS00001"},
				{"-o", "/Users/lion/Desktop", "-i", "/Users/lion/git/kobis-utils/KobisUtils/sample/20150227_KOBIS_정보연계표준안_수정_ver9_한국식물추출물은행.xlsx", "-header", "INS00001"},
				{"-o", "/Users/lion/Desktop", "-i", "/Users/lion/git/kobis-utils/KobisUtils/sample/KOBIS_정보연계표준안_수정_ver9_KCTC_Sample.xlsx", "-header", "INS00002"},
				{"-o", "/Users/lion/Desktop", "-i", "/Users/lion/git/kobis-utils/KobisUtils/sample/KOBIS_정보연계표준안_수정_국가영장류센터_KOBIS수정본.xlsx", "-header", "INS00003"},
				{"-o", "/Users/lion/Desktop", "-i", "/Users/lion/git/kobis-utils/KobisUtils/sample/KOBIS_정보연계표준안_유전자은행_KOBIS수정본.xlsx", "-header", "INS00004"}
		};

		for(int i=0; i<params.length; i++) {
			ReadExcel read = new ReadExcel();
			try {
				System.out.println( params[i][5] + " processing");
				read.run( params[i] );
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}