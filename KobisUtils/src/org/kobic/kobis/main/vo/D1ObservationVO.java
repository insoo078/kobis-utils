package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;

public class D1ObservationVO extends XObservationSheetObj{
	public D1ObservationVO(XObservationSheetObj obsSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, obsSheetRecordObj );
	}
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
