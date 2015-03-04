package org.kobic.kobis.file.excel.obj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.SampleObj;
import org.kobic.kobis.file.excel.obj.internal.StoreObj;

public class XDnaRnaProteinDerivativesSheetObj extends AbstractSheetObj{
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
		return store;
	}
	public void setStore(StoreObj store) {
		this.store = store;
	}
	public SampleObj getSample() {
		return sample;
	}
	public void setSample(SampleObj sample) {
		this.sample = sample;
	}
	public DistPatentReferenceObj getExtra() {
		return extra;
	}
	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}
	@Override
	public XDnaRnaProteinDerivativesSheetObj getInstance( XSSFRow row ) {
		XDnaRnaProteinDerivativesSheetObj obj = new XDnaRnaProteinDerivativesSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setSource( row.getCell(i).toString() );
			else if( i == 2 )	obj.setDetailType( row.getCell(i).toString() );
			else if( i == 3 )	obj.setDepositType( row.getCell(i).toString() );
			else if( i == 4 )	obj.getSample().setSampleType( row.getCell(i).toString() );
			else if( i == 5 )	obj.getSample().setSampleDetail( row.getCell(i).toString() );
			else if( i == 6 )	obj.getSample().setSampleEtc( row.getCell(i).toString() );
			else if( i == 7 )	obj.getExtra().getDist().setDistYn( row.getCell(i).toString() );
			else if( i == 8 )	obj.getExtra().getDist().setDistUrl( row.getCell(i).toString() );
			else if( i == 9 )	obj.getExtra().getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 10 )	obj.getExtra().getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 11 )	obj.getExtra().getRef().setReference( row.getCell(i).toString() );
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
}
