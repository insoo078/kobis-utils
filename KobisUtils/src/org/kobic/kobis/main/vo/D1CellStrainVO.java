package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class D1CellStrainVO extends XCellStrainSheetObj implements DBCommonInterface{
	private String id;

	public D1CellStrainVO(KnnrrcVO kvo) {
		super();
		this.id = "";
		this.setSource( kvo.getIso_source() );
		this.setAccess_num( kvo.getSds_no() );
	}
	
	public D1CellStrainVO(XCellStrainSheetObj cellStrainSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, cellStrainSheetRecordObj );
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
