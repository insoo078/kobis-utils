package org.kobic.kobis.unmap2map.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.main.vo.D1CommonVO;

public interface Unmap2MapMapper {
	public List<D1CommonVO> getUnmappedCommon(Map<String, Integer> map);
	public int getUnmappedCommonTotalCount();
}
