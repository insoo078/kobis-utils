package org.kobic.kobis.bris.dao;

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
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.vo.D1CommonVO;

public interface BrisDAO {
	public List<D1CommonVO> 	getCommon( int page, int size);
	public XCellStrainSheetObj	getCellStrain(int uid);
	public XBodyFluidSheetObj	getBodyFluid(int uid);
	public XDnaRnaProteinDerivativesSheetObj	getDnaRnaProteinDerivatives(int uid);
	public XDnaSequenceSheetObj	getDnaSequence(int uid);
	public XEmbryoSheetObj		getEmbryo(int uid);
	public XEtcSheetObj			getEtc(int uid);
	public XExpressionSheetObj	getExpression(int uid);
	public XExtractSheetObj		getExtraction(int uid);
	public XIndividualSheetObj	getIndividual(int uid);
	public XObservationSheetObj	getObservation(int uid);
	public XOrganSheetObj		getOrgan(int uid);
	public XProteinSequenceSheetObj		getProteinSequence(int uid);
	public XSeedSheetObj		getSeed(int uid);
	public XSourceSheetObj		getSource(int uid);
	public XSpecimenSheetObj	getSpecimen(int uid);
	public XStrainSheetObj		getStrain(int uid);
	public XStructureSheetObj	getStructure(int uid);
	
	public int getTotalCount();
}
