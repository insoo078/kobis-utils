package org.kobic.kobis.kbr.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;

public interface KbrMapper {
	public List<D1CommonVO>		getCommon(Map<String, Integer> map);
	public XSpecimenSheetObj	getSpecimen(Map<String, Integer> map);
	
	public int getTotalCount();
}
