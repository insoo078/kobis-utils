package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XSourceSheetObj;

public class D1SourceVO extends XSourceSheetObj implements DBCommonInterface{
	private String id;
	
	public D1SourceVO(XSourceSheetObj sourceSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, sourceSheetRecordObj );
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
