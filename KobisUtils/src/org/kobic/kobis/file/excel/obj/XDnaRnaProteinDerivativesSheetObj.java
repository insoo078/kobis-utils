package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.SampleObj;
import org.kobic.kobis.file.excel.obj.internal.StoreObj;

@Alias("D1_DnaRnaProteinDerivatives")
public class XDnaRnaProteinDerivativesSheetObj extends AbstractSheetObj implements DistPatentReferenceInterface{
	private String source;
	private String detailType;
	private String depositType;
	private StoreObj store;
	private SampleObj sample;
	private DistPatentReferenceObj extra;

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDetailType() {
		return detailType;
	}
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public StoreObj getStore() {
		if( this.store == null )	this.store = new StoreObj();
		return store;
	}
	public void setStore(StoreObj store) {
		this.store = store;
	}
	public SampleObj getSample() {
		if( this.sample == null )	this.sample = new SampleObj();
		return sample;
	}
	public void setSample(SampleObj sample) {
		this.sample = sample;
	}
	public DistPatentReferenceObj getExtra() {
		if( this.extra == null )	this.extra = new DistPatentReferenceObj();
		return extra;
	}
	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}
	@Override
	public XDnaRnaProteinDerivativesSheetObj getInstance( XSSFRow row ) {
		XDnaRnaProteinDerivativesSheetObj obj = new XDnaRnaProteinDerivativesSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num(						this.getVal(row.getCell(i) ) );
			else if( i == 1 )	obj.setSource(							this.getVal(row.getCell(i) ) );
			else if( i == 2 )	obj.setDetailType(						this.getVal(row.getCell(i) ) );
			else if( i == 3 )	obj.setDepositType(						this.getVal(row.getCell(i) ) );
			else if( i == 4 )	obj.getSample().setSampleType(			this.getVal(row.getCell(i) ) );
			else if( i == 5 )	obj.getSample().setSampleDetail(		this.getVal(row.getCell(i) ) );
			else if( i == 6 )	obj.getSample().setSampleEtc(			this.getVal(row.getCell(i) ) );
			else if( i == 7 )	obj.getExtra().getDist().setDistYn(		this.getVal(row.getCell(i) ) );
			else if( i == 8 )	obj.getExtra().getDist().setDistUrl(	this.getVal(row.getCell(i) ) );
			else if( i == 9 )	obj.getExtra().getPatent().setParentNo(	this.getVal(row.getCell(i) ) );
			else if( i == 10 )	obj.getExtra().getPatent().setRegNo(	this.getVal(row.getCell(i) ) );
			else if( i == 11 )	obj.getExtra().getRef().setReference(	this.getVal(row.getCell(i) ) );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getSource() + ",";
		line += this.getDetailType() + ",";
		line += this.getDepositType() + ",";
		line += this.getSample().getSampleType() + ",";
		line += this.getSample().getSampleDetail() + ",";
		line += this.getSample().getSampleEtc() + ",";
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
