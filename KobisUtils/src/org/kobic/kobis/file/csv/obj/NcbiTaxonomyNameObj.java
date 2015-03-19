package org.kobic.kobis.file.csv.obj;

public class NcbiTaxonomyNameObj {
	private String tax_id;
	private String name_txt;
	private String unique_name;
	private String name_class;
	
	public NcbiTaxonomyNameObj(String[] line) {
		if( line.length == 5 ) {
			this.tax_id = line[0];
			this.name_txt = line[1];
			this.unique_name = line[2];
			this.name_class = line[3];
		}
	}

	public String getTax_id() {
		return tax_id;
	}
	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}
	public String getName_txt() {
		return name_txt;
	}
	public void setName_txt(String name_txt) {
		this.name_txt = name_txt;
	}
	public String getUnique_name() {
		return unique_name;
	}
	public void setUnique_name(String unique_name) {
		this.unique_name = unique_name;
	}
	public String getName_class() {
		return name_class;
	}
	public void setName_class(String name_class) {
		this.name_class = name_class;
	}
}
