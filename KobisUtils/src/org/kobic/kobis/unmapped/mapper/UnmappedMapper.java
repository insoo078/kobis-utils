package org.kobic.kobis.unmapped.mapper;

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

public interface UnmappedMapper {
	public String getAccessionNum( Map<String, String> map );

	public int insertT2UnmappedCommon( D1CommonVO commonSheet );
	public int insertT2UnmappedCommonList( List<D1CommonVO> commonSheet );
	public int insertT2UnmappedEtc( XEtcSheetObj etcSheet);
	public int insertT2UnmappedDnaSequence( XDnaSequenceSheetObj dnaSequenceSheet );
	public int insertT2UnmappedStructure( XStructureSheetObj structureSheet );
	public int insertT2UnmappedExpression( XExpressionSheetObj expressionSheet );
	public int insertT2UnmappedProteinSequence( XProteinSequenceSheetObj proteinSequenceSheet );
	public int insertT2UnmappedStrain( XStrainSheetObj strainSheet );
	public int insertT2UnmappedCellStrain( XCellStrainSheetObj cellStrainSheet );
	public int insertT2UnmappedBodyFluid( XBodyFluidSheetObj bodyFluidSheet );
	public int insertT2UnmappedExtraction( XExtractSheetObj extractionSheet );
	public int insertT2UnmappedOrgan( XOrganSheetObj observationSheet );
	public int insertT2UnmappedObservation( XObservationSheetObj observationSheet );
	public int insertT2UnmappedIndividual( XIndividualSheetObj individualSheet );
	public int insertT2UnmappedSpecimen( XSpecimenSheetObj specimenSheet );
	public int insertT2UnmappedSource( XSourceSheetObj sourceSheet );
	public int insertT2UnmappedSeed( XSeedSheetObj seedSheet );
	public int insertT2UnmappedEmbryo( XEmbryoSheetObj embryoSheet );
	public int insertT2UnmappedDnaRnaProteinDerivatives( XDnaRnaProteinDerivativesSheetObj dnaRnaProteinDerivativeSheet );
	
	public int getUid( Map<String, Object> map );
}
