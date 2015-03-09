package org.kobic.kobis.mybatis.services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.mybatis.dao.KobisDAO;

public abstract class AbstractKobisServices {
	private String insCd;
	private XSSFSheet sheet;
	private KobisDAO dao;
	
	public AbstractKobisServices( String insCd, XSSFSheet sheet, KobisDAO dao ) {
		this.insCd = insCd;
		this.sheet = sheet;
		this.dao = dao;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	public KobisDAO getDao() {
		return dao;
	}

	public void setDao(KobisDAO dao) {
		this.dao = dao;
	}

	public String getInsCd() {
		return insCd;
	}

	public void setInsCd(String insCd) {
		this.insCd = insCd;
	}

	public abstract void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception;
//	private File rightMappedResult;
//	private File noGenusMapping;
//	private File noSpecies;
//	
//	private String header;
//	private String output;
//	
//	public AbstractKobisServices( String output, String header ) {
//		this.header = header;
//		this.output = output;
//
//		this.noGenusMapping = new File( output + File.separator + this.header + "_no_genus_mapping.csv");
//		this.noSpecies = new File( output + File.separator + this.header + "_no_species_mapping.csv");
//		this.rightMappedResult = new File( output + File.separator + this.header + "_rightMappedResult.csv");
//	}
//
//	public File getRightMappedResult() {
//		return rightMappedResult;
//	}
//
//	public void setRightMappedResult(File rightMappedResult) {
//		this.rightMappedResult = rightMappedResult;
//	}
//
//	public File getNoGenusMapping() {
//		return noGenusMapping;
//	}
//
//	public void setNoGenusMapping(File noGenusMapping) {
//		this.noGenusMapping = noGenusMapping;
//	}
//
//	public File getNoSpecies() {
//		return noSpecies;
//	}
//
//	public void setNoSpecies(File noSpecies) {
//		this.noSpecies = noSpecies;
//	}
//
//	public String getHeader() {
//		return header;
//	}
//
//	public void setHeader(String header) {
//		this.header = header;
//	}
//
//	public String getOutput() {
//		return output;
//	}
//
//	public void setOutput(String output) {
//		this.output = output;
//	}
}
