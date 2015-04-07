package org.kobic.kobis.knnrrc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.knnrrc.mapper.KnnrrcMapper;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;

public class KnnrrcDAOService extends CommonDAOService implements KnnrrcDAO{
	private static Logger logger = Logger.getLogger(KnnrrcDAOService.class);

	public KnnrrcDAOService(SqlSessionFactory sqlSessionFactory){
		super( sqlSessionFactory );
	}

	@Override
	public List<KnnrrcVO> getKnnrrcDataList(int pagingIndex, int paging) {
		SqlSession session = this.getSessionFactory().openSession( false );

		KnnrrcMapper knnrrcMapper = session.getMapper( KnnrrcMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pagingIndex", pagingIndex);
		map.put("paging", paging);

		List<KnnrrcVO> voList = knnrrcMapper.getKnnrrcDataList( map );
		return voList;
	}

	@Override
	public int getTotalCount() {
		SqlSession session = this.getSessionFactory().openSession( false );

		KnnrrcMapper knnrrcMapper = session.getMapper( KnnrrcMapper.class );

		return knnrrcMapper.getTotalCount();
	}
}
