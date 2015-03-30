package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XBodyFluidSheetObj;

public class D1BodyFluidVO extends XBodyFluidSheetObj implements DBCommonInterface{
	public D1BodyFluidVO(XBodyFluidSheetObj bodyFluidSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, bodyFluidSheetRecordObj );
	}

	private String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
