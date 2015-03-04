package org.kobic.kobis.file.excel.obj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.OpenObj;
import org.kobic.kobis.file.excel.obj.internal.PatentObj;
import org.kobic.kobis.file.excel.obj.internal.ReferenceObj;

public class XStructureSheetObj extends AbstractSheetObj{
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
		return open;
	}

	public void setOpen(OpenObj open) {
		this.open = open;
	}

	public PatentObj getPatent() {
		return patent;
	}

	public void setPatent(PatentObj patent) {
		this.patent = patent;
	}

	public ReferenceObj getReference() {
		return reference;
	}

	public void setReference(ReferenceObj reference) {
		this.reference = reference;
	}


	@Override
	public XStructureSheetObj getInstance( XSSFRow row ) {
		XStructureSheetObj obj = new XStructureSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setSource( row.getCell(i).toString() );
			else if( i == 2 )	obj.setSturctureType( row.getCell(i).toString() );
			else if( i == 3 )	obj.setAccessionNo( row.getCell(i).toString() );
			else if( i == 4 )	obj.setPdbFormat( row.getCell(i).toString() );
			else if( i == 5 )	obj.getOpen().setOpenYn( row.getCell(i).toString() );
			else if( i == 6 )	obj.getOpen().setOpenUrl( row.getCell(i).toString() );
			else if( i == 7 )	obj.getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 8 )	obj.getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 9 )	obj.getReference().setReference( row.getCell(i).toString() );
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
}
