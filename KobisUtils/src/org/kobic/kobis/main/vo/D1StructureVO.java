package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XStructureSheetObj;

public class D1StructureVO extends XStructureSheetObj implements DBCommonInterface{
	private String id;
	
	public D1StructureVO(XStructureSheetObj structureSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, structureSheetRecordObj );
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
