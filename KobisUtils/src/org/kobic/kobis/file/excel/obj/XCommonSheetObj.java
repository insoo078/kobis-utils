package org.kobic.kobis.file.excel.obj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;

public class XCommonSheetObj extends AbstractSheetObj{
	private String family;
	private String genus;
	private String subgenus;
	private String species;
	private String synonym;
	private String common_name;
	private String kor_name;
	private String in_species_type;
	private String in_species_name;
	private String line_name;
	private String variety_name;
	private String taxonomy;
	private String institution;
	private String category_1;
	private String category_2;
	private String category_3;
	private String detail_url;
	private String gene_name;
	private String accession_no;
	private String sequence;
	private String keywords;
	private String img_url_1;
	private String ins_user_email;
	
	public String getScientificName() {
		return this.genus.trim() + " " + this.species.trim();
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

	public String getSubgenus() {
		return subgenus;
	}

	public void setSubgenus(String subgenus) {
		this.subgenus = subgenus;
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

	public String getCommon_name() {
		return common_name;
	}

	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}

	public String getKor_name() {
		return kor_name;
	}

	public void setKor_name(String kor_name) {
		this.kor_name = kor_name;
	}

	public String getIn_species_type() {
		return in_species_type;
	}

	public void setIn_species_type(String in_species_type) {
		this.in_species_type = in_species_type;
	}

	public String getIn_species_name() {
		return in_species_name;
	}

	public void setIn_species_name(String in_species_name) {
		this.in_species_name = in_species_name;
	}

	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public String getVariety_name() {
		return variety_name;
	}

	public void setVariety_name(String variety_name) {
		this.variety_name = variety_name;
	}

	public String getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getCategory_1() {
		return category_1;
	}

	public void setCategory_1(String category_1) {
		this.category_1 = category_1;
	}

	public String getCategory_2() {
		return category_2;
	}

	public void setCategory_2(String category_2) {
		this.category_2 = category_2;
	}

	public String getCategory_3() {
		return category_3;
	}

	public void setCategory_3(String category_3) {
		this.category_3 = category_3;
	}

	public String getDetail_url() {
		return detail_url;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public String getGene_name() {
		return gene_name;
	}

	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}

	public String getAccession_no() {
		return accession_no;
	}

	public void setAccession_no(String accession_no) {
		this.accession_no = accession_no;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getImg_url_1() {
		return img_url_1;
	}

	public void setImg_url_1(String img_url_1) {
		this.img_url_1 = img_url_1;
	}

	public String getIns_user_email() {
		return ins_user_email;
	}

	public void setIns_user_email(String ins_user_email) {
		this.ins_user_email = ins_user_email;
	}

	public static XCommonSheetObj getNewInstance(XSSFRow row) {
		return new XCommonSheetObj().getInstance(row);
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getFamily() + ",";
		line += this.getGenus() + ",";
		line += this.getSubgenus() + ",";
		line += this.getSpecies() + ",";
		line += this.getSynonym() + ",";
		line += this.getCommon_name() + ",";
		line += this.getKor_name() + ",";
		line += this.getIn_species_type() + ",";
		line += this.getIn_species_name() + ",";
		line += this.getLine_name() + ",";
		line += this.getVariety_name() + ",";
		line += this.getTaxonomy() + ",";
		line += this.getInstitution() + ",";
		line += this.getCategory_1() + ",";
		line += this.getCategory_2() + ",";
		line += this.getCategory_3() + ",";
		line += this.getDetail_url() + ",";
		line += this.getGene_name() + ",";
		line += this.getAccession_no() + ",";
		line += this.getSequence() + ",";
		line += this.getKeywords() + ",";
		line += this.getImg_url_1() + ",";
		line += this.getIns_user_email() + ",";
		
		return line;
	}

//	private String getVal( XSSFCell cell ) {
//		String ret = "";
////		if( cell != null ) ret = Utils.nullToEmpty( cell.toString() ).replace("\'", "\\\'");
//		if( cell != null ) ret = Utils.nullToEmpty( cell.toString() ).replaceAll("'","\\\\'");
//		
//		return ret;
//	}

	@Override
	public XCommonSheetObj getInstance( XSSFRow row ) {
		XCommonSheetObj obj = new XCommonSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(		this.getVal( row.getCell(i) ) );
			else if( i == 1 )	obj.setFamily(			this.getVal( row.getCell(i) ) );
			else if( i == 2 )	obj.setGenus(			this.getVal( row.getCell(i) ) );
			else if( i == 3 )	obj.setSubgenus(		this.getVal( row.getCell(i) ) );
			else if( i == 4 )	obj.setSpecies(			this.getVal( row.getCell(i) ) );
			else if( i == 5 )	obj.setSynonym(			this.getVal( row.getCell(i) ) );
			else if( i == 6 )	obj.setCommon_name(		this.getVal( row.getCell(i) ) );
			else if( i == 7 )	obj.setKor_name(		this.getVal( row.getCell(i) ) );
			else if( i == 8 )	obj.setIn_species_type(	this.getVal( row.getCell(i) ) );
			else if( i == 9 )	obj.setIn_species_name(	this.getVal( row.getCell(i) ) );
			else if( i == 10 )	obj.setLine_name(		this.getVal( row.getCell(i) ) );
			else if( i == 11 )	obj.setVariety_name(	this.getVal( row.getCell(i) ) );
			else if( i == 12 )	obj.setTaxonomy(		this.getVal( row.getCell(i) ) );
			else if( i == 13 )	obj.setInstitution(		this.getVal( row.getCell(i) ) );
			else if( i == 14 )	obj.setCategory_1(		this.getVal( row.getCell(i) ) );
			else if( i == 15 )	obj.setCategory_2(		this.getVal( row.getCell(i) ) );
			else if( i == 16 )	obj.setCategory_3(		this.getVal( row.getCell(i) ) );
			else if( i == 17 )	obj.setDetail_url(		this.getVal( row.getCell(i) ) );
			else if( i == 18 )	obj.setGene_name(		this.getVal( row.getCell(i) ) );
			else if( i == 19 )	obj.setAccession_no(	this.getVal( row.getCell(i) ) );
			else if( i == 20 )	obj.setSequence(		this.getVal( row.getCell(i) ) );
			else if( i == 21 )	obj.setKeywords(		this.getVal( row.getCell(i) ) );
			else if( i == 22 )	obj.setImg_url_1(		this.getVal( row.getCell(i) ) );
			else if( i == 23 )	obj.setIns_user_email(	this.getVal( row.getCell(i) ) );
		}
		return obj;
	} 
}
