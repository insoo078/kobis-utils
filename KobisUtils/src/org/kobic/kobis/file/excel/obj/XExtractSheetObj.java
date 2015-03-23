package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.ExtractionObj;

@Alias("D1_Extract")
public class XExtractSheetObj extends AbstractSheetObj{
	private String source;
	private ExtractionObj extract;
	private DistPatentReferenceObj extra;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public ExtractionObj getExtract() {
		return extract;
	}

	public void setExtract(ExtractionObj extract) {
		this.extract = extract;
	}

	public DistPatentReferenceObj getExtra() {
		return extra;
	}

	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}
	
	public static XExtractSheetObj getNewInstance(XSSFRow row) {
		return new XExtractSheetObj().getInstance(row);
	}

	@Override
	public XExtractSheetObj getInstance( XSSFRow row ) {
		XExtractSheetObj obj = new XExtractSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setSource( row.getCell(i).toString() );
			else if( i == 2 )	obj.getExtract().setSolvent( row.getCell(i).toString() );
			else if( i == 3 )	obj.getExtract().setExtractTime( row.getCell(i).toString() );
			else if( i == 4 )	obj.getExtra().getDist().setDistYn( row.getCell(i).toString() );
			else if( i == 5 )	obj.getExtra().getDist().setDistUrl( row.getCell(i).toString() );
			else if( i == 6 )	obj.getExtra().getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 7 )	obj.getExtra().getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 8 )	obj.getExtra().getRef().setReference( row.getCell(i).toString() );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getSource() + ",";
		line += this.getExtract().getSolvent() + ",";
		line += this.getExtract().getExtractTime() + ",";
		line += this.getExtra().getDist().getDistYn() + ",";
		line += this.getExtra().getDist().getDistUrl() + ",";
		line += this.getExtra().getPatent().getParentNo() + ",";
		line += this.getExtra().getPatent().getRegNo() + ",";
		line += this.getExtra().getRef().getReference();
		
		return line;
	}
}
