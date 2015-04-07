package org.kobic.kobis.file.excel.obj.internal;

public class ExtractionObj {
	private String solvent;
	private String extractTime;
	
	public ExtractionObj() {
		this.solvent = "";
		this.extractTime = "";
	}

	public String getSolvent() {
		return solvent;
	}
	public void setSolvent(String solvent) {
		this.solvent = solvent;
	}
	public String getExtractTime() {
		return extractTime;
	}
	public void setExtractTime(String extractTime) {
		this.extractTime = extractTime;
	}

}
