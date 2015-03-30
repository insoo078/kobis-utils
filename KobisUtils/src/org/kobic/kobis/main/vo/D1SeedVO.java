package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XSeedSheetObj;

public class D1SeedVO extends XSeedSheetObj implements DBCommonInterface{
	private String id;
	
	public D1SeedVO(XSeedSheetObj seedSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, seedSheetRecordObj );
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
