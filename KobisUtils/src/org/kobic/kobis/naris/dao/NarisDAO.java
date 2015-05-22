package org.kobic.kobis.naris.dao;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.naris.vo.NarisSpeciesInfoVO;

public interface NarisDAO {
	public List<D1CommonVO> getNarisDataList( int pagingIndex, int paging );
	public int getTotalCount();
	public List<NarisSpeciesInfoVO> getSpeciesKorNameInfo(String scientific_name);
	public int updateKorNameWithInspeciesName(Map<String, String> map);
	public List<String> getScientificNameGroupByGenusWithSpecies();
	
	public List<XObservationSheetObj> getNarisObservation(int pagingIndex, int paging);
	public List<XSpecimenSheetObj> getNarisSpecimen(int pagingIndex, int paging);
	public int getSpecimenTotalCount();
	public int getObservationTotalCount();
}
