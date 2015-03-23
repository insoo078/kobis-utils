package org.kobic.kobis.taxon.vo;

public class T1ClassificationSystemVO {
	private String tab_id;
	private String KOBIC_CODE;
	private String ncbi_tax_id;
	private String itis_tax_id;
	private String gbif_tax_id;
	private String scientific_name;

	public T1ClassificationSystemVO(String KOBIC_CODE, String ncbi_tax_id, String itis_tax_id, String gbif_tax_id, String scientific_name) {
		this.KOBIC_CODE = KOBIC_CODE;
		this.ncbi_tax_id = ncbi_tax_id;
		this.itis_tax_id = itis_tax_id;
		this.gbif_tax_id = gbif_tax_id;
		this.scientific_name = scientific_name;
	}
	
	public String getTab_id() {
		return tab_id;
	}
	public void setTab_id(String tab_id) {
		this.tab_id = tab_id;
	}
	public String getKOBIC_CODE() {
		return KOBIC_CODE;
	}
	public void setKOBIC_CODE(String kOBIS_CODE) {
		KOBIC_CODE = kOBIS_CODE;
	}
	public String getNcbi_tax_id() {
		return ncbi_tax_id;
	}
	public void setNcbi_tax_id(String ncbi_tax_id) {
		this.ncbi_tax_id = ncbi_tax_id;
	}
	public String getItis_tax_id() {
		return itis_tax_id;
	}
	public void setItis_tax_id(String itis_tax_id) {
		this.itis_tax_id = itis_tax_id;
	}
	public String getGbif_tax_id() {
		return gbif_tax_id;
	}
	public void setGbif_tax_id(String gbif_tax_id) {
		this.gbif_tax_id = gbif_tax_id;
	}
	public String getScientific_name() {
		return scientific_name;
	}
	public void setScientific_name(String scientific_name) {
		this.scientific_name = scientific_name;
	}
}
