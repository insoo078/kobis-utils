package org.kobic.kobis.bris.services;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.bris.dao.BrisDAOService;
import org.kobic.kobis.common.services.AbstractCommonServices;
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
import org.kobic.kobis.main.vo.D1BodyFluidVO;
import org.kobic.kobis.main.vo.D1CellStrainVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.main.vo.D1DnaRnaProteinDerivativesVO;
import org.kobic.kobis.main.vo.D1DnaSequenceVO;
import org.kobic.kobis.main.vo.D1EmbryoVO;
import org.kobic.kobis.main.vo.D1EtcVO;
import org.kobic.kobis.main.vo.D1ExpressionVO;
import org.kobic.kobis.main.vo.D1ExtractionVO;
import org.kobic.kobis.main.vo.D1IndividualVO;
import org.kobic.kobis.main.vo.D1ObservationVO;
import org.kobic.kobis.main.vo.D1ProteinSequenceVO;
import org.kobic.kobis.main.vo.D1SeedVO;
import org.kobic.kobis.main.vo.D1SourceVO;
import org.kobic.kobis.main.vo.D1SpecimenVO;
import org.kobic.kobis.main.vo.D1StrainVO;
import org.kobic.kobis.main.vo.D1StructureVO;
import org.kobic.kobis.util.Utils;

