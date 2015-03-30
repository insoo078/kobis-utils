package org.kobic.kobis.main.vo;

import org.kobic.kobis.file.excel.obj.XObservationSheetObj;

public class D1ObservationVO extends XObservationSheetObj{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getPrintLine() {
		String ret = super.getPrintLine();
		ret += this.getId();

		return ret;
	}
}
