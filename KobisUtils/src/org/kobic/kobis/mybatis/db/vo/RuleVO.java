package org.kobic.kobis.mybatis.db.vo;

public class RuleVO {
	private String rule_id;
	private String ins_cd;
	private String rule_name;
	private String rule_type;
	private String rule;

	public String getRule_id() {
		return rule_id;
	}
	public void setRule_id(String rule_id) {
		this.rule_id = rule_id;
	}
	public String getIns_cd() {
		return ins_cd;
	}
	public void setIns_cd(String ins_cd) {
		this.ins_cd = ins_cd;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getRule_type() {
		return rule_type;
	}
	public void setRule_type(String rule_type) {
		this.rule_type = rule_type;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}

}