public class BrisServices extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(BrisServices.class);
	
	private Map<String, String> prefixMap;

	private BrisDAOService brisService;
	
	public BrisServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
		this.brisService = new BrisDAOService( sessionFactory );
		this.prefixMap = new HashMap<String, String>();
		
		this.initPrefixMap();
	}
	
	private void initPrefixMap() {
		this.prefixMap.put("DNA/RNA/Protein 유래물", "DRPD");
		this.prefixMap.put("개체", "IND");
		this.prefixMap.put("관찰", "OBS");
		this.prefixMap.put("구조정보", "STR");
		this.prefixMap.put("균주", "S");
		this.prefixMap.put("기타", "ETC");
		this.prefixMap.put("단백질서열정보", "PRO_SEQ");
		this.prefixMap.put("발현정보", "EXP");
		this.prefixMap.put("배아", "EMB");
		this.prefixMap.put("세포주", "C");
		this.prefixMap.put("조직", "SOU");
		this.prefixMap.put("종자", "SEE");
		this.prefixMap.put("체액", "B");
		this.prefixMap.put("추출물", "EXT");
		this.prefixMap.put("표본", "SPEC");
		this.prefixMap.put("핵산서열정보", "DNA_SEQ");
	}
	
	public int unMappedProc( D1CommonVO vo ) {
		int uid = Integer.parseInt( vo.getAccess_num() );
		
		int unUid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );
		vo.setUid( unUid );

		int result = -1;
		if( vo.getUid() > 0 ) {
			if( vo.getCategory_2().equals("핵산서열정보") ) {
				XDnaSequenceSheetObj obj = this.brisService.getDnaSequence( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedDnaSequence( obj );
			}else if( vo.getCategory_2().equals("발현정보") ) {
				XExpressionSheetObj obj = this.brisService.getExpression( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedExpression(obj);
			}else if( vo.getCategory_2().equals("단백질서열정보") ) {
				XProteinSequenceSheetObj obj = this.brisService.getProteinSequence( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedProteinSequence(obj);
			}else if( vo.getCategory_2().equals("구조정보") ) {
				XStructureSheetObj obj = this.brisService.getStructure( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedStructure(obj);
			}else if( vo.getCategory_2().equals("추출물") ) {
				XExtractSheetObj obj = this.brisService.getExtraction( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedExtraction(obj);
			}else if( vo.getCategory_2().equals("DNA/RNA/Protein 유래물") ) {
				XDnaRnaProteinDerivativesSheetObj obj = this.brisService.getDnaRnaProteinDerivatives( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedDnaRnaProteinDerivatives(obj);
			}else if( vo.getCategory_2().equals("표본") ) {
				XSpecimenSheetObj obj = this.brisService.getSpecimen( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedSpecimen(obj);
			}else if( vo.getCategory_2().equals("관찰") ) {
				XObservationSheetObj obj = this.brisService.getObservation( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedObservation(obj);
			}else if( vo.getCategory_2().equals("기타") ) {
				XEtcSheetObj obj = this.brisService.getEtc( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedEtc(obj);
			}else if( vo.getCategory_2().equals("체액") ) {
				XBodyFluidSheetObj obj = this.brisService.getBodyFluid( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedBodyFluid(obj);
			}else if( vo.getCategory_2().equals("조직") ) {
				XSourceSheetObj obj = this.brisService.getSource(uid);
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedSource(obj);
			}else if( vo.getCategory_2().equals("개체") ) {
				XIndividualSheetObj obj = this.brisService.getIndividual( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedIndividual(obj);
			}else if( vo.getCategory_2().equals("균주") ) {
				XStrainSheetObj obj = this.brisService.getStrain( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedStrain(obj);
			}else if( vo.getCategory_2().equals("배아") ) {
				XEmbryoSheetObj obj = this.brisService.getEmbryo( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedEmbryo(obj);
			}else if( vo.getCategory_2().equals("종자") ) {
				XSeedSheetObj obj = this.brisService.getSeed( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedSeed(obj);
			}else if( vo.getCategory_2().equals("세포주") ) {
				XCellStrainSheetObj obj = this.brisService.getCellStrain( uid );
				obj.setUid( vo.getUid() );
				result = this.getUnmapService().insertT2UnmappedCellStrain(obj);
			}
		}
		return result;
	}
	
	private Map<String, Integer> initCntMap() {
		Map<String, Integer> cntMap = new HashMap<String, Integer>();
		String[] names = new String[]{"DNA/RNA/Protein 유래물"
				,"개체"
				,"관찰"
				,"구조정보"
				,"균주"
				,"기타"
				,"단백질서열정보"
				,"발현정보"
				,"배아"
				,"세포주"
				,"조직"
				,"종자"
				,"체액"
				,"추출물"
				,"표본"
				,"핵산서열정보"};
		
		for(String name:names) {
			cntMap.put(name, 0);
		}
		return cntMap;
	}

	private String getNewCount(Map<String, Integer> map, String type) {
		int new_cnt = map.get(type) + 1;
		map.put(type, new_cnt);

		return this.prefixMap.get(type) + Utils.lpad( Integer.toString( new_cnt ), 10 );
	}

	public int mappedProc( D1CommonVO vo ) throws IllegalAccessException, InvocationTargetException {
		int uid = Integer.parseInt( vo.getAccess_num() );

		Map<String, Integer> cntMap = this.initCntMap();

		int result = -1;
		if( vo.getUid() > 0 ) {
			if( vo.getCategory_2().equals("핵산서열정보") ) {
				XDnaSequenceSheetObj obj = this.brisService.getDnaSequence( uid );
				D1DnaSequenceVO vo2 = new D1DnaSequenceVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );

				result = this.getKobisService().insertD1DnaSequence( vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("발현정보") ) {
				XExpressionSheetObj obj = this.brisService.getExpression( uid );
				D1ExpressionVO vo2 = new D1ExpressionVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );

				result = this.getKobisService().insertD1Expression(vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("단백질서열정보") ) {
				XProteinSequenceSheetObj obj = this.brisService.getProteinSequence( uid );
				D1ProteinSequenceVO vo2 = new D1ProteinSequenceVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1ProteinSequence(vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("구조정보") ) {
				XStructureSheetObj obj = this.brisService.getStructure( uid );
				D1StructureVO vo2 = new D1StructureVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Structure(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("추출물") ) {
				XExtractSheetObj obj = this.brisService.getExtraction( uid );
				D1ExtractionVO vo2 = new D1ExtractionVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Extraction(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("DNA/RNA/Protein 유래물") ) {
				XDnaRnaProteinDerivativesSheetObj obj = this.brisService.getDnaRnaProteinDerivatives( uid );
				D1DnaRnaProteinDerivativesVO vo2 = new D1DnaRnaProteinDerivativesVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1DnaRnaProteinDerivatives( vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("표본") ) {
				XSpecimenSheetObj obj = this.brisService.getSpecimen( uid );
				D1SpecimenVO vo2 = new D1SpecimenVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Specimen(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("관찰") ) {
				XObservationSheetObj obj = this.brisService.getObservation( uid );
				D1ObservationVO vo2 = new D1ObservationVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Observation(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("기타") ) {
				XEtcSheetObj obj = this.brisService.getEtc( uid );
				D1EtcVO vo2 = new D1EtcVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Etc(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("체액") ) {
				XBodyFluidSheetObj obj = this.brisService.getBodyFluid( uid );
				D1BodyFluidVO vo2 = new D1BodyFluidVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1BodyFluid(vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("조직") ) {
				XSourceSheetObj obj = this.brisService.getSource(uid);
				D1SourceVO vo2 = new D1SourceVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Source(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("개체") ) {
				XIndividualSheetObj obj = this.brisService.getIndividual( uid );
				D1IndividualVO vo2 = new D1IndividualVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Individual(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("균주") ) {
				XStrainSheetObj obj = this.brisService.getStrain( uid );
				D1StrainVO vo2 = new D1StrainVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Strain(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("배아") ) {
				XEmbryoSheetObj obj = this.brisService.getEmbryo( uid );
				D1EmbryoVO vo2 = new D1EmbryoVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Embryo( vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("종자") ) {
				XSeedSheetObj obj = this.brisService.getSeed( uid );
				D1SeedVO vo2 = new D1SeedVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				result = this.getKobisService().insertD1Seed(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("세포주") ) {
				XCellStrainSheetObj obj = this.brisService.getCellStrain( uid );
				D1CellStrainVO vo2 = new D1CellStrainVO( obj );
				vo2.setUid( vo.getUid() );
				vo2.setId( this.getNewCount(cntMap, vo.getCategory_2() ) );
				this.getKobisService().insertD1CellStrain( vo2, this.getInsCd() );
			}
		}
		return result;
	}

	// D1_Common 처리
	public void read2() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.brisService.getTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		int mappedCnt = 0;

		
		List<D1CommonVO> mapList = new ArrayList<D1CommonVO>();
		List<D1CommonVO> unMapList = new ArrayList<D1CommonVO>();
		
		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;

			List<D1CommonVO> voList = this.brisService.getCommon( pagingIndex, paging );

			for( D1CommonVO vo : voList ) {
				wholeCnt++;
//				String scientificName = vo.getGenus() + " " + vo.getSpecies();

				int uid = this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() );
				int unUid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );

				if( uid < 0 && unUid < 0 ) {
					if( !Utils.nullToEmpty( vo.getCode() ).isEmpty() ) {
						mapList.add( vo );
					}else {
						unMapList.add( vo );
					}
				}

				String scientificName = vo.getGenus() + " " + vo.getSpecies();
				System.out.println( ">" + wholeCnt + "/" + totalCnt + " (" + scientificName + ") [" + vo.getCategory_2() + "]");
				if( mapList.size() == 500 ) {
					this.getKobisService().insertDirectD1Common( mapList );
					mapList = null;
					mapList = new ArrayList<D1CommonVO>();
					System.out.println( "maplist clear : " + mapList.size() );
				}
				
				if( unMapList.size() == 500 ) {
					this.getUnmapService().insertT2UnmappedCommon( unMapList );
					unMapList = null;
					unMapList = new ArrayList<D1CommonVO>();
					System.out.println( "unMaplist clear : " + unMapList.size() );
				}
			}
		}
		this.getKobisService().insertDirectD1Common( mapList );
		this.getUnmapService().insertT2UnmappedCommon( unMapList );

		System.out.println( "=======================================================" );
		System.out.println( "== Total records : " + totalCnt);
		System.out.println( "== Mapped records : " + mappedCnt);
		System.out.println( "== Unmapped records : " + (totalCnt-mappedCnt) );
		System.out.println( "== Mapping ratio : " + ((double)mappedCnt/totalCnt) + "%");
		System.out.println( "=======================================================" );
	}
	
	// 중분류 처리
	public void read() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.brisService.getTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		int mappedCnt = 0;

		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;

			List<D1CommonVO> voList = this.brisService.getCommon( pagingIndex, paging );

			for( D1CommonVO vo : voList ) {
				wholeCnt++;
				String scientificName = vo.getGenus() + " " + vo.getSpecies();

//				int uid = this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() );
//				int unUid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );

				System.out.println( ">" + wholeCnt + "/" + totalCnt + " (" + scientificName + ") [" + vo.getCategory_2() + "]");
//				if( uid < 0 && unUid < 0 ) {
//					if( !Utils.nullToEmpty( vo.getCode() ).isEmpty() ) {
						this.mappedProc(vo);
//					}else {
//						this.getUnmapService().insertT2UnmappedCommon( vo );
//						
//						long a = System.currentTimeMillis();
//						long b = System.currentTimeMillis();
//						System.err.println( " (" + (double)b/a + "sec)" );
////						this.unMappedProc(vo);
//					}
//				}
			}
		}
		System.out.println( "=======================================================" );
		System.out.println( "== Total records : " + totalCnt);
		System.out.println( "== Mapped records : " + mappedCnt);
		System.out.println( "== Unmapped records : " + (totalCnt-mappedCnt) );
		System.out.println( "== Mapping ratio : " + ((double)mappedCnt/totalCnt) + "%");
		System.out.println( "=======================================================" );
	}
	
	// Synonym 처리
	public void read3() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.brisService.getTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		int mappedCnt = 0;

		List<D1CommonVO> mapList = new ArrayList<D1CommonVO>();
		
		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;

			List<D1CommonVO> voList = this.brisService.getCommon( pagingIndex, paging );

			for( D1CommonVO vo : voList ) {
				wholeCnt++;
				mapList.add( vo );

				String scientificName = vo.getGenus() + " " + vo.getSpecies();
				System.out.println( ">" + wholeCnt + "/" + totalCnt + " (" + scientificName + ") [" + vo.getCategory_2() + "]");
				if( mapList.size() == 500 ) {
					this.getKobisService().insertE1SynonymsList( mapList );
					mapList = null;
					mapList = new ArrayList<D1CommonVO>();
					System.out.println( "maplist clear : " + mapList.size() );
				}
			}
		}
		this.getKobisService().insertE1SynonymsList( mapList );
		
		System.out.println( "=======================================================" );
		System.out.println( "== Total records : " + totalCnt);
		System.out.println( "== Mapped records : " + mappedCnt);
		System.out.println( "== Unmapped records : " + (totalCnt-mappedCnt) );
		System.out.println( "== Mapping ratio : " + ((double)mappedCnt/totalCnt) + "%");
		System.out.println( "=======================================================" );
	}
}
