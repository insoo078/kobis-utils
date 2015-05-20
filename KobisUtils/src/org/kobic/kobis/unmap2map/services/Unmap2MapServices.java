package org.kobic.kobis.unmap2map.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
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
import org.kobic.kobis.file.excel.obj.XOrganSheetObj;
import org.kobic.kobis.file.excel.obj.XProteinSequenceSheetObj;
import org.kobic.kobis.file.excel.obj.XSeedSheetObj;
import org.kobic.kobis.file.excel.obj.XSourceSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.file.excel.obj.XStrainSheetObj;
import org.kobic.kobis.file.excel.obj.XStructureSheetObj;
import org.kobic.kobis.file.excel.obj.internal.AbstractSheetObj;
import org.kobic.kobis.main.vo.D1BodyFluidVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.main.vo.D1DnaRnaProteinDerivativesVO;
import org.kobic.kobis.main.vo.D1DnaSequenceVO;
import org.kobic.kobis.main.vo.D1EmbryoVO;
import org.kobic.kobis.main.vo.D1EtcVO;
import org.kobic.kobis.main.vo.D1ExpressionVO;
import org.kobic.kobis.main.vo.D1ExtractionVO;
import org.kobic.kobis.main.vo.D1IndividualVO;
import org.kobic.kobis.main.vo.D1ObservationVO;
import org.kobic.kobis.main.vo.D1OrganVO;
import org.kobic.kobis.main.vo.D1ProteinSequenceVO;
import org.kobic.kobis.main.vo.D1SeedVO;
import org.kobic.kobis.main.vo.D1SourceVO;
import org.kobic.kobis.main.vo.D1SpecimenVO;
import org.kobic.kobis.main.vo.D1StrainVO;
import org.kobic.kobis.main.vo.D1StructureVO;
import org.kobic.kobis.taxon.proc.MultipleClassificationProc;
import org.kobic.kobis.unmap2map.dao.Unmap2MapDAOService;
import org.kobic.kobis.util.Utils;

