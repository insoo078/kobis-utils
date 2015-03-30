package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XProteinSequenceSheetObj;

public class D1ProteinSequenceVO extends XProteinSequenceSheetObj implements DBCommonInterface{
	private String id;
	
	public D1ProteinSequenceVO(XProteinSequenceSheetObj proteinSequenceSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, proteinSequenceSheetRecordObj );
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
