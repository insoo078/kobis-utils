package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XBodyFluidSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1BodyFluidVO extends XBodyFluidSheetObj implements DBCommonInterface{
	private String id;

	public D1BodyFluidVO(XBodyFluidSheetObj bodyFluidSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, bodyFluidSheetRecordObj );
	}
	
	public D1BodyFluidVO( KnnrrcVO kvo ) {
		super();
		this.id = "";

		this.setAccess_num( kvo.getSds_no() );
		this.setUid( kvo.getUid() );
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
