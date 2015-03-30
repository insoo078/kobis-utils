package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XOrganSheetObj;

public class D1OrganVO extends XOrganSheetObj implements DBCommonInterface{
	public D1OrganVO(XOrganSheetObj organSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, organSheetRecordObj );
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
