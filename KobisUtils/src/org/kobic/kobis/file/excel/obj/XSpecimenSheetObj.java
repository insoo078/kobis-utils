package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.GpsObj;

@Alias("D1_Specimen")
public class XSpecimenSheetObj extends AbstractSheetObj implements DistPatentReferenceInterface{
	private String morphology;
	private String engAddr;
	private String korAddr;
	private GpsObj gps;
	private String colleUser;
	private String collectDt;
	private String nation;
	private String ocean;
	private String island;
	private String specimenType;
	private String kindOfSpecimen;
	private String publicYn;
	private DistPatentReferenceObj extra;

	public String getMorphology() {
		return morphology;
	}

	public void setMorphology(String morphology) {
		this.morphology = morphology;
	}



	public String getEngAddr() {
		return engAddr;
	}



	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}



	public String getKorAddr() {
		return korAddr;
	}



	public void setKorAddr(String korAddr) {
		this.korAddr = korAddr;
	}



	public GpsObj getGps() {
		if( this.gps == null )	this.gps = new GpsObj();
		return gps;
	}



	public void setGps(GpsObj gps) {
		this.gps = gps;
	}



	public String getColleUser() {
		return colleUser;
	}



	public void setColleUser(String colleUser) {
		this.colleUser = colleUser;
	}



	public String getCollectDt() {
		return collectDt;
	}



	public void setCollectDt(String collectDt) {
		this.collectDt = collectDt;
	}



	public String getNation() {
		return nation;
	}



	public void setNation(String nation) {
		this.nation = nation;
	}



	public String getOcean() {
		return ocean;
	}



	public void setOcean(String ocean) {
		this.ocean = ocean;
	}



	public String getIsland() {
		return island;
	}



	public void setIsland(String island) {
		this.island = island;
	}



	public String getSpecimenType() {
		return specimenType;
	}



	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}



	public String getKindOfSpecimen() {
		return kindOfSpecimen;
	}



	public void setKindOfSpecimen(String kindOfSpecimen) {
		this.kindOfSpecimen = kindOfSpecimen;
	}



	public String getPublicYn() {
		return publicYn;
	}



	public void setPublicYn(String publicYn) {
		this.publicYn = publicYn;
	}



	public DistPatentReferenceObj getExtra() {
		if( this.extra == null )	this.extra = new DistPatentReferenceObj();
		return extra;
	}



	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getMorphology() + ",";
		line += this.getKorAddr() + ",";
		line += this.getEngAddr() + ",";
		line += this.getGps().getLatitude() + ",";
		line += this.getGps().getLongitude() + ",";
		line += this.getColleUser() + ",";
		line += this.getCollectDt() + ",";
		line += this.getNation() + ",";
		line += this.getOcean() + ",";
		line += this.getIsland() + ",";
		line += this.getSpecimenType() + ",";
		line += this.getKindOfSpecimen() + ",";
		line += this.getPublicYn() + ",";
		line += this.getExtra().getDist().getDistYn() + ",";
		line += this.getExtra().getDist().getDistUrl() + ",";
		line += this.getExtra().getPatent().getParentNo() + ",";
		line += this.getExtra().getPatent().getRegNo() + ",";
		line += this.getExtra().getRef().getReference();
		
		return line;
	}

	@Override	
	public XSpecimenSheetObj getInstance( XSSFRow row ) {
		XSpecimenSheetObj obj = new XSpecimenSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(						this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.setMorphology(						this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.setKorAddr(							this.getVal(row.getCell(i) ) );
			else if( i == 3 )	obj.setEngAddr(							this.getVal(row.getCell(i) ) );
			else if( i == 4 )	obj.getGps().setLatitude(				this.getVal(row.getCell(i) ) );
			else if( i == 5 )	obj.getGps().setLongitude(				this.getVal(row.getCell(i) ) );
			else if( i == 6 )	obj.setColleUser(						this.getVal(row.getCell(i) ) );
			else if( i == 7 )	obj.setCollectDt(						this.getVal(row.getCell(i) ) );
			else if( i == 8 )	obj.setNation(							this.getVal(row.getCell(i) ) );
			else if( i == 9 )	obj.setOcean(							this.getVal(row.getCell(i) ) );
			else if( i == 10 )	obj.setIsland(							this.getVal(row.getCell(i) ) );
			else if( i == 11 )	obj.setSpecimenType(					this.getVal(row.getCell(i) ) );
			else if( i == 12 )	obj.setKindOfSpecimen(					this.getVal(row.getCell(i) ) );
			else if( i == 13 )	obj.setPublicYn(						this.getVal(row.getCell(i) ) );
			else if( i == 14 )	obj.getExtra().getDist().setDistYn(		this.getVal(row.getCell(i) ) );
			else if( i == 15 )	obj.getExtra().getDist().setDistUrl(	this.getVal(row.getCell(i) ) );
			else if( i == 16 )	obj.getExtra().getPatent().setParentNo(	this.getVal(row.getCell(i) ) );
			else if( i == 17 )	obj.getExtra().getPatent().setRegNo(	this.getVal(row.getCell(i) ) );
			else if( i == 18 )	obj.getExtra().getRef().setReference(	this.getVal(row.getCell(i) ) );
		}
		return obj;
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
