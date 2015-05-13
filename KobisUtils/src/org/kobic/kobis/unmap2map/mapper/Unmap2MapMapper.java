package org.kobic.kobis.unmap2map.mapper;

import java.util.List;
import java.util.Map;

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

public interface Unmap2MapMapper {
	public List<D1CommonVO> getUnmappedCommon(Map<String, Integer> map);
	public int getUnmappedCommonTotalCount();

	public XCellStrainSheetObj getUnmappedCellStrain(Map<String, Integer> map);
	public XBodyFluidSheetObj 					getUnmappedBodyFluid(Map<String, Integer> map);
	public XDnaRnaProteinDerivativesSheetObj	getUnmappedDnaRnaProteinDerivatives(Map<String, Integer> map);
	public XDnaSequenceSheetObj 				getUnmappedDnaSequence(Map<String, Integer> map);
	public XEmbryoSheetObj 						getUnmappedEmbryo(Map<String, Integer> map);
	public XEtcSheetObj 						getUnmappedEtc(Map<String, Integer> map);
	public XExpressionSheetObj 					getUnmappedExpression(Map<String, Integer> map);
	public XExtractSheetObj 					getUnmappedExtraction(Map<String, Integer> map);
	public XIndividualSheetObj					getUnmappedIndividual(Map<String, Integer> map);
	public XObservationSheetObj 				getUnmappedObservation(Map<String, Integer> map);
	public XOrganSheetObj 						getUnmappedOrgan(Map<String, Integer> map);
	public XProteinSequenceSheetObj 			getUnmappedProteinSequence(Map<String, Integer> map);
	public XSeedSheetObj 						getUnmappedSeed(Map<String, Integer> map);
	public XSourceSheetObj 						getUnmappedSource(Map<String, Integer> map);
	public XSpecimenSheetObj 					getUnmappedSpecimen(Map<String, Integer> map);
	public XStrainSheetObj 						getUnmappedStrain(Map<String, Integer> map);
	public XStructureSheetObj 					getUnmappedStructure(Map<String, Integer> map);

	public int deleteUnmappedCommon(Map<String, Integer> map);
	public int deleteUnmappedCellStrain(Map<String, Integer> map);
	public int deleteUnmappedBodyFluid(Map<String, Integer> map);
	public int deleteUnmappedDnaRnaProteinDerivatives(Map<String, Integer> map);
	public int deleteUnmappedDnaSequence(Map<String, Integer> map);
	public int deleteUnmappedEmbryo(Map<String, Integer> map);
	public int deleteUnmappedEtc(Map<String, Integer> map);
	public int deleteUnmappedExpression(Map<String, Integer> map);
	public int deleteUnmappedExtraction(Map<String, Integer> map);
	public int deleteUnmappedIndividual(Map<String, Integer> map);
	public int deleteUnmappedObservation(Map<String, Integer> map);
	public int deleteUnmappedOrgan(Map<String, Integer> map);
	public int deleteUnmappedProteinSequence(Map<String, Integer> map);
	public int deleteUnmappedSeed(Map<String, Integer> map);
	public int deleteUnmappedSource(Map<String, Integer> map);
	public int deleteUnmappedSpecimen(Map<String, Integer> map);
	public int deleteUnmappedStrain(Map<String, Integer> map);
	public int deleteUnmappedStructure(Map<String, Integer> map);
}
