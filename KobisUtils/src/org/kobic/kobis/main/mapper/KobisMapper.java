package org.kobic.kobis.main.mapper;

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
import org.kobic.kobis.file.excel.obj.XProteinSequenceSheetObj;
import org.kobic.kobis.file.excel.obj.XSeedSheetObj;
import org.kobic.kobis.file.excel.obj.XSourceSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.file.excel.obj.XStrainSheetObj;
import org.kobic.kobis.file.excel.obj.XStructureSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;

public interface KobisMapper {
    public String getInstitutionId(String insCd);    
    public String getAccessionNum( Map<String, String> map );
    public int insertE1Synonyms( D1CommonVO d1CommonVo );
    public int insertD1Common( D1CommonVO d1CommonVo );
    public int insertObservation( XObservationSheetObj observationSheet );
    public int insertD1Individual( XIndividualSheetObj individualSheet );
    public int insertD1Specimen( XSpecimenSheetObj specimenSheet );
    public int insertD1Source( XSourceSheetObj sourceSheet );
    public int insertD1Seed( XSeedSheetObj seedSheet );
    public int insertD1Embryo( XEmbryoSheetObj embryoSheet );
    public int insertD1DnaRnaProteinDerivatives( XDnaRnaProteinDerivativesSheetObj dnaRnaProteinDerivativeSheet );
    public int insertD1Strain( XStrainSheetObj strainSheet );
    public int insertD1CellStrain( XCellStrainSheetObj cellStrainSheet );
    public int insertD1BodyFluid( XBodyFluidSheetObj bodyFluidSheet );
    public int insertD1ProteinSequence( XProteinSequenceSheetObj proteinSequenceSheet );
    public int insertD1Expression( XExpressionSheetObj expressionSheet );
    public int insertD1Structure( XStructureSheetObj structureSheet );
    public int insertD1DnaSequence( XDnaSequenceSheetObj dnaSequenceSheet );
    public int insertD1Etc( XEtcSheetObj etcSheet);
    public int insertD1Extraction( XExtractSheetObj extractionSheet );
    public int insertE1Culture( Map<String, String> cultureSheet );
    public int insertE1Store( Map<String, String> cultureSheet );
    public int insertE1Distribution( Map<String, String> cultureSheet );
    public int insertE1Reference( Map<String, String> cultureSheet );
    public int insertE1Paten( Map<String, String> cultureSheet );
    public int insertMappedD1Common( D1CommonVO commonSheet );

}
