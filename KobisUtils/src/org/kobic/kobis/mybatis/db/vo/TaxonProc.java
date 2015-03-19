package org.kobic.kobis.mybatis.db.vo;

import java.util.List;

import org.kobic.kobis.mybatis.obj.MultipleClassificationObj;

public class TaxonProc {
	private String name;
	private String currentStatus;
	private List<NameWithTaxonIdVO> list;

	public TaxonProc(String name, List<NameWithTaxonIdVO> list) {
		this.name = name;
		this.list = list;

		if( this.list == null )				this.currentStatus = null;
		else if( this.list.isEmpty() )		this.currentStatus = MultipleClassificationObj.NOTHING_TO_MAP_IN_ALL;
		else if( this.list.size() > 1 )		this.currentStatus = MultipleClassificationObj.MULTIPLE_MAPPING;
		else								this.currentStatus = MultipleClassificationObj.FINE_MAPPING;
	}
	
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<NameWithTaxonIdVO> getList() {
		return list;
	}
	public void setList(List<NameWithTaxonIdVO> list) {
		this.list = list;
	}
	public String getMessage() {
		return "  " + this.name + "  : " + this.list.size();
	}
	public boolean isStatus( String status ) {
		if( this.currentStatus.equals( status ) )	return true;
		return false;
	}
	public boolean isEmpty() {
		if( this.list == null )			return true;
		else if( this.list.isEmpty() )	return true;
		return false;
	}
	public String getTaxId() {
		if( this.list == null )			return null;
		else if( this.list.isEmpty() )	return null;
		
		return this.list.get(0).getTax_id();
	}
}
