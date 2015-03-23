package org.kobic.kobis.file.excel.obj.internal;

import java.util.HashMap;
import java.util.Map;

public class ExcelWorksheetNameMap {
	private Map<String, String> excelWroksheetNameMap;
	
	private static ExcelWorksheetNameMap ewn;
	
	public ExcelWorksheetNameMap() {
		this.excelWroksheetNameMap= new HashMap<String, String>();
		{
			excelWroksheetNameMap.put( "공통",					"org.kobic.kobis.main.services.CommonServices" );
			excelWroksheetNameMap.put( "관찰",					"org.kobic.kobis.main.services.ObservationServices" );
			excelWroksheetNameMap.put( "표본",					"org.kobic.kobis.main.services.SpecimenServices" );
			excelWroksheetNameMap.put( "개체",					"org.kobic.kobis.main.services.IndividualServices" );
			excelWroksheetNameMap.put( "기관",					"org.kobic.kobis.main.services.OrganServices" );
			excelWroksheetNameMap.put( "조직",					"org.kobic.kobis.main.services.SourceServices" );
			excelWroksheetNameMap.put( "배아",					"org.kobic.kobis.main.services.EmbryoServices" );
			excelWroksheetNameMap.put( "종자",					"org.kobic.kobis.main.services.SeedServices" );
			excelWroksheetNameMap.put( "세포,세포주",				"org.kobic.kobis.main.services.CellStrainServices" );
			excelWroksheetNameMap.put( "균주",					"org.kobic.kobis.main.services.StrainServices" );
			excelWroksheetNameMap.put( "체액",					"org.kobic.kobis.main.services.BodyFluidServices" );
			excelWroksheetNameMap.put( "DNA,RNA,protein 유래물",	"org.kobic.kobis.main.services.DnaRnaProteinDerivativesServices" );
			excelWroksheetNameMap.put( "추출물",					"org.kobic.kobis.main.services.ExtractServices" );
			excelWroksheetNameMap.put( "핵산서열정보",				"org.kobic.kobis.main.services.DnaSequenceServices" );
			excelWroksheetNameMap.put( "발현정보",					"org.kobic.kobis.main.services.ExpressionServices" );
			excelWroksheetNameMap.put( "단백질서열정보",			"org.kobic.kobis.main.services.ProteinSequenceServices" );
			excelWroksheetNameMap.put( "구조정보",					"org.kobic.kobis.main.services.StructureServices" );
			excelWroksheetNameMap.put( "기타",					"org.kobic.kobis.main.services.EtcServices" );
		}
	}

	public String getClassNameFromSheetName(String sheetName) {
		return this.excelWroksheetNameMap.get(sheetName);
	}

	public synchronized static ExcelWorksheetNameMap getInstance(){
		if(ewn == null){
			ewn = new ExcelWorksheetNameMap();
		}
		return ewn;
	}
}
