package org.kobic.kobis.unmap2map.dao;

import java.util.List;

import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;

public interface Unmap2MapDAO {
	public List<D1CommonVO> getUnmappedCommon(int pagingIndex, int paging);
	public int getUnmappedCommonTotalCount();
	public XCellStrainSheetObj getUnmappedCellStrain(int uid);
}
