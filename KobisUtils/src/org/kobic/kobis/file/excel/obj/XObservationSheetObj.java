package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.GpsObj;

@Alias("D1_Observation")
public class XObservationSheetObj extends AbstractSheetObj implements DistPatentReferenceInterface{
	private GpsObj gps;
	private DistPatentReferenceObj extra;


	public GpsObj getGps() {
		if( this.gps == null ) this.gps = new GpsObj();
		return gps;
	}
	public void setGps(GpsObj gps) {
		this.gps = gps;
	}
	public DistPatentReferenceObj getExtra() {
		if( this.extra == null ) this.extra = new DistPatentReferenceObj();
		return extra;
	}
	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}
	
	public static XObservationSheetObj getNewInstance(XSSFRow row) {
		return new XObservationSheetObj().getInstance(row);
	}

	@Override
	public XObservationSheetObj getInstance( XSSFRow row ) {
		XObservationSheetObj obj = new XObservationSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(						this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.getGps().setLatitude(				this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.getGps().setLongitude(				this.getVal(row.getCell(i) ) );
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
		line += this.getGps().getLatitude() + ",";
		line += this.getGps().getLongitude() + ",";
		line += this.getExtra().getDist().getDistYn() + ",";
		line += this.getExtra().getDist().getDistUrl() + ",";
		line += this.getExtra().getPatent().getParentNo() + ",";
		line += this.getExtra().getPatent().getRegNo() + ",";
		line += this.getExtra().getRef().getReference();
		
		return line;
	}
	@Override
	public String getDistYn() {
		// TODO Auto-generated method stub
		return this.extra.getDist().getDistYn();
	}
	@Override
	public String getDistUrl() {
		// TODO Auto-generated method stub
		return this.extra.getDist().getDistUrl();
	}
	@Override
	public String getParentNo() {
		// TODO Auto-generated method stub
		return this.extra.getPatent().getParentNo();
	}
	@Override
	public String getRegNo() {
		// TODO Auto-generated method stub
		return this.extra.getPatent().getRegNo();
	}
	@Override
	public String getReference() {
		// TODO Auto-generated method stub
		return this.extra.getRef().getReference();
	}
}
