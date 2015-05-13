package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XIndividualSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1IndividualVO extends XIndividualSheetObj implements DBCommonInterface{
	private String id;

	public D1IndividualVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setAccess_num( kvo.getSds_no() );
		this.setUid( kvo.getUid() );
	}
	public D1IndividualVO(XIndividualSheetObj individualSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, individualSheetRecordObj );
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
