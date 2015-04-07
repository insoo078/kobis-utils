package org.kobic.kobis.file.excel.obj.internal;

public class StoreObj {
	private String storePlace;
	private String storeNo;
	
	public StoreObj() {
		this.storeNo = "";
		this.storePlace = "";
	}

	public String getStorePlace() {
		return storePlace;
	}
	public void setStorePlace(String storePlace) {
		this.storePlace = storePlace;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
}
