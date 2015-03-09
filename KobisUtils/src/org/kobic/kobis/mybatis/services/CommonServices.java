package org.kobic.kobis.mybatis.services;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.kobic.kobis.file.excel.obj.XCommonSheetObj;
import org.kobic.kobis.file.excel.obj.internal.ExtraCodeInfo;
import org.kobic.kobis.mybatis.dao.KobisDAO;
import org.kobic.kobis.mybatis.db.vo.PhylogeneticTreeVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.rule.obj.CodeMappingRuleObj;
import org.kobic.kobis.util.Utils;

public class CommonServices extends AbstractKobisServices{
//	private HashMap<String, XCommonSheetObj> mapped;
//	private HashMap<String, XCommonSheetObj> unmapped;

	public CommonServices( String insCd, XSSFSheet sheet, KobisDAO dao ) {
		super( insCd, sheet, dao );
	}

	private void findKobisCodeInPhylogeneticTree( String speciesType, XCommonSheetObj commonSheetRecordObj, List<PhylogeneticTreeVO> kobisPhylogeneListFromDB ) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int assignedCount = 0;
		boolean isAssigned = false;

		if( speciesType != null ) {
			String property = speciesType.replace(".", "");
	
			for(Iterator<PhylogeneticTreeVO> iter=kobisPhylogeneListFromDB.iterator(); iter.hasNext();) {
				PhylogeneticTreeVO ptvo = iter.next();
				
				BeanInfo info = Introspector.getBeanInfo(ptvo.getClass(), Object.class);
			    PropertyDescriptor[] props = info.getPropertyDescriptors();

			    for (PropertyDescriptor pd : props) {
			        String name = pd.getName();
			        if( !name.equals(property) )	continue;

			        Method getter = pd.getReadMethod();
			        Class<?> type = pd.getPropertyType();

			        Object value = getter.invoke( ptvo );
			    }
	
	//			String ssp = ptvo.getSsp().split("\\|")[0];
	//			String var = ptvo.getVar().split("\\|")[0];
	//			String f = ptvo.getF().split("\\|")[0];
	//			
	//			if( ssp.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
	//				isAssigned = true;
	//				assignedCount++;
	//				obj.setKobisCode( vo.getCode() );
	//			}else if( var.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
	//				isAssigned = true;
	//				assignedCount++;
	//				obj.setKobisCode( vo.getCode() );
	//			}else if( f.trim().toUpperCase().equals( divSpecies[1].trim().toUpperCase() ) ) {
	//				isAssigned = true;
	//				assignedCount++;
	//				obj.setKobisCode( vo.getCode() );
	//			}
			}
		}
	}

	@Override
	public void readRecordsInSheet() throws NoSuchMethodException, SecurityException, Exception {
		if( this.getSheet().getLastRowNum() > 3 ) {

//			RuleParamObj params = new RuleParamObj();
			for( int j=3; j<=this.getSheet().getLastRowNum(); j++ ) {
				XSSFRow dataRow = this.getSheet().getRow(j);

				XCommonSheetObj commonSheetRecordObj = XCommonSheetObj.getNewInstance( dataRow );
				
				List<PhylogeneticTreeVO> kobisPhylogeneListFromDB = this.getDao().getPhylogeneticTreeByGenus( commonSheetRecordObj.getGenus() );

				if( kobisPhylogeneListFromDB.size() > 0 ) {
					Rule rule = new Rule( this.getInsCd() );

//					if( obj.getIn_species_type().equals("spp.") )
					rule.rule( commonSheetRecordObj );
					
					String speciesType	= Utils.emptyToNull( commonSheetRecordObj.getIn_species_type() );
					String genus		= commonSheetRecordObj.getGenus();
					String species		= commonSheetRecordObj.getSpecies();
					ExtraCodeInfo extraInfo = null;
					boolean extraType = false; 

					if( speciesType != null ) {
//						 추출물은행 예외사항
						if( this.getInsCd().equals("INS00001") ) {
							String[] seperateSpeciesToSpecific = species.split( speciesType );
							species = seperateSpeciesToSpecific[0];

							if( speciesType.equals("var.") )		extraInfo = new ExtraCodeInfo("var.",	seperateSpeciesToSpecific[1]);
							else if( speciesType.equals("ssp.") )	extraInfo = new ExtraCodeInfo("ssp.",	seperateSpeciesToSpecific[1]);
							else if( speciesType.equals("f.") )		extraInfo = new ExtraCodeInfo("f.",		seperateSpeciesToSpecific[1]);
							else if( speciesType.equals("line") )	extraInfo = new ExtraCodeInfo("line",	seperateSpeciesToSpecific[1]);
							else { }
						}

						extraType = true;
					}
					
					this.findKobisCodeInPhylogeneticTree(speciesType, commonSheetRecordObj, kobisPhylogeneListFromDB);

//					CodeMappingRuleObj ruleObj = new CodeMappingRuleObj( genus, species, extraInfo, extraType );
//
//					if( speciesType != null ) {
//						String[] divSpecies = species.split( speciesType );
//						
//						if( divSpecies.length != 3 )
//							System.out.println( commonSheetRecordObj.getAccess_num() + " " + species + " " + divSpecies.length + " " + speciesType );
////							System.out.println( commonSheetRecordObj.getPrintLine()  );
//					}
//					for(Iterator<PhylogeneticTreeVO> iter=kobisPhylogeneListFromDB.iterator(); iter.hasNext();) {
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
