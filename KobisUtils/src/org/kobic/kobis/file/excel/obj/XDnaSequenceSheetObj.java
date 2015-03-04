package org.kobic.kobis.file.excel.obj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.OpenObj;
import org.kobic.kobis.file.excel.obj.internal.PatentObj;
import org.kobic.kobis.file.excel.obj.internal.ReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.SequenceObj;

public class XDnaSequenceSheetObj extends AbstractSheetObj{
	private String source;
	private String molecular;
	private String dataType;
	private SequenceObj sequence;
	private OpenObj open;
	private PatentObj patent;
	private ReferenceObj reference;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMolecular() {
		return molecular;
	}

	public void setMolecular(String molecular) {
		this.molecular = molecular;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public SequenceObj getSequence() {
		return sequence;
	}

	public void setSequence(SequenceObj sequence) {
		this.sequence = sequence;
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
	public XDnaSequenceSheetObj getInstance( XSSFRow row ) {
		XDnaSequenceSheetObj obj = new XDnaSequenceSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setSource( row.getCell(i).toString() );
			else if( i == 2 )	obj.setMolecular( row.getCell(i).toString() );
			else if( i == 3 )	obj.setDataType( row.getCell(i).toString() );
			else if( i == 4 )	obj.getSequence().setGeneName( row.getCell(i).toString() );
			else if( i == 5 )	obj.getSequence().setAccessionNo( row.getCell(i).toString() );
			else if( i == 6 )	obj.getSequence().setSequence( row.getCell(i).toString() );
			else if( i == 7 )	obj.getOpen().setOpenYn( row.getCell(i).toString() );
			else if( i == 8 )	obj.getOpen().setOpenUrl( row.getCell(i).toString() );
			else if( i == 9 )	obj.getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 10 )	obj.getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 11 )	obj.getReference().setReference( row.getCell(i).toString() );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getSource() + ",";
		line += this.getMolecular() + ",";
		line += this.getDataType() + ",";
		line += this.getSequence().getGeneName() + ",";
		line += this.getSequence().getAccessionNo() + ",";
		line += this.getSequence().getSequence() + ",";
		line += this.getOpen().getOpenYn() + ",";
		line += this.getOpen().getOpenUrl() + ",";
		line += this.getPatent().getParentNo() + ",";
		line += this.getPatent().getRegNo() + ",";
		line += this.getReference().getReference();
		
		return line;
	}
}
