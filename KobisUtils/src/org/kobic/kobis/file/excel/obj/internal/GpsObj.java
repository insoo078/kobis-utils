package org.kobic.kobis.file.excel.obj.internal;

public class GpsObj {
	private String latitude;
	private String longitude;
	
	public GpsObj() {
		this.latitude = "";
		this.longitude = "";
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
