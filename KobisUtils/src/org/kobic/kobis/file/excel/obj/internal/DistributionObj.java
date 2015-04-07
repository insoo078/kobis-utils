package org.kobic.kobis.file.excel.obj.internal;

public class DistributionObj{
	private String distYn;
	private String distUrl;
	
	public DistributionObj() {
		this.distUrl = "";
		this.distYn = "";
	}

	public String getDistYn() {
		return distYn;
	}
	public void setDistYn(String distYn) {
		this.distYn = distYn;
	}
	public String getDistUrl() {
		return distUrl;
	}
	public void setDistUrl(String distUrl) {
		this.distUrl = distUrl;
	}
}
