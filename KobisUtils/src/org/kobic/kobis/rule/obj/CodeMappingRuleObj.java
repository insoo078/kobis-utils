package org.kobic.kobis.rule.obj;

import org.kobic.kobis.file.excel.obj.internal.ExtraInfo;

public class CodeMappingRuleObj extends RuleParamObj{
	private String genus;
	private String species;

	private ExtraInfo extraInfo;
	private boolean extraType;
	
	public CodeMappingRuleObj(String genus, String species, ExtraInfo extraInfo, boolean extraType) {
		this.genus = genus;
		this.species = species;
		
		this.extraInfo = extraInfo;
		this.extraType = extraType;
	}
}
