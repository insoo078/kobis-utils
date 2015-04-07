package org.kobic.kobis.main.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.type.Alias;
import org.kobic.kobis.file.excel.obj.XCommonSheetObj;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

@Alias("D1_Common")
public class D1CommonVO extends XCommonSheetObj{
	private String kobis_id;
	private String code;
	private String ins_cd;
	private String message;

	public D1CommonVO() {
		super();

		this.kobis_id = "";
		this.code = "";
		this.ins_cd = "";
		this.message = "";
	}
	
	public D1CommonVO( KnnrrcVO vo ) {
		this.setAccess_num( vo.getSds_no() );
		this.setIns_cd( vo.getIns_cd() );
		this.setCategory_1( vo.getCategory_1() );
		this.setCategory_2( vo.getCategory_2() );
		this.setGenus( vo.getGenus() );
		this.setSpecies( vo.getSpecies() );
		this.setInstitution( vo.getBank_name() );
	}

	public D1CommonVO(XCommonSheetObj commonSheetRecordObj) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties( this, commonSheetRecordObj );
	}
	public String getKobis_id() {
		return kobis_id;
	}
	public void setKobis_id(String kobis_id) {
		this.kobis_id = kobis_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIns_cd() {
		return ins_cd;
	}
	public void setIns_cd(String ins_cd) {
		this.ins_cd = ins_cd;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String getPrintLine() {
		String ret = super.getPrintLine();
		ret += this.getKobis_id() + ",";
		ret += this.getIns_cd() + ",";
		ret += this.getMessage() + ",";

		return ret;
	}
}
