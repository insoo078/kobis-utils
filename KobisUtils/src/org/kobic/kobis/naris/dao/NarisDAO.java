package org.kobic.kobis.naris.dao;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.naris.vo.NarisSpeciesInfoVO;

public interface NarisDAO {
	public List<D1CommonVO> getNarisDataList( int pagingIndex, int paging );
	public int getTotalCount();
	public List<NarisSpeciesInfoVO> getSpeciesKorNameInfo(String scientific_name);
	public int updateKorNameWithInspeciesName(Map<String, String> map);
	public List<String> getScientificNameGroupByGenusWithSpecies();
}
