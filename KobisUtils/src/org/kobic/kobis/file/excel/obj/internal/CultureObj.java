package org.kobic.kobis.file.excel.obj.internal;

public class CultureObj {
	private String cultureMediumName;
	private String condition;
	private String succeedDt;
	private String succeedTime;
	
	public CultureObj() {
		this.cultureMediumName = "";
		this.condition = "";
		this.succeedDt = "";
		this.succeedTime = "";
	}

	public String getCultureMediumName() {
		return cultureMediumName;
	}
	public void setCultureMediumName(String cultureMediumName) {
		this.cultureMediumName = cultureMediumName;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getSucceedDt() {
		return succeedDt;
	}
	public void setSucceedDt(String succeedDt) {
		this.succeedDt = succeedDt;
	}
	public String getSucceedTime() {
		return succeedTime;
	}
	public void setSucceedTime(String succeedTime) {
		this.succeedTime = succeedTime;
	}
}
