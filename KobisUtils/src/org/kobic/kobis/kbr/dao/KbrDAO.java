package org.kobic.kobis.kbr.dao;

import java.util.List;

import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;

public interface KbrDAO {
	public List<D1CommonVO> 	getCommon( int page, int size);
	public XSpecimenSheetObj	getSpecimen(int uid);
	
	public int getTotalCount();
}
