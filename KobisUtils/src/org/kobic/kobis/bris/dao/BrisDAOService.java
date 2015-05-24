package org.kobic.kobis.bris.dao;

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
import org.kobic.kobis.main.vo.D1CommonVO;

public class BrisDAOService extends CommonDAOService implements BrisDAO{
	private static Logger logger = Logger.getLogger(BrisDAOService.class);

	public BrisDAOService(SqlSessionFactory sqlSessionFactory){
		super( sqlSessionFactory );
	}

	@Override
	public int getTotalCount() {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper knnrrcMapper = session.getMapper( BrisMapper.class );

		return knnrrcMapper.getTotalCount();
	}

	@Override
	public List<D1CommonVO> getCommon(int pagingIndex, int paging) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pagingIndex", pagingIndex);
		map.put("paging", paging);

		List<D1CommonVO> voList = brisMapper.getCommon( map );
		return voList;
	}

	@Override
	public XCellStrainSheetObj getCellStrain(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getCellStrain( map );
	}

	@Override
	public XBodyFluidSheetObj getBodyFluid(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getBodyFluid( map );
	}

	@Override
	public XDnaRnaProteinDerivativesSheetObj getDnaRnaProteinDerivatives(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getDnaRnaProteinDerivatives( map );
	}

	@Override
	public XDnaSequenceSheetObj getDnaSequence(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getDnaSequence( map );
	}

	@Override
	public XEmbryoSheetObj getEmbryo(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getEmbryo( map );
	}

	@Override
	public XEtcSheetObj getEtc(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getEtc( map );
	}

	@Override
	public XExpressionSheetObj getExpression(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getExpression( map );
	}

	@Override
	public XExtractSheetObj getExtraction(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getExtraction( map );
	}

	@Override
	public XIndividualSheetObj getIndividual(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getIndividual( map );
	}

	@Override
	public XObservationSheetObj getObservation(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getObservation( map );
	}

	@Override
	public XOrganSheetObj getOrgan(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getOrgan( map );
	}

	@Override
	public XProteinSequenceSheetObj getProteinSequence(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getProteinSequence( map );
	}

	@Override
	public XSeedSheetObj getSeed(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getSeed( map );
	}

	@Override
	public XSourceSheetObj getSource(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getSource( map );
	}

	@Override
	public XSpecimenSheetObj getSpecimen(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getSpecimen( map );
	}

	@Override
	public XStrainSheetObj getStrain(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getStrain( map );
	}

	@Override
	public XStructureSheetObj getStructure(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		BrisMapper brisMapper = session.getMapper( BrisMapper.class );

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);

		return brisMapper.getStructure( map );
	}
}
