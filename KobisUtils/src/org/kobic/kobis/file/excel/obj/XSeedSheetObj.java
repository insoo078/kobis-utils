package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.StoreObj;

@Alias("D1_Seed")
public class XSeedSheetObj extends AbstractSheetObj implements DistPatentReferenceInterface{
	private String seedStatus;
	private StoreObj store;
	private DistPatentReferenceObj extra;

	public String getSeedStatus() {
		return seedStatus;
	}

	public void setSeedStatus(String source) {
		this.seedStatus = source;
	}

	public StoreObj getStore() {
		if( this.store == null )	this.store = new StoreObj();
		return store;
	}

	public void setStore(StoreObj store) {
		this.store = store;
	}

	public DistPatentReferenceObj getExtra() {
		if( this.extra == null )	this.extra = new DistPatentReferenceObj();
		return extra;
	}

	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}

	@Override
	public XSeedSheetObj getInstance( XSSFRow row ) {
		XSeedSheetObj obj = new XSeedSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(						this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.setSeedStatus(						this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.getExtra().getDist().setDistYn(		this.getVal(row.getCell(i) ) );
			else if( i == 3 )	obj.getExtra().getDist().setDistUrl(	this.getVal(row.getCell(i) ) );
			else if( i == 4 )	obj.getExtra().getPatent().setParentNo(	this.getVal(row.getCell(i) ) );
			else if( i == 5 )	obj.getExtra().getPatent().setRegNo(	this.getVal(row.getCell(i) ) );
			else if( i == 6 )	obj.getExtra().getRef().setReference(	this.getVal(row.getCell(i) ) );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getSeedStatus() + ",";
		line += this.getStore().getStorePlace() + ",";
		line += this.getStore().getStoreNo() + ",";
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
