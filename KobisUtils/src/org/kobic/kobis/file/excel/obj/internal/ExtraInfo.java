package org.kobic.kobis.file.excel.obj.internal;

import java.util.HashMap;
import java.util.Map;

public class ExtraInfo {
	public Map<String, String> extraMap;

	public ExtraInfo(String extraName, String extraValue) {
		this.extraMap = new HashMap<String, String>();
		
		this.extraMap.put( extraName, extraValue );
	}
	
	public String extraValue(String extraName) {
		return this.extraMap.get(extraName);
	}
}
