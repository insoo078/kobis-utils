package org.kobic.kobis.rule.obj;

import org.kobic.kobis.file.excel.obj.internal.ExtraCodeInfo;

public class CodeMappingRuleObj extends RuleObj{
	private String genus;
	private String species;

	private ExtraCodeInfo extraInfo;
	private boolean extraType;
	
	public CodeMappingRuleObj(String genus, String species, ExtraCodeInfo extraInfo, boolean extraType) {
		this.genus = genus;
		this.species = species;
		
		this.extraInfo = extraInfo;
		this.extraType = extraType;
	}
}
