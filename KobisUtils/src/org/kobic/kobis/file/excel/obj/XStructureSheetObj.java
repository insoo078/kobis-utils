package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.OpenObj;
import org.kobic.kobis.file.excel.obj.internal.PatentObj;
import org.kobic.kobis.file.excel.obj.internal.ReferenceObj;

@Alias("D1_Structure")
public class XStructureSheetObj extends AbstractSheetObj implements OpenPatentReferenceInterface{
	private String source;
	private String sturctureType;
	private String accessionNo;
	private String pdbFormat;
	private OpenObj open;
	private PatentObj patent;
	private ReferenceObj reference;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSturctureType() {
		return sturctureType;
	}

	public void setSturctureType(String sturctureType) {
		this.sturctureType = sturctureType;
	}

	public String getPdbFormat() {
		return pdbFormat;
	}

	public void setPdbFormat(String pdbFormat) {
		this.pdbFormat = pdbFormat;
	}

	public String getAccessionNo() {
		return accessionNo;
	}

	public void setAccessionNo(String accessionNo) {
		this.accessionNo = accessionNo;
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


	@Override
	public XStructureSheetObj getInstance( XSSFRow row ) {
		XStructureSheetObj obj = new XStructureSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(					this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.setSource(						this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.setSturctureType(				this.getVal(row.getCell(i) ) );
			else if( i == 3 )	obj.setAccessionNo(					this.getVal(row.getCell(i) ) );
			else if( i == 4 )	obj.setPdbFormat(					this.getVal(row.getCell(i) ) );
			else if( i == 5 )	obj.getOpen().setOpenYn(			this.getVal(row.getCell(i) ) );
			else if( i == 6 )	obj.getOpen().setOpenUrl(			this.getVal(row.getCell(i) ) );
			else if( i == 7 )	obj.getPatent().setParentNo(		this.getVal(row.getCell(i) ) );
			else if( i == 8 )	obj.getPatent().setRegNo(			this.getVal(row.getCell(i) ) );
			else if( i == 9 )	obj.getReference().setReference(	this.getVal(row.getCell(i) ) );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getSource() + ",";
		line += this.getSturctureType() + ",";
		line += this.getAccessionNo() + ",";
		line += this.getPdbFormat() + ",";
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
