package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.OpenObj;

@Alias("D1_Etc")
public class XEtcSheetObj  extends AbstractSheetObj{
	private String description;
	private OpenObj open;
	private DistPatentReferenceObj extra;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OpenObj getOpen() {
		return open;
	}
	public void setOpen(OpenObj open) {
		this.open = open;
	}
	public DistPatentReferenceObj getExtra() {
		return extra;
	}
	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}
	
	@Override
	public XEtcSheetObj getInstance( XSSFRow row ) {
		XEtcSheetObj obj = new XEtcSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setDescription( row.getCell(i).toString() );
			else if( i == 2 )	obj.getExtra().getDist().setDistYn( row.getCell(i).toString() );
			else if( i == 3 )	obj.getExtra().getDist().setDistUrl( row.getCell(i).toString() );
			else if( i == 4 )	obj.getOpen().setOpenYn( row.getCell(i).toString() );
			else if( i == 5 )	obj.getOpen().setOpenUrl( row.getCell(i).toString() );
			else if( i == 6 )	obj.getExtra().getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 7 )	obj.getExtra().getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 8 )	obj.getExtra().getRef().setReference( row.getCell(i).toString() );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getDescription() + ",";
		line += this.getExtra().getDist().getDistYn() + ",";
		line += this.getExtra().getDist().getDistUrl() + ",";
		line += this.getOpen().getOpenYn() + ",";
		line += this.getOpen().getOpenUrl() + ",";
		line += this.getExtra().getPatent().getParentNo() + ",";
		line += this.getExtra().getPatent().getRegNo() + ",";
		line += this.getExtra().getRef().getReference();
		
		return line;
	}
}
