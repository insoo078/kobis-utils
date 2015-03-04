package org.kobic.kobis.file.excel.obj.internal;

import java.util.HashMap;
import java.util.Map;

public class ExcelWorksheetNameMap {
	private Map<String, String> excelWroksheetNameMap;
	
	private static ExcelWorksheetNameMap ewn;
	
	public ExcelWorksheetNameMap() {
		this.excelWroksheetNameMap= new HashMap<String, String>();
		{
			excelWroksheetNameMap.put( "공통", "org.kobic.kobis.mybatis.services.CommonServices" );
		}
	}

	public String getClassNameFromSheetName(String sheetName) {
		return this.excelWroksheetNameMap.get(sheetName);
	}

	public synchronized static ExcelWorksheetNameMap getInstance(){
		if(ewn == null){
			ewn = new ExcelWorksheetNameMap();
		}
		return ewn;
	}
}
