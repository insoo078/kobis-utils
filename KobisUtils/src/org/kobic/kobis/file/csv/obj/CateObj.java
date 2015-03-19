package org.kobic.kobis.file.csv.obj;

import org.kobic.kobis.utils.KobisCate;

public class CateObj {
	private String code;

	private String kingdom_kor;
	private String kingdom_eng;
	private String phylum_kor;
	private String phylum_eng;
	private String clas_kor;
	private String clas_eng;
	private String order_kor;
	private String order_eng;
	private String family_kor;
	private String family_eng;
	private String genus_kor;
	private String genus_eng;
	private String species_kor;
	private String species_eng;
	private String ssp_kor;
	private String ssp_eng;
	private String var_kor;
	private String var_eng;
	private String f_kor;
	private String f_eng;
	
	public CateObj() {
		this.code = "";
	}

	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getKingdom_kor() {
		return kingdom_kor;
	}


	public void setKingdom_kor(String kingdom_kor) {
		this.kingdom_kor = kingdom_kor;
	}


	public String getKingdom_eng() {
		return kingdom_eng;
	}


	public void setKingdom_eng(String kingdom_eng) {
		this.kingdom_eng = kingdom_eng;
	}

	public void setKingdom(String kingdom) {
		NameObj obj = KobisCate.createName( kingdom );
		this.kingdom_kor = obj.getKor();
		this.kingdom_eng = obj.getEng();
	}
	
	public String getKingdom() {
		return this.kingdom_eng + "|" + this.kingdom_kor;
	}

	public String getPhylum_kor() {
		return phylum_kor;
	}


	public void setPhylum_kor(String phylum_kor) {
		this.phylum_kor = phylum_kor;
	}


	public String getPhylum_eng() {
		return phylum_eng;
	}


	public void setPhylum_eng(String phylum_eng) {
		this.phylum_eng = phylum_eng;
	}
	
	public void setPhylum(String phylum) {
		NameObj obj = KobisCate.createName( phylum );
		this.phylum_kor = obj.getKor();
		this.phylum_eng = obj.getEng();
	}
	
	public String getPhylum() {
		return this.phylum_eng + "|" + this.phylum_kor;
	}


	public String getClas_kor() {
		return clas_kor;
	}


	public void setClas_kor(String clas_kor) {
		this.clas_kor = clas_kor;
	}


	public String getClas_eng() {
		return clas_eng;
	}


	public void setClas_eng(String clas_eng) {
		this.clas_eng = clas_eng;
	}
	
	public void setClas(String clas) {
		NameObj obj = KobisCate.createName( clas );
		this.clas_kor = obj.getKor();
		this.clas_eng = obj.getEng();
	}
	
	public String getClas() {
		return this.clas_eng + "|" + this.clas_kor;
	}


	public String getOrder_kor() {
		return order_kor;
	}


	public void setOrder_kor(String order_kor) {
		this.order_kor = order_kor;
	}


	public String getOrder_eng() {
		return order_eng;
	}


	public void setOrder_eng(String order_eng) {
		this.order_eng = order_eng;
	}
	
	public void setOrder(String order) {
		NameObj obj = KobisCate.createName( order );
		this.order_kor = obj.getKor();
		this.order_eng = obj.getEng();
	}
	
	public String getOrder() {
		return this.order_eng + "|" + this.order_kor;
	}


	public String getFamily_kor() {
		return family_kor;
	}


	public void setFamily_kor(String family_kor) {
		this.family_kor = family_kor;
	}


	public String getFamily_eng() {
		return family_eng;
	}


	public void setFamily_eng(String family_eng) {
		this.family_eng = family_eng;
	}
	
	public void setFamily(String family) {
		NameObj obj = KobisCate.createName( family );
		this.family_kor = obj.getKor();
		this.family_eng = obj.getEng();
	}
	
	public String getFamily() {
		return this.family_eng + "|" + this.family_kor;
	}


	public String getGenus_kor() {
		return genus_kor;
	}


	public void setGenus_kor(String genus_kor) {
		this.genus_kor = genus_kor;
	}


