package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;

public class D1CellStrainVO extends XCellStrainSheetObj implements DBCommonInterface{
	public D1CellStrainVO(XCellStrainSheetObj cellStrainSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, cellStrainSheetRecordObj );
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
