package org.kobic.kobis.file.excel.obj;

import org.apache.ibatis.type.Alias;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.StoreObj;

@Alias("D1_Embryo")
public class XEmbryoSheetObj extends AbstractSheetObj{
	private String embryo;
	private StoreObj store;
	private DistPatentReferenceObj extra;

	public String getEmbryo() {
		return embryo;
	}

	public void setEmbryo(String source) {
		this.embryo = source;
	}

	public StoreObj getStore() {
		return store;
	}

	public void setStore(StoreObj store) {
		this.store = store;
	}

	public DistPatentReferenceObj getExtra() {
		return extra;
	}

	public void setExtra(DistPatentReferenceObj extra) {
		this.extra = extra;
	}

	@Override
	public XEmbryoSheetObj getInstance( XSSFRow row ) {
		XEmbryoSheetObj obj = new XEmbryoSheetObj();
		for(int i=row.getFirstCellNum(); i<=row.getLastCellNum(); i++) {
			if( i == 0 )		obj.setAccess_num( row.getCell(i).toString() );
			else if( i == 1 )	obj.setEmbryo( row.getCell(i).toString() );
			else if( i == 2 )	obj.getExtra().getDist().setDistYn( row.getCell(i).toString() );
			else if( i == 3 )	obj.getExtra().getDist().setDistUrl( row.getCell(i).toString() );
			else if( i == 4 )	obj.getExtra().getPatent().setParentNo( row.getCell(i).toString() );
			else if( i == 5 )	obj.getExtra().getPatent().setRegNo( row.getCell(i).toString() );
			else if( i == 6 )	obj.getExtra().getRef().setReference( row.getCell(i).toString() );
		}
		return obj;
	}

	@Override
	public String getPrintLine() {
		String line = this.getAccess_num() + ",";
		line += this.getEmbryo() + ",";
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
