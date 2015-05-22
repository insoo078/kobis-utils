package org.kobic.kobis.naris.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.naris.vo.NarisSpeciesInfoVO;

public interface NarisMapper {
	public List<D1CommonVO> getNarisDataList( Map<String, Integer> map );
	public int getTotalCount();
	
	public List<NarisSpeciesInfoVO> getSpeciesKorNameInfo(Map<String, String> map);
	public int updateKorNameWithInspeciesName(Map<String, String> map);
	public List<String> getScientificNameGroupByGenusWithSpecies();
	
	public List<XObservationSheetObj> getNarisObservation(Map<String, Integer> map);
	
	public List<XSpecimenSheetObj> getNarisSpecimen(Map<String, Integer> map);
	
	public int getSpecimenTotalCount();
	public int getObservationTotalCount();
}
