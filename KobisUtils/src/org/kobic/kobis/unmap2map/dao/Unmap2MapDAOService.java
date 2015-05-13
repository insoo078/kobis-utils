package org.kobic.kobis.unmap2map.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
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

	@Override
	public XBodyFluidSheetObj getUnmappedBodyFluid(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedBodyFluid( map );
	}

	@Override
	public XDnaRnaProteinDerivativesSheetObj getUnmappedDnaRnaProteinDerivatives(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedDnaRnaProteinDerivatives( map );
	}

	@Override
	public XDnaSequenceSheetObj getUnmappedDnaSequence(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedDnaSequence( map );
	}

	@Override
	public XEmbryoSheetObj getUnmappedEmbryo(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedEmbryo( map );
	}

	@Override
	public XEtcSheetObj getUnmappedEtc(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedEtc( map );
	}

	@Override
	public XExpressionSheetObj getUnmappedExpression(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedExpression( map );
	}

	@Override
	public XExtractSheetObj getUnmappedExtraction(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedExtraction( map );
	}

	@Override
	public XIndividualSheetObj getUnmappedIndividual(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedIndividual( map );
	}

	@Override
	public XObservationSheetObj getUnmappedObservation(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedObservation( map );

	}

	@Override
	public XOrganSheetObj getUnmappedOrgan(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedOrgan( map );
	}

	@Override
	public XProteinSequenceSheetObj getUnmappedProteinSequence(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedProteinSequence( map );
	}

	@Override
	public XSeedSheetObj getUnmappedSeed(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedSeed( map );
	}

	@Override
	public XSourceSheetObj getUnmappedSource(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedSource( map );
	}

	@Override
	public XSpecimenSheetObj getUnmappedSpecimen(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedSpecimen( map );
	}

	@Override
	public XStrainSheetObj getUnmappedStrain(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedStrain( map );
	}

	@Override
	public XStructureSheetObj getUnmappedStructure(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.getUnmappedStructure( map );
	}

	
	@Override
	public int deleteUnmappedCommon(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedCommon( map );
	}

	@Override
	public int deleteUnmappedCellStrain(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedCellStrain( map );
	}

	@Override
	public int deleteUnmappedBodyFluid(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedBodyFluid( map );
	}

	@Override
	public int deleteUnmappedDnaRnaProteinDerivatives(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedDnaRnaProteinDerivatives( map );
	}

	@Override
	public int deleteUnmappedDnaSequence(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedDnaSequence( map );
	}

	@Override
	public int deleteUnmappedEmbryo(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedEmbryo( map );
	}

	@Override
	public int deleteUnmappedEtc(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedEtc( map );
	}

	@Override
	public int deleteUnmappedExpression(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedExpression( map );
	}

	@Override
	public int deleteUnmappedExtraction(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedExtraction( map );
	}

	@Override
	public int deleteUnmappedIndividual(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedIndividual( map );
	}

	@Override
	public int deleteUnmappedObservation(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedObservation( map );
	}

	@Override
	public int deleteUnmappedOrgan(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedOrgan( map );
	}

	@Override
	public int deleteUnmappedProteinSequence(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedProteinSequence( map );
	}

	@Override
	public int deleteUnmappedSeed(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedSeed( map );
	}

	@Override
	public int deleteUnmappedSource(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedSource( map );
	}

	@Override
	public int deleteUnmappedSpecimen(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedSpecimen( map );
	}

	@Override
	public int deleteUnmappedStrain(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedStrain( map );
	}

	@Override
	public int deleteUnmappedStructure(int uid) {
		SqlSession session = this.getSessionFactory().openSession( false );

		Unmap2MapMapper unmap2MapMapper = session.getMapper( Unmap2MapMapper.class );
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("uid", uid);
		return unmap2MapMapper.deleteUnmappedStructure( map );
	}
}
