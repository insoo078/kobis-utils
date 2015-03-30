package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XDnaSequenceSheetObj;

public class D1DnaSequenceVO extends XDnaSequenceSheetObj implements DBCommonInterface{
	public D1DnaSequenceVO(XDnaSequenceSheetObj dnaSequenceSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, dnaSequenceSheetRecordObj );
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
