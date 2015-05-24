package org.kobic.kobis.bris.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

	private BrisDAOService brisService;
	
	public BrisServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
		this.brisService = new BrisDAOService( sessionFactory );
	}
	
	public int unMappedProc( D1CommonVO vo ) {
		int uid = Integer.parseInt( vo.getAccess_num() );
		
		int unUid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );
		vo.setUid( unUid );
		
		int result = -1;
		if( vo.getUid() > 0 ) {
			if( vo.getCategory_2().equals("핵산서열정보") ) {
				XDnaSequenceSheetObj obj = this.brisService.getDnaSequence( uid );
				result = this.getUnmapService().insertT2UnmappedDnaSequence( obj );
			}else if( vo.getCategory_2().equals("발현정보") ) {
				XExpressionSheetObj obj = this.brisService.getExpression( uid );
				result = this.getUnmapService().insertT2UnmappedExpression(obj);
			}else if( vo.getCategory_2().equals("단백질서열정보") ) {
				XProteinSequenceSheetObj obj = this.brisService.getProteinSequence( uid );
				result = this.getUnmapService().insertT2UnmappedProteinSequence(obj);
			}else if( vo.getCategory_2().equals("구조정보") ) {
				XStructureSheetObj obj = this.brisService.getStructure( uid );
				result = this.getUnmapService().insertT2UnmappedStructure(obj);
			}else if( vo.getCategory_2().equals("추출물") ) {
				XExtractSheetObj obj = this.brisService.getExtraction( uid );
				result = this.getUnmapService().insertT2UnmappedExtraction(obj);
			}else if( vo.getCategory_2().equals("DNA/RNA/Protein 유래물") ) {
				XDnaRnaProteinDerivativesSheetObj obj = this.brisService.getDnaRnaProteinDerivatives( uid );
				result = this.getUnmapService().insertT2UnmappedDnaRnaProteinDerivatives(obj);
			}else if( vo.getCategory_2().equals("표본") ) {
				XSpecimenSheetObj obj = this.brisService.getSpecimen( uid );
				result = this.getUnmapService().insertT2UnmappedSpecimen(obj);
			}else if( vo.getCategory_2().equals("관찰") ) {
				XObservationSheetObj obj = this.brisService.getObservation( uid );
				result = this.getUnmapService().insertT2UnmappedObservation(obj);
			}else if( vo.getCategory_2().equals("기타") ) {
				XEtcSheetObj obj = this.brisService.getEtc( uid );
				result = this.getUnmapService().insertT2UnmappedEtc(obj);
			}else if( vo.getCategory_2().equals("체액") ) {
				XBodyFluidSheetObj obj = this.brisService.getBodyFluid( uid );
				result = this.getUnmapService().insertT2UnmappedBodyFluid(obj);
			}else if( vo.getCategory_2().equals("조직") ) {
				XSourceSheetObj obj = this.brisService.getSource(uid);
				result = this.getUnmapService().insertT2UnmappedSource(obj);
			}else if( vo.getCategory_2().equals("개체") ) {
				XIndividualSheetObj obj = this.brisService.getIndividual( uid );
				result = this.getUnmapService().insertT2UnmappedIndividual(obj);
			}else if( vo.getCategory_2().equals("균주") ) {
				XStrainSheetObj obj = this.brisService.getStrain( uid );
				result = this.getUnmapService().insertT2UnmappedStrain(obj);
			}else if( vo.getCategory_2().equals("배아") ) {
				XEmbryoSheetObj obj = this.brisService.getEmbryo( uid );
				result = this.getUnmapService().insertT2UnmappedEmbryo(obj);
			}else if( vo.getCategory_2().equals("종자") ) {
				XSeedSheetObj obj = this.brisService.getSeed( uid );
				result = this.getUnmapService().insertT2UnmappedSeed(obj);
			}else if( vo.getCategory_2().equals("세포주") ) {
				XCellStrainSheetObj obj = this.brisService.getCellStrain( uid );
				result = this.getUnmapService().insertT2UnmappedCellStrain(obj);
			}
		}
		return result;
	}
	
	public int mappedProc( D1CommonVO vo ) throws IllegalAccessException, InvocationTargetException {
		int uid = Integer.parseInt( vo.getAccess_num() );
		
		vo.setUid( this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() ) );
		
		int result = -1;
		if( vo.getUid() > 0 ) {
			if( vo.getCategory_2().equals("핵산서열정보") ) {
				XDnaSequenceSheetObj obj = this.brisService.getDnaSequence( uid );
				D1DnaSequenceVO vo2 = new D1DnaSequenceVO( obj );
				result = this.getKobisService().insertD1DnaSequence( vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("발현정보") ) {
				XExpressionSheetObj obj = this.brisService.getExpression( uid );
				D1ExpressionVO vo2 = new D1ExpressionVO( obj );
				
				result = this.getKobisService().insertD1Expression(vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("단백질서열정보") ) {
				XProteinSequenceSheetObj obj = this.brisService.getProteinSequence( uid );
				D1ProteinSequenceVO vo2 = new D1ProteinSequenceVO( obj );
				result = this.getKobisService().insertD1ProteinSequence(vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("구조정보") ) {
				XStructureSheetObj obj = this.brisService.getStructure( uid );
				D1StructureVO vo2 = new D1StructureVO( obj );
				result = this.getKobisService().insertD1Structure(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("추출물") ) {
				XExtractSheetObj obj = this.brisService.getExtraction( uid );
				D1ExtractionVO vo2 = new D1ExtractionVO( obj );
				result = this.getKobisService().insertD1Extraction(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("DNA/RNA/Protein 유래물") ) {
				XDnaRnaProteinDerivativesSheetObj obj = this.brisService.getDnaRnaProteinDerivatives( uid );
				D1DnaRnaProteinDerivativesVO vo2 = new D1DnaRnaProteinDerivativesVO( obj );
				result = this.getKobisService().insertD1DnaRnaProteinDerivatives( vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("표본") ) {
				XSpecimenSheetObj obj = this.brisService.getSpecimen( uid );
				D1SpecimenVO vo2 = new D1SpecimenVO( obj );
				result = this.getKobisService().insertD1Specimen(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("관찰") ) {
				XObservationSheetObj obj = this.brisService.getObservation( uid );
				D1ObservationVO vo2 = new D1ObservationVO( obj );
				result = this.getKobisService().insertD1Observation(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("기타") ) {
				XEtcSheetObj obj = this.brisService.getEtc( uid );
				D1EtcVO vo2 = new D1EtcVO( obj );
				result = this.getKobisService().insertD1Etc(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("체액") ) {
				XBodyFluidSheetObj obj = this.brisService.getBodyFluid( uid );
				D1BodyFluidVO vo2 = new D1BodyFluidVO( obj );
				result = this.getKobisService().insertD1BodyFluid(vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("조직") ) {
				XSourceSheetObj obj = this.brisService.getSource(uid);
				D1SourceVO vo2 = new D1SourceVO( obj );
				result = this.getKobisService().insertD1Source(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("개체") ) {
				XIndividualSheetObj obj = this.brisService.getIndividual( uid );
				D1IndividualVO vo2 = new D1IndividualVO( obj );
				result = this.getKobisService().insertD1Individual(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("균주") ) {
				XStrainSheetObj obj = this.brisService.getStrain( uid );
				D1StrainVO vo2 = new D1StrainVO( obj );
				result = this.getKobisService().insertD1Strain(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("배아") ) {
				XEmbryoSheetObj obj = this.brisService.getEmbryo( uid );
				D1EmbryoVO vo2 = new D1EmbryoVO( obj );
				result = this.getKobisService().insertD1Embryo( vo2, this.getInsCd() );
			}else if( vo.getCategory_2().equals("종자") ) {
				XSeedSheetObj obj = this.brisService.getSeed( uid );
				D1SeedVO vo2 = new D1SeedVO( obj );
				result = this.getKobisService().insertD1Seed(vo2, this.getInsCd());
			}else if( vo.getCategory_2().equals("세포주") ) {
				XCellStrainSheetObj obj = this.brisService.getCellStrain( uid );
				D1CellStrainVO vo2 = new D1CellStrainVO( obj );
				this.getKobisService().insertD1CellStrain( vo2, this.getInsCd() );
			}
		}
		return result;
	}

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

				int uid = this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() );
				int unUid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );

				System.out.println( ">" + wholeCnt + "/" + totalCnt + " (" + scientificName + ") [" + vo.getCategory_2() + "]");
				if( uid < 0 && unUid < 0 ) {
					if( !Utils.nullToEmpty( vo.getCode() ).isEmpty() ) {
						int ret = this.getKobisService().insertDirectD1Common( vo );

//						this.mappedProc(vo);
						mappedCnt += ret;
					}else {
						this.getUnmapService().insertT2UnmappedCommon( vo );
//						this.unMappedProc(vo);
					}
				}
			}
		}
		System.out.println( "=======================================================" );
		System.out.println( "== Total records : " + totalCnt);
		System.out.println( "== Mapped records : " + mappedCnt);
		System.out.println( "== Unmapped records : " + (totalCnt-mappedCnt) );
		System.out.println( "== Mapping ratio : " + ((double)mappedCnt/totalCnt) + "%");
		System.out.println( "=======================================================" );
	}
}
