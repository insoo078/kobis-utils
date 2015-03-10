package org.kobic.kobis.rule.obj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleParamObj {
	private Map<String, Object> paramMap;

	public void addParam(String name, Object value) {
		if( this.paramMap == null ) {
			this.paramMap = new HashMap<String, Object>();
		}
		this.paramMap.put(name, value);
	}
	
	public int size() {
		return this.paramMap.size();
	}

	public List<String> getParams(){
		return Arrays.asList( Arrays.asList(this.paramMap.keySet().toArray()).toArray(new String[this.paramMap.keySet().size()]) );
	}
	
	public Object getParam(String name) {
		return this.paramMap.get(name);
	}
	
	public boolean containsParam(String name) {
		return this.paramMap.containsKey(name);
	}
}
