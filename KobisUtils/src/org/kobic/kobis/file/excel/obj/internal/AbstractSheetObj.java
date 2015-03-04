package org.kobic.kobis.file.excel.obj.internal;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.XCommonSheetObj;

public abstract class AbstractSheetObj {
	private String access_num;

	public String getAccess_num() {
		return access_num;
	}

	public void setAccess_num(String access_num) {
		this.access_num = access_num;
	}
	
	public abstract AbstractSheetObj getInstance(XSSFRow row);
	public abstract String getPrintLine();
}
