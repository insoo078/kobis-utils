package org.kobic.kobis.file.excel.obj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;

public class XCommonSheetObj extends AbstractSheetObj{

	private String kobisCode;

	private String family;
	private String genus;
	private String subGenus;
	private String species;
	private String synonym;
	private String commonName;
	private String koreanName;
	private String inSpeciesType;
	private String inSpeciesName;
	private String lineName;
	private String varietyName;
	private String taxonomy;
	private String institution;
	private String category1;
	private String category2;
	private String category3;
	private String url4DetailInfo;
	private String geneName;
	private String accessionNo;
	private String sequence;
	private String keyword;
	private String imgUrl1;
	private String insUserEmail;
	

	public String getKobisCode() {
		return kobisCode;
	}
	public void setKobisCode(String kobisCode) {
		this.kobisCode = kobisCode;
	}
	public String getTaxonomy() {
		return taxonomy;
	}
	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSubGenus() {
		return subGenus;
	}
	public void setSubGenus(String subGenus) {
		this.subGenus = subGenus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getKoreanName() {
		return koreanName;
	}
	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}
	public String getInSpeciesType() {
		return inSpeciesType;
	}
	public void setInSpeciesType(String inSpeciesType) {
		this.inSpeciesType = inSpeciesType;
	}
	public String getInSpeciesName() {
		return inSpeciesName;
	}
	public void setInSpeciesName(String inSpeciesName) {
		this.inSpeciesName = inSpeciesName;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getVarietyName() {
		return varietyName;
	}
	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public String getCategory3() {
		return category3;
	}
	public void setCategory3(String category3) {
		this.category3 = category3;
	}
	public String getUrl4DetailInfo() {
		return url4DetailInfo;
	}
	public void setUrl4DetailInfo(String url4DetailInfo) {
		this.url4DetailInfo = url4DetailInfo;
	}
	public String getGeneName() {
		return geneName;
	}
	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}
	public String getAccessionNo() {
		return accessionNo;
	}
	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getImgUrl1() {
		return imgUrl1;
	}
	public void setImgUrl1(String imgUrl1) {
		this.imgUrl1 = imgUrl1;
	}
	public String getInsUserEmail() {
		return insUserEmail;
	}
	public void setInsUserEmail(String insUserEmail) {
		this.insUserEmail = insUserEmail;
	}
	
	public static XCommonSheetObj getNewInstance(XSSFRow row) {
		return new XCommonSheetObj().getInstance(row);
	}
	
	public String getPrintLine() {
		String line = this.getKobisCode() + ","; 
		line += this.getAccess_num() + ",";
		line += this.getFamily() + ",";
		line += this.getGenus() + ",";
		line += this.getSubGenus() + ",";
		line += this.getSpecies() + ",";
		line += this.getSynonym() + ",";
		line += this.getCommonName() + ",";
		line += this.getKoreanName() + ",";
		line += this.getInSpeciesType() + ",";
		line += this.getInSpeciesName() + ",";
		line += this.getLineName() + ",";
		line += this.getVarietyName() + ",";
		line += this.getTaxonomy() + ",";
		line += this.getInstitution() + ",";
		line += this.getCategory1() + ",";
		line += this.getCategory2() + ",";
		line += this.getCategory3() + ",";
		line += this.getUrl4DetailInfo() + ",";
		line += this.getGeneName() + ",";
		line += this.getAccessionNo() + ",";
		line += this.getSequence() + ",";
		line += this.getKeyword() + ",";
		line += this.getImgUrl1() + ",";
		line += this.getInsUserEmail() + ",";
		
		return line;
	}

	@Override
	public XCommonSheetObj getInstance( XSSFRow row ) {
		XCommonSheetObj obj = new XCommonSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setFamily( row.getCell(i).toString() );
			else if( i == 2 )	obj.setGenus( row.getCell(i).toString() );
			else if( i == 3 )	obj.setSubGenus( row.getCell(i).toString() );
			else if( i == 4 )	obj.setSpecies( row.getCell(i).toString() );
			else if( i == 5 )	obj.setSynonym( row.getCell(i).toString() );
			else if( i == 6 )	obj.setCommonName( row.getCell(i).toString() );
			else if( i == 7 )	obj.setKoreanName( row.getCell(i).toString() );
			else if( i == 8 )	obj.setInSpeciesType( row.getCell(i).toString() );
			else if( i == 9 )	obj.setInSpeciesName( row.getCell(i).toString() );
			else if( i == 10 )	obj.setLineName( row.getCell(i).toString() );
			else if( i == 11 )	obj.setVarietyName( row.getCell(i).toString() );
			else if( i == 12 )	obj.setTaxonomy( row.getCell(i).toString() );
			else if( i == 13 )	obj.setInstitution( row.getCell(i).toString() );
			else if( i == 14 )	obj.setCategory1( row.getCell(i).toString() );
			else if( i == 15 )	obj.setCategory2( row.getCell(i).toString() );
			else if( i == 16 )	obj.setCategory3( row.getCell(i).toString() );
			else if( i == 17 )	obj.setUrl4DetailInfo( row.getCell(i).toString() );
			else if( i == 18 )	obj.setGeneName( row.getCell(i).toString() );
			else if( i == 19 )	obj.setAccessionNo( row.getCell(i).toString() );
			else if( i == 20 )	obj.setSequence( row.getCell(i).toString() );
			else if( i == 21 )	obj.setKeyword( row.getCell(i).toString() );
			else if( i == 22 )	obj.setImgUrl1( row.getCell(i).toString() );
			else if( i == 23 )	obj.setInsUserEmail( row.getCell(i).toString() );
		}
		return obj;
	}
}
