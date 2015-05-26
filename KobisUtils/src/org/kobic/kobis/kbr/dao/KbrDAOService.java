package org.kobic.kobis.kbr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.bris.mapper.BrisMapper;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.file.excel.obj.XBodyFluidSheetObj;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.file.excel.obj.XDnaRnaProteinDerivativesSheetObj;
import org.kobic.kobis.file.excel.obj.XDnaSequenceSheetObj;
import org.kobic.kobis.file.excel.obj.XEmbryoSheetObj;
import org.kobic.kobis.file.excel.obj.XEtcSheetObj;
import org.kobic.kobis.file.excel.obj.XExpressionSheetObj;
import org.kobic.kobis.file.excel.obj.XExtractSheetObj;
import org.kobic.kobis.file.excel.obj.XIndividualSheetObj;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.file.excel.obj.XOrganSheetObj;
import org.kobic.kobis.file.excel.obj.XProteinSequenceSheetObj;
import org.kobic.kobis.file.excel.obj.XSeedSheetObj;
import org.kobic.kobis.file.excel.obj.XSourceSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.file.excel.obj.XStrainSheetObj;
import org.kobic.kobis.file.excel.obj.XStructureSheetObj;
import org.kobic.kobis.kbr.mapper.KbrMapper;
import org.kobic.kobis.main.vo.D1CommonVO;

public class KbrDAOService extends CommonDAOService implements KbrDAO{
	private static Logger logger = Logger.getLogger(KbrDAOService.class);

	public KbrDAOService(SqlSessionFactory sqlSessionFactory){
		super( sqlSessionFactory );
	}

	@Override
	public int getTotalCount() {
		SqlSession session = this.getSessionFactory().openSession( false );

		KbrMapper kbrMapper = session.getMapper( KbrMapper.class );

		return kbrMapper.getTotalCount();
	}

	@Override
	public List<D1CommonVO> getCommon(int pagingIndex, int paging) {
		SqlSession session = this.getSessionFactory().openSession( false );

		KbrMapper kbrMapper = session.getMapper( KbrMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pagingIndex", pagingIndex);
		map.put("paging", paging);

		List<D1CommonVO> voList = kbrMapper.getCommon( map );
		return voList;
	}

	@Override
	public XSpecimenSheetObj getSpecimen(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		KbrMapper kbrMapper = session.getMapper( KbrMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return kbrMapper.getSpecimen( map );
	}
}
