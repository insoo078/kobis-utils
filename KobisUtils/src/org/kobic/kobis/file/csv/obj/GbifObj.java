package org.kobic.kobis.file.csv.obj;

public class GbifObj {
	private String taxonID;
	private String parentNameUsageID;
	private String acceptedNameUsageID;
	private String scientificName;
	private String canonicalName;
	private String taxonRank;
	private String genus;
	private String specificEpithet;
	private String infraspecificEpithet;

	public GbifObj(String[] line) {
		if( line.length ==18 ) {
			this.taxonID = line[0];
			this.parentNameUsageID = line[1];
			this.acceptedNameUsageID = line[2];
			this.scientificName = line[3];
			this.canonicalName = line[4];
			this.taxonRank = line[5];
			this.genus = line[8];
			this.specificEpithet = line[9];
			this.infraspecificEpithet = line[10];
			
			if( this.taxonID == null || this.taxonID.isEmpty() )
				System.out.println("hello");
		}
	}

	public String getTaxonID() {
		return taxonID;
	}

	public void setTaxonID(String taxonID) {
		this.taxonID = taxonID;
	}

	public String getParentNameUsageID() {
		return parentNameUsageID;
	}
	public void setParentNameUsageID(String parentNameUsageID) {
		this.parentNameUsageID = parentNameUsageID;
	}
	public String getAcceptedNameUsageID() {
		return acceptedNameUsageID;
	}
	public void setAcceptedNameUsageID(String acceptedNameUsageID) {
		this.acceptedNameUsageID = acceptedNameUsageID;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getCanonicalName() {
		return canonicalName;
	}
	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}
	public String getTaxonRank() {
		return taxonRank;
	}
	public void setTaxonRank(String taxonRank) {
		this.taxonRank = taxonRank;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecificEpithet() {
		return specificEpithet;
	}
	public void setSpecificEpithet(String specificEpithet) {
		this.specificEpithet = specificEpithet;
	}
	public String getInfraspecificEpithet() {
		return infraspecificEpithet;
	}
	public void setInfraspecificEpithet(String infraspecificEpithet) {
		this.infraspecificEpithet = infraspecificEpithet;
	}
}