	public String getGenus_eng() {
		return genus_eng;
	}


	public void setGenus_eng(String genus_eng) {
		this.genus_eng = genus_eng;
	}
	
	public void setGenus(String genus) {
		NameObj obj = KobisCate.createName( genus );
		this.genus_kor = obj.getKor();
		this.genus_eng = obj.getEng();
	}
	
	public String getGenus() {
		return this.genus_eng + "|" + this.genus_kor;
	}


	public String getSpecies_kor() {
		return species_kor;
	}


	public void setSpecies_kor(String species_kor) {
		this.species_kor = species_kor;
	}


	public String getSpecies_eng() {
		return species_eng;
	}


	public void setSpecies_eng(String species_eng) {
		this.species_eng = species_eng;
	}
	
	public void setSpecies(String species) {
		NameObj obj = KobisCate.createName( species );
		this.species_kor = obj.getKor();
		this.species_eng = obj.getEng();
	}
	
	public String getSpecies() {
		return this.species_eng + "|" + this.species_kor;
	}


	public String getSsp_kor() {
		return ssp_kor;
	}


	public void setSsp_kor(String ssp_kor) {
		this.ssp_kor = ssp_kor;
	}


	public String getSsp_eng() {
		return ssp_eng;
	}


	public void setSsp_eng(String ssp_eng) {
		this.ssp_eng = ssp_eng;
	}
	
	public void setSsp(String ssp) {
		NameObj obj = KobisCate.createName( ssp );
		this.ssp_kor = obj.getKor();
		this.ssp_eng = obj.getEng();
	}
	
	public String getSsp() {
		return this.ssp_eng + "|" + this.ssp_kor;
	}


	public String getVar_kor() {
		return var_kor;
	}


	public void setVar_kor(String var_kor) {
		this.var_kor = var_kor;
	}


	public String getVar_eng() {
		return var_eng;
	}


	public void setVar_eng(String var_eng) {
		this.var_eng = var_eng;
	}
	
	public void setVar(String var) {
		NameObj obj = KobisCate.createName( var );
		this.var_kor = obj.getKor();
		this.var_eng = obj.getEng();
	}
	
	public String getVar() {
		return this.var_eng + "|" + this.var_kor;
	}


	public String getF_kor() {
		return f_kor;
	}


	public void setF_kor(String f_kor) {
		this.f_kor = f_kor;
	}


	public String getF_eng() {
		return f_eng;
	}


	public void setF_eng(String f_eng) {
		this.f_eng = f_eng;
	}
	
	public void setF(String f) {
		NameObj obj = KobisCate.createName( f );
		this.f_kor = obj.getKor();
		this.f_eng = obj.getEng();
	}
	
	public String getF() {
		return this.f_eng + "|" + this.f_kor;
	}
	
	public String getCodeLine() {
		return 
				this.code 
				+ "," + this.code.substring(0, 2)
				+ "," + this.code.substring(0, 4)
				+ "," + this.code.substring(0, 6)
				+ "," + this.code.substring(0, 8)
				+ "," + this.code.substring(0, 10)
				+ "," + this.code.substring(0, 12)
				+ "," + this.code.substring(0, 14)
				+ "," + this.code.substring(0, 16)
				+ "," + this.code.substring(0, 18);
	}


	public String getLine() {
		return 
				this.code 
				+ "," + this.getKingdom()
				+ "," + this.code.substring(0, 2)
				+ "," + this.getPhylum()
				+ "," + this.code.substring(0, 4)
				+ "," + this.getClas()
				+ "," + this.code.substring(0, 6)
				+ "," + this.getOrder()
				+ "," + this.code.substring(0, 8)
				+ "," + this.getFamily()
				+ "," + this.code.substring(0, 10)
				+ "," + this.getGenus()
				+ "," + this.code.substring(0, 12)
				+ "," + this.getSpecies()
				+ "," + this.code.substring(0, 14)
				+ "," + this.getSsp()
				+ "," + this.code.substring(0, 16)
				+ "," + this.getVar()
				+ "," + this.code.substring(0, 18)
				+ "," + this.getF();
	}
}
