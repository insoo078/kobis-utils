package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XEmbryoSheetObj;

public class D1EmbryoVO extends XEmbryoSheetObj implements DBCommonInterface{
	public D1EmbryoVO(XEmbryoSheetObj embryoSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, embryoSheetRecordObj );
	}
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
