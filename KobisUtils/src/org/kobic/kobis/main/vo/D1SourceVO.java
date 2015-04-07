package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XSourceSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1SourceVO extends XSourceSheetObj implements DBCommonInterface{
	private String id;
	
	public D1SourceVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setSource( kvo.getIso_source() );
		this.setAccess_num( kvo.getSds_no() );
	}
	
	public D1SourceVO(XSourceSheetObj sourceSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, sourceSheetRecordObj );
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
