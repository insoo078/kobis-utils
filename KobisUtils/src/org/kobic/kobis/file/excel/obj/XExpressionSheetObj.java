package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.OpenObj;
import org.kobic.kobis.file.excel.obj.internal.PatentObj;
import org.kobic.kobis.file.excel.obj.internal.ReferenceObj;

@Alias("D1_Expression")
public class XExpressionSheetObj extends AbstractSheetObj implements OpenPatentReferenceInterface{
	private String source;
	private String sequence;
	private String dataType;
	private OpenObj open;
	private PatentObj patent;
	private ReferenceObj reference;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public OpenObj getOpen() {
		if( this.open == null )	this.open = new OpenObj();
		return open;
	}

	public void setOpen(OpenObj open) {
		this.open = open;
	}

	public PatentObj getPatent() {
		if( this.patent == null )	this.patent = new PatentObj();
		return patent;
	}

	public void setPatent(PatentObj patent) {
		this.patent = patent;
	}

	public ReferenceObj getReference() {
		if( this.reference == null )	this.reference = new ReferenceObj();
		return reference;
	}

	public void setReference(ReferenceObj reference) {
		this.reference = reference;
	}
	public static XExpressionSheetObj getNewInstance(XSSFRow row) {
		return new XExpressionSheetObj().getInstance(row);
	}

	@Override
	public XExpressionSheetObj getInstance( XSSFRow row ) {
		XExpressionSheetObj obj = new XExpressionSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(					this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.setSource(						this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.setDataType(					this.getVal(row.getCell(i) ) );
			else if( i == 3 )	obj.setSequence(					this.getVal(row.getCell(i) ) );
			else if( i == 4 )	obj.getOpen().setOpenYn(			this.getVal(row.getCell(i) ) );
			else if( i == 5 )	obj.getOpen().setOpenUrl(			this.getVal(row.getCell(i) ) );
			else if( i == 6 )	obj.getPatent().setParentNo(		this.getVal(row.getCell(i) ) );
			else if( i == 7 )	obj.getPatent().setRegNo(			this.getVal(row.getCell(i) ) );
			else if( i == 8 )	obj.getReference().setReference(	this.getVal(row.getCell(i) ) );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getSource() + ",";
		line += this.getDataType() + ",";
		line += this.getSequence() + ",";
		line += this.getOpen().getOpenYn() + ",";
		line += this.getOpen().getOpenUrl() + ",";
		line += this.getPatent().getParentNo() + ",";
		line += this.getPatent().getRegNo() + ",";
		line += this.getReference().getReference();
		
		return line;
	}

	@Override
	public String getOpenYn() {
		// TODO Auto-generated method stub
		return this.getOpen().getOpenYn();
	}
	@Override
	public String getOpenUrl() {
		// TODO Auto-generated method stub
		return this.getOpen().getOpenUrl();
	}
	@Override
	public String getParentNo() {
		// TODO Auto-generated method stub
		return this.getPatent().getParentNo();
	}
	@Override
	public String getRegNo() {
		// TODO Auto-generated method stub
		return this.getPatent().getRegNo();
	}
	@Override
	public String getReferenceStr() {
		// TODO Auto-generated method stub
		return this.reference.getReference();
	}
}
