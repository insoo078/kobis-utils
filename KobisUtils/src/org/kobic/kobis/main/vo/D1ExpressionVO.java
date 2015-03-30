package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XExpressionSheetObj;

public class D1ExpressionVO extends XExpressionSheetObj implements DBCommonInterface{
	public D1ExpressionVO(XExpressionSheetObj expressionSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, expressionSheetRecordObj );
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
