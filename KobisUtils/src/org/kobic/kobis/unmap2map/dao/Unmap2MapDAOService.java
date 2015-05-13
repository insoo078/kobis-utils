package org.kobic.kobis.unmap2map.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.knnrrc.mapper.KnnrrcMapper;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.unmap2map.mapper.Unmap2MapMapper;

public class Unmap2MapDAOService extends CommonDAOService implements Unmap2MapDAO{
	private static Logger logger = Logger.getLogger(Unmap2MapDAOService.class);

	public Unmap2MapDAOService(SqlSessionFactory sqlSessionFactory){
		super( sqlSessionFactory );
	}

	@Override
	public List<D1CommonVO> getUnmappedCommon(int pagingIndex, int paging) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pagingIndex", pagingIndex);
		map.put("paging", paging);

		List<D1CommonVO> voList = unmap2MapMapper.getUnmappedCommon( map );
		
		return voList;
	}

	@Override
	public int getUnmappedCommonTotalCount() {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		return unmap2MapMapper.getUnmappedCommonTotalCount();
	}

	@Override
	public XCellStrainSheetObj getUnmappedCellStrain(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedCellStrain( map );
	}
}
