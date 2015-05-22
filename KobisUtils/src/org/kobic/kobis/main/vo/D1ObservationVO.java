package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1ObservationVO extends XObservationSheetObj implements DBCommonInterface{
	public D1ObservationVO(XObservationSheetObj obsSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, obsSheetRecordObj );
	}
	private String id;
	
	public D1ObservationVO(KnnrrcVO kvo){
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

	@Override
	public String getPrintLine() {
		String ret = super.getPrintLine();
		ret += this.getId();

		return ret;
	}
}
