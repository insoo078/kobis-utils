package org.kobic.kobis.file.excel.obj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.GpsObj;

public class XObservationSheetObj extends AbstractSheetObj{
	private GpsObj gps;
	private DistPatentReferenceObj extra;


	public GpsObj getGps() {
		return gps;
	}
	public void setGps(GpsObj gps) {
		this.gps = gps;
	}
	public DistPatentReferenceObj getExtra() {
		return extra;
	}
	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}

	@Override
	public XObservationSheetObj getInstance( XSSFRow row ) {
		XObservationSheetObj obj = new XObservationSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.getGps().setLatitude( row.getCell(i).toString() );
			else if( i == 2 )	obj.getGps().setLongitude( row.getCell(i).toString() );
			else if( i == 3 )	obj.getExtra().getDist().setDistYn( row.getCell(i).toString() );
			else if( i == 4 )	obj.getExtra().getDist().setDistUrl( row.getCell(i).toString() );
			else if( i == 5 )	obj.getExtra().getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 6 )	obj.getExtra().getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 7 )	obj.getExtra().getRef().setReference( row.getCell(i).toString() );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getGps().getLatitude() + ",";
		line += this.getGps().getLongitude() + ",";
		line += this.getExtra().getDist().getDistYn() + ",";
		line += this.getExtra().getDist().getDistUrl() + ",";
		line += this.getExtra().getPatent().getParentNo() + ",";
		line += this.getExtra().getPatent().getRegNo() + ",";
		line += this.getExtra().getRef().getReference();
		
		return line;
	}
}
