package org.kobic.kobis.naris.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.naris.vo.NarisSpeciesInfoVO;

public interface NarisMapper {
	public List<D1CommonVO> getNarisDataList( Map<String, Integer> map );
	public int getTotalCount();
	
	public List<NarisSpeciesInfoVO> getSpeciesKorNameInfo(Map<String, String> map);
	public int updateKorNameWithInspeciesName(Map<String, String> map);
	public List<String> getScientificNameGroupByGenusWithSpecies();
}
