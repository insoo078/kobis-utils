package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XStrainSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1StrainVO extends XStrainSheetObj implements DBCommonInterface{
	private String id;
	
	public D1StrainVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setSource( kvo.getIso_source() );
		this.setAccess_num( kvo.getSds_no() );
		this.setUid( kvo.getUid() );
	}
	
	public D1StrainVO(XStrainSheetObj strainSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, strainSheetRecordObj );
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
