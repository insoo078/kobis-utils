package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;

@Alias("D1_Individual")
public class XIndividualSheetObj extends AbstractSheetObj{
	private String individualType;
	private String individualMaintenance;
	private DistPatentReferenceObj extra;
	
	
	
	public String getIndividualType() {
		return individualType;
	}

	public void setIndividualType(String individualType) {
		this.individualType = individualType;
	}

	public String getIndividualMaintenance() {
		return individualMaintenance;
	}

	public void setIndividualMaintenance(String individualMaintenance) {
		this.individualMaintenance = individualMaintenance;
	}

	public DistPatentReferenceObj getExtra() {
		if( this.extra == null )	this.extra = new DistPatentReferenceObj();
		return extra;
	}

	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}

	@Override
	public XIndividualSheetObj getInstance( XSSFRow row ) {
		XIndividualSheetObj obj = new XIndividualSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(						this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.setIndividualType(					this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.setIndividualMaintenance(			this.getVal(row.getCell(i) ) );
			else if( i == 3 )	obj.getExtra().getDist().setDistYn(		this.getVal(row.getCell(i) ) );
			else if( i == 4 )	obj.getExtra().getDist().setDistUrl(	this.getVal(row.getCell(i) ) );
			else if( i == 5 )	obj.getExtra().getPatent().setParentNo(	this.getVal(row.getCell(i) ) );
			else if( i == 6 )	obj.getExtra().getPatent().setRegNo(	this.getVal(row.getCell(i) ) );
			else if( i == 7 )	obj.getExtra().getRef().setReference(	this.getVal(row.getCell(i) ) );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getIndividualType() + ",";
		line += this.getIndividualMaintenance() + ",";
		line += this.getExtra().getDist().getDistYn() + ",";
		line += this.getExtra().getDist().getDistUrl() + ",";
		line += this.getExtra().getPatent().getParentNo() + ",";
		line += this.getExtra().getPatent().getRegNo() + ",";
		line += this.getExtra().getRef().getReference();
		
		return line;
	}
}
