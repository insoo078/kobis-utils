package org.kobic.kobis.naris.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.naris.mapper.NarisMapper;
import org.kobic.kobis.naris.vo.NarisSpeciesInfoVO;

public class NarisDAOService extends CommonDAOService implements NarisDAO{
	private static Logger logger = Logger.getLogger(NarisDAOService.class);

	public NarisDAOService(SqlSessionFactory sqlSessionFactory){
		super( sqlSessionFactory );
	}

	@Override
	public List<D1CommonVO> getNarisDataList(int pagingIndex, int paging) {
		SqlSession session = this.getSessionFactory().openSession( true );

		NarisMapper narisMapper = session.getMapper( NarisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pagingIndex", pagingIndex);
		map.put("paging", paging);

		List<D1CommonVO> voList = narisMapper.getNarisDataList( map );
		return voList;
	}

	@Override
	public int getTotalCount() {
		SqlSession session = this.getSessionFactory().openSession( true );

		NarisMapper narisMapper = session.getMapper( NarisMapper.class );

		return narisMapper.getTotalCount();
	}
	
	@Override
	public List<NarisSpeciesInfoVO> getSpeciesKorNameInfo(String scientific_name){
		SqlSession session = this.getSessionFactory().openSession( true );

		NarisMapper narisMapper = session.getMapper( NarisMapper.class );

		Map<String, String> map = new HashMap<String, String>();
		map.put("scientific_name", scientific_name);

		return narisMapper.getSpeciesKorNameInfo(map);
	}

	@Override
	public int updateKorNameWithInspeciesName(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = this.getSessionFactory().openSession( false );

		NarisMapper narisMapper = session.getMapper( NarisMapper.class );
		int result = 0;
		try {
			result = narisMapper.updateKorNameWithInspeciesName( map );
			session.commit();
		}catch(Exception e) {
			session.rollback();
			logger.error( e.getMessage() );
		}
		return result;
	}

	@Override
	public List<String> getScientificNameGroupByGenusWithSpecies() {
		SqlSession session = this.getSessionFactory().openSession( true );

		NarisMapper narisMapper = session.getMapper( NarisMapper.class );

		return narisMapper.getScientificNameGroupByGenusWithSpecies();
	}
}
