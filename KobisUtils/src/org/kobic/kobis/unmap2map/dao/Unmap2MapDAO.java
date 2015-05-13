package org.kobic.kobis.unmap2map.dao;

import java.util.List;

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

public interface Unmap2MapDAO {
	public List<D1CommonVO> getUnmappedCommon(int pagingIndex, int paging);
	public int getUnmappedCommonTotalCount();

	public XCellStrainSheetObj 					getUnmappedCellStrain(int uid);
	public XBodyFluidSheetObj 					getUnmappedBodyFluid(int uid);
	public XDnaRnaProteinDerivativesSheetObj	getUnmappedDnaRnaProteinDerivatives(int uid);
	public XDnaSequenceSheetObj 				getUnmappedDnaSequence(int uid);
	public XEmbryoSheetObj 						getUnmappedEmbryo(int uid);
	public XEtcSheetObj 						getUnmappedEtc(int uid);
	public XExpressionSheetObj 					getUnmappedExpression(int uid);
	public XExtractSheetObj 					getUnmappedExtraction(int uid);
	public XIndividualSheetObj					getUnmappedIndividual(int uid);
	public XObservationSheetObj 				getUnmappedObservation(int uid);
	public XOrganSheetObj 						getUnmappedOrgan(int uid);
	public XProteinSequenceSheetObj 			getUnmappedProteinSequence(int uid);
	public XSeedSheetObj 						getUnmappedSeed(int uid);
	public XSourceSheetObj 						getUnmappedSource(int uid);
	public XSpecimenSheetObj 					getUnmappedSpecimen(int uid);
	public XStrainSheetObj 						getUnmappedStrain(int uid);
	public XStructureSheetObj 					getUnmappedStructure(int uid);

	public int deleteUnmappedCommon(int uid);
	public int deleteUnmappedCellStrain(int uid);
	public int deleteUnmappedBodyFluid(int uid);
	public int deleteUnmappedDnaRnaProteinDerivatives(int uid);
	public int deleteUnmappedDnaSequence(int uid);
	public int deleteUnmappedEmbryo(int uid);
	public int deleteUnmappedEtc(int uid);
	public int deleteUnmappedExpression(int uid);
	public int deleteUnmappedExtraction(int uid);
	public int deleteUnmappedIndividual(int uid);
	public int deleteUnmappedObservation(int uid);
	public int deleteUnmappedOrgan(int uid);
	public int deleteUnmappedProteinSequence(int uid);
	public int deleteUnmappedSeed(int uid);
	public int deleteUnmappedSource(int uid);
	public int deleteUnmappedSpecimen(int uid);
	public int deleteUnmappedStrain(int uid);
	public int deleteUnmappedStructure(int uid);
}
