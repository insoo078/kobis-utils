package org.kobic.kobis.knnrrc.dao;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public interface KnnrrcDAO {
	public List<KnnrrcVO> getKnnrrcDataList( int pagingIndex, int paging );
	public int getTotalCount();
}
