package org.kobic.kobis.file.excel.obj.internal;

public class OpenObj {
	private String openYn;
	private String openUrl;
	
	public OpenObj() {
		this.openUrl = "";
		this.openYn = "";
	}
	
	public String getOpenYn() {
		return openYn;
	}
	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}
	public String getOpenUrl() {
		return openUrl;
	}
	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
}