public class Unmap2MapServices extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(Unmap2MapServices.class);

	private Unmap2MapDAOService unmap2MapService;
	
	public Unmap2MapServices(SqlSessionFactory sessionFactory) {
		super(null, sessionFactory);

		this.unmap2MapService = new Unmap2MapDAOService( this.getSessionFactory() );
	}
	
	public boolean process( AbstractSheetObj obj, String insCd ) throws IllegalAccessException, InvocationTargetException {
		int uid = obj.getUid();
		if( obj instanceof XDnaRnaProteinDerivativesSheetObj ) {
			XDnaRnaProteinDerivativesSheetObj obj2 = (XDnaRnaProteinDerivativesSheetObj)obj;

			D1DnaRnaProteinDerivativesVO vo2 = new D1DnaRnaProteinDerivativesVO( obj2 );
			vo2.setUid( uid );
			int result = this.getKobisService().insertD1DnaRnaProteinDerivatives( vo2, insCd );
			
			if( result > 0 )	this.unmap2MapService.deleteUnmappedDnaRnaProteinDerivatives( uid );
			
			return true;
		}
		return false;
	}
	
	public void read() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.unmap2MapService.getUnmappedCommonTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int mappedCnt = 0;
		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;
			
			List<D1CommonVO> voList = this.unmap2MapService.getUnmappedCommon( pagingIndex, pagingIndex );

			for( D1CommonVO vo : voList ) {
				String accessoinNum = vo.getAccess_num();
				String insCd = vo.getIns_cd();

				int uid = this.getKobisService().getUid( accessoinNum, insCd );

				if( uid == -1 ) {
					String scientificName = vo.getScientificName();

					MultipleClassificationProc classifyObj = new MultipleClassificationProc( this.getSessionFactory() );

					String errorCode = classifyObj.validate( scientificName );

					if( errorCode == MultipleClassificationProc.NOTHING_TO_MAP_IN_ALL ) {
						String synonymStr = vo.getSynonym();
						String[] synonyms = Utils.nullToEmpty(synonymStr).split("\\,");
						for(int idx=0; idx<synonyms.length; idx++) {
							String synonym = Utils.nullToEmpty( synonyms[idx] ).trim().replace("\"", "").replace("'", "");
							errorCode = classifyObj.validate( synonym );

							if( errorCode == MultipleClassificationProc.FINE_MAPPING ) {
								scientificName = synonym;
								break;
							}
						}
					}

					if( errorCode.equals( MultipleClassificationProc.FINE_MAPPING ) ) {					
						boolean canValidateToDatabase = classifyObj.updateDatabase( vo, scientificName );
						if ( canValidateToDatabase ){	mappedCnt++;	}
						
						uid = this.getKobisService().getUid( accessoinNum, insCd );

						boolean pass = false;
						AbstractSheetObj	obj = this.unmap2MapService.getUnmappedDnaRnaProteinDerivatives(uid);
						
						if( obj != null ) {
							XDnaRnaProteinDerivativesSheetObj obj2 = (XDnaRnaProteinDerivativesSheetObj)obj;

							D1DnaRnaProteinDerivativesVO vo2 = new D1DnaRnaProteinDerivativesVO( obj2 );
							vo2.setUid( uid );
							int result = this.getKobisService().insertD1DnaRnaProteinDerivatives( vo2, insCd );
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedDnaRnaProteinDerivatives( uid );
							pass = true;
						}

						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedBodyFluid(uid);
							XBodyFluidSheetObj obj2 = (XBodyFluidSheetObj) obj;
							
							D1BodyFluidVO vo2 = new D1BodyFluidVO( obj2 );
							vo2.setUid( uid );
							int result = this.getKobisService().insertD1BodyFluid(vo2, insCd );
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedBodyFluid( uid );
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedEmbryo(uid);
							XEmbryoSheetObj obj2 = (XEmbryoSheetObj) obj;
							
							D1EmbryoVO vo2 = new D1EmbryoVO( obj2 );
							vo2.setUid( uid );
							int result = this.getKobisService().insertD1Embryo( vo2, insCd );
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedEmbryo( uid );
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedDnaSequence(uid);
							XDnaSequenceSheetObj obj2 = (XDnaSequenceSheetObj) obj;
							
							D1DnaSequenceVO vo2 = new D1DnaSequenceVO( obj2 );
							vo2.setUid( uid );
							int result = this.getKobisService().insertD1DnaSequence( vo2, insCd );
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedDnaSequence(uid);
							
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedEtc(uid);
							XEtcSheetObj obj2 = (XEtcSheetObj) obj;
							
							D1EtcVO vo2 = new D1EtcVO( obj2 );
							vo2.setUid( uid );
							
							int result = this.getKobisService().insertD1Etc(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedEtc(uid);
							
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedExpression(uid);
							XExpressionSheetObj obj2 = (XExpressionSheetObj) obj;
							
							D1ExpressionVO vo2 = new D1ExpressionVO( obj2 );
							vo2.setUid(uid);
							
							int result = this.getKobisService().insertD1Expression(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedExpression(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedExtraction(uid);
							XExtractSheetObj obj2 = (XExtractSheetObj) obj;

							D1ExtractionVO vo2 = new D1ExtractionVO( obj2 );
							int result = this.getKobisService().insertD1Extraction(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedExtraction(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedIndividual(uid);
							XIndividualSheetObj obj2 = (XIndividualSheetObj) obj;
							D1IndividualVO vo2 = new D1IndividualVO( obj2 );
							int result = this.getKobisService().insertD1Individual(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedIndividual(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedObservation(uid);
							XObservationSheetObj obj2 = (XObservationSheetObj) obj;
							D1ObservationVO vo2 = new D1ObservationVO( obj2 );
							int result = this.getKobisService().insertD1Observation(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedObservation(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedOrgan(uid);
							XOrganSheetObj obj2 = (XOrganSheetObj) obj;
							D1OrganVO vo2 = new D1OrganVO( obj2 );
							int result = this.getKobisService().insertD1Organ(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedOrgan(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedProteinSequence(uid);
							XProteinSequenceSheetObj obj2 = (XProteinSequenceSheetObj) obj;
							D1ProteinSequenceVO vo2 = new D1ProteinSequenceVO( obj2 );
							int result = this.getKobisService().insertD1ProteinSequence(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedProteinSequence(uid);
							pass = true;
						}
						
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedSeed(uid);
							XSeedSheetObj obj2 = (XSeedSheetObj) obj;
							D1SeedVO vo2 = new D1SeedVO( obj2 );
							int result = this.getKobisService().insertD1Seed(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedSeed(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedSource(uid);
							XSourceSheetObj obj2 = (XSourceSheetObj) obj;
							D1SourceVO vo2 = new D1SourceVO( obj2 );
							int result = this.getKobisService().insertD1Source(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedSource(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedSpecimen(uid);
							XSpecimenSheetObj obj2 = (XSpecimenSheetObj) obj;
							D1SpecimenVO vo2 = new D1SpecimenVO( obj2 );
							int result = this.getKobisService().insertD1Specimen(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedSpecimen(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedStrain(uid);
							XStrainSheetObj obj2 = (XStrainSheetObj) obj;
							D1StrainVO vo2 = new D1StrainVO( obj2 );
							int result = this.getKobisService().insertD1Strain(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedStrain(uid);
							pass = true;
						}
						if( pass == false ) {
							obj = this.unmap2MapService.getUnmappedStructure(uid);
							XStructureSheetObj obj2 = (XStructureSheetObj) obj;
							D1StructureVO vo2 = new D1StructureVO( obj2 );
							int result = this.getKobisService().insertD1Structure(vo2, insCd);
							
							if( result > 0 )	this.unmap2MapService.deleteUnmappedStructure(uid);
							pass = true;
						}						
						
						System.out.println("uid=" + uid);
					}
				}
			}
		}
	}
}