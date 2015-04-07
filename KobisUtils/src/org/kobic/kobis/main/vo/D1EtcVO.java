package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XEtcSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1EtcVO extends XEtcSheetObj implements DBCommonInterface{
	public D1EtcVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setAccess_num( kvo.getSds_no() );
	}
	public D1EtcVO(XEtcSheetObj etcSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, etcSheetRecordObj );
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
