package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XExtractSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1ExtractionVO extends XExtractSheetObj implements DBCommonInterface{
	private String id;

	public D1ExtractionVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setSource( kvo.getIso_source() );
		this.setAccess_num( kvo.getSds_no() );
	}
	public D1ExtractionVO(XExtractSheetObj extractSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, extractSheetRecordObj );
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
