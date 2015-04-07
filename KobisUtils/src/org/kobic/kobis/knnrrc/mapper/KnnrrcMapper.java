package org.kobic.kobis.knnrrc.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public interface KnnrrcMapper {
	public List<KnnrrcVO> getKnnrrcDataList( Map<String, Integer> map );
	public int getTotalCount();
}
