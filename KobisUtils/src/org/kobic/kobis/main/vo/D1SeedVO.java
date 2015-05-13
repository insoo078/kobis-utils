package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XSeedSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1SeedVO extends XSeedSheetObj implements DBCommonInterface{
	private String id;
	
	public D1SeedVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setAccess_num( kvo.getSds_no() );
		this.setUid( kvo.getUid() );
	}

	public D1SeedVO(XSeedSheetObj seedSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, seedSheetRecordObj );
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
