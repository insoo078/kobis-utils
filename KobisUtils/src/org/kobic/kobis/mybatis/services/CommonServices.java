package org.kobic.kobis.mybatis.services;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XCommonSheetObj;
import org.kobic.kobis.file.excel.obj.internal.ExtraCodeInfo;
import org.kobic.kobis.mybatis.dao.KobisDAO;
import org.kobic.kobis.mybatis.db.vo.PhylogeneticTreeVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.rule.obj.CodeMappingRuleObj;
import org.kobic.kobis.rule.obj.RuleParamObj;
import org.kobic.kobis.util.Utils;

public class CommonServices extends AbstractKobisServices{
//	private HashMap<String, XCommonSheetObj> mapped;
//	private HashMap<String, XCommonSheetObj> unmapped;

	public CommonServices( String insCd, XSSFSheet sheet, KobisDAO dao ) {
		super( insCd, sheet, dao );
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException {
		if( this.getSheet().getLastRowNum() > 3 ) {

			RuleParamObj params = new RuleParamObj();
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);
				
				XCommonSheetObj obj = XCommonSheetObj.getNewInstance( dataRow );
				
				List<PhylogeneticTreeVO> listFromDB = this.getDao().getPhylogeneticTreeByGenus( obj.getGenus() );

				params.addParam("speciesType", Utils.emptyToNull( obj.getInSpeciesType() ) );
				params.addParam("genus", obj.getGenus());
				params.addParam("species", obj.getSpecies());

				if( listFromDB.size() > 0 ) {
					Rule rule = new Rule( this.getInsCd() );
					rule.rule( params );
					
					break;

//					String speciesType = Utils.emptyToNull( obj.getInSpeciesType() );
//					String genus	= obj.getGenus();
//					String species	= obj.getSpecies();
//					ExtraCodeInfo extraInfo = null;
//					boolean extraType = false; 

//					if( speciesType != null ) {
//						 추출물은행 예외사항
//						if( this.getInsCd().equals("INS000012") ) {
//							if( speciesType.equals("f.") )	species.replace(" for. ", " f. ");
//							if( speciesType.equals("spp."))	speciesType = "ssp.";
//	
//							String[] divSpecies = species.split( speciesType );
//							species = divSpecies[0];
//	
//							if( speciesType.equals("var.") )		extraInfo = new ExtraCodeInfo("var.",	divSpecies[1]);
//							else if( speciesType.equals("ssp.") )	extraInfo = new ExtraCodeInfo("ssp.",	divSpecies[1]);
//							else if( speciesType.equals("f.") )		extraInfo = new ExtraCodeInfo("f.",		divSpecies[1]);
//							else if( speciesType.equals("line") )	extraInfo = new ExtraCodeInfo("line",	divSpecies[1]);
//							else { }
//						}
//
//						extraType = true;
//					}

//					CodeMappingRuleObj ruleObj = new CodeMappingRuleObj( genus, species, extraInfo, extraType );

//					for(Iterator<PhylogeneticTreeVO> iter=listFromDB.iterator(); iter.hasNext();) {
//						PhylogeneticTreeVO dbo = iter.next();
//					}

//					String species = obj.getSpecies().replace("var.", "").replace("  ", " ");
//					String[] divSpecies = species.split(" ");
	
//					int assignedCount = 0;
//					boolean isAssigned = false;
//					for(Iterator<PhylogeneticTreeVO> iter=list.iterator(); iter.hasNext();) {
//						PhylogeneticTreeVO vo = iter.next();
//	
//						if( divSpecies.length > 1 ) {
//							String ssp = vo.getSsp().split("\\|")[0];
//							String var = vo.getVar().split("\\|")[0];
//							String f = vo.getF().split("\\|")[0];
//							
//							if( ssp.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
//								isAssigned = true;
//								assignedCount++;
//								obj.setKobisCode( vo.getCode() );
//							}else if( var.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
//								isAssigned = true;
//								assignedCount++;
//								obj.setKobisCode( vo.getCode() );
//							}else if( f.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
//								isAssigned = true;
//								assignedCount++;
//								obj.setKobisCode( vo.getCode() );
//							}
//						}else {
//							String spieces = vo.getSpecies().split("\\|")[0].trim().toUpperCase();
//							String ssp = vo.getSsp().split("\\|")[0].replace("종소명없음", "").trim();
//							String var = vo.getVar().split("\\|")[0].replace("종소명없음", "").trim();
//							String f = vo.getF().split("\\|")[0].replace("종소명없음", "").trim();
//	
//							if( obj.getSpecies().trim().toUpperCase().equals( spieces ) ) {
//								if( ssp.isEmpty() && var.isEmpty() && f.isEmpty() ) {
//									isAssigned = true;
//									assignedCount++;
//									obj.setKobisCode( vo.getCode() );
//								}
//							}else {
//	//									System.out.println( obj.getAccess_num() + "  " + obj.getSpecies().toUpperCase() + "  " + spieces );
//							}
//						}
//					}
				}
			}
		}
//		int totalRecord = 0;
//		int rightAssignment = 0;
//		// Loop for record
//		for( int j=3; j<=sheet.getLastRowNum(); j++ ) {
//			XSSFRow dataRow = sheet.getRow(j);
//			totalRecord++;
//			
//			CommonObj obj = CommonObj.getNewInstance( dataRow );
//
//			List<PhylogeneticTreeVO> list = session.selectList("Kobis.getPhylogeneticTreeByGenus", obj.getGenus() );
//
//			if( list == null ) {
//				// null
//				System.out.println("Genus [" + obj.getGenus() + "] is null ");
//			}else {
//				if( list.size() > 0 ) {
//					String species = obj.getSpecies().replace("var.", "").replace("  ", " ");
//					String[] divSpecies = species.split(" ");
//
//					int assignedCount = 0;
//					boolean isAssigned = false;
//					for(Iterator<PhylogeneticTreeVO> iter=list.iterator(); iter.hasNext();) {
//						PhylogeneticTreeVO vo = iter.next();
//
//						if( divSpecies.length > 1 ) {
//							String ssp = vo.getSsp().split("\\|")[0];
//							String var = vo.getVar().split("\\|")[0];
//							String f = vo.getF().split("\\|")[0];
//							
//							if( ssp.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
////										System.out.println( "SSP >>>" + ssp + " " + divSpecies[1] );
//								isAssigned = true;
//								assignedCount++;
//								obj.setKobisCode( vo.getCode() );
//							}else if( var.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
////										System.out.println( "VAR >>>" + ssp + " " + divSpecies[1] );
//								isAssigned = true;
//								assignedCount++;
//								obj.setKobisCode( vo.getCode() );
//							}else if( f.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
////										System.out.println( "F >>>" + ssp + " " + divSpecies[1] );
//								isAssigned = true;
//								assignedCount++;
//								obj.setKobisCode( vo.getCode() );
//							}
//						}else {
//							String spieces = vo.getSpecies().split("\\|")[0].trim().toUpperCase();
//							String ssp = vo.getSsp().split("\\|")[0].replace("종소명없음", "").trim();
//							String var = vo.getVar().split("\\|")[0].replace("종소명없음", "").trim();
//							String f = vo.getF().split("\\|")[0].replace("종소명없음", "").trim();
//
//							if( obj.getSpecies().trim().toUpperCase().equals( spieces ) ) {
//								if( ssp.isEmpty() && var.isEmpty() && f.isEmpty() ) {
//									isAssigned = true;
//									assignedCount++;
//									obj.setKobisCode( vo.getCode() );
//								}
//							}else {
////										System.out.println( obj.getAccess_num() + "  " + obj.getSpecies().toUpperCase() + "  " + spieces );
//							}
//						}
//					}
//					
////							System.out.println( obj.getAccess_num() + " " + assignedCount );
//					if( isAssigned == false ) {
//						String line = obj.getPrintLine();
//						bwNoSpeciesMapping.write( line );
//						bwNoSpeciesMapping.newLine();
//					}else {
//						String line = obj.getPrintLine();
//						bwRightMappedResult.write( line );
//						bwRightMappedResult.newLine();
//						rightAssignment++;
//					}
//				}else {
//					// empty
//
//					String line = obj.getPrintLine();
//					bwNoGenusMapping.write( line );
//					bwNoGenusMapping.newLine();
//				}
//			}
//		}
//		System.out.println( sheetName + " => " + rightAssignment + "/" + totalRecord);
	}
}
