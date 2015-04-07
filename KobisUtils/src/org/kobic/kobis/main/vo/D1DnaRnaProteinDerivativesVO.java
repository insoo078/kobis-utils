package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XDnaRnaProteinDerivativesSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1DnaRnaProteinDerivativesVO extends XDnaRnaProteinDerivativesSheetObj implements DBCommonInterface{
	public D1DnaRnaProteinDerivativesVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setAccess_num( kvo.getSds_no() );
		this.setSource( kvo.getIso_source() );
	}

	public D1DnaRnaProteinDerivativesVO(XDnaRnaProteinDerivativesSheetObj dnaRnaProteinDerivativesSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, dnaRnaProteinDerivativesSheetRecordObj );
	}
	
	public D1DnaRnaProteinDerivativesVO() {
		super();
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
