package org.kobic.kobis.bris.mapper;

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

public interface BrisMapper {
	public List<D1CommonVO>		getCommon(Map<String, Integer> map);
	public XCellStrainSheetObj	getCellStrain(Map<String, Integer> map);
	public XBodyFluidSheetObj	getBodyFluid(Map<String, Integer> map);
	public XDnaRnaProteinDerivativesSheetObj	getDnaRnaProteinDerivatives(Map<String, Integer> map);
	public XDnaSequenceSheetObj	getDnaSequence(Map<String, Integer> map);
	public XEmbryoSheetObj		getEmbryo(Map<String, Integer> map);
	public XEtcSheetObj			getEtc(Map<String, Integer> map);
	public XExpressionSheetObj	getExpression(Map<String, Integer> map);
	public XExtractSheetObj		getExtraction(Map<String, Integer> map);
	public XIndividualSheetObj	getIndividual(Map<String, Integer> map);
	public XObservationSheetObj	getObservation(Map<String, Integer> map);
	public XOrganSheetObj		getOrgan(Map<String, Integer> map);
	public XProteinSequenceSheetObj		getProteinSequence(Map<String, Integer> map);
	public XSeedSheetObj		getSeed(Map<String, Integer> map);
	public XSourceSheetObj		getSource(Map<String, Integer> map);
	public XSpecimenSheetObj	getSpecimen(Map<String, Integer> map);
	public XStrainSheetObj		getStrain(Map<String, Integer> map);
	public XStructureSheetObj	getStructure(Map<String, Integer> map);
	
	public int getTotalCount();
}
