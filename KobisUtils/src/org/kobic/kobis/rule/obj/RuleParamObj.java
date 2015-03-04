package org.kobic.kobis.rule.obj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleParamObj {
	private Map<String, String> paramMap;
	
	public void addParam(String name, String value) {
		if( this.paramMap == null ) {
			this.paramMap = new HashMap<String, String>();
		}
		this.paramMap.put(name, value);
	}
	
	public int size() {
		return this.paramMap.size();
	}

	public List<String> getParams(){
		return Arrays.asList( Arrays.asList(this.paramMap.keySet().toArray()).toArray(new String[this.paramMap.keySet().size()]) );
	}
	
	public String getParam(String name) {
		return this.paramMap.get(name);
	}
}
