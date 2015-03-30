package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XExtractSheetObj;

public class D1ExtractionVO extends XExtractSheetObj implements DBCommonInterface{
	public D1ExtractionVO(XExtractSheetObj extractSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, extractSheetRecordObj );
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
