package org.kobic.kobis.knnrrc.services;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.services.AbstractCommonServices;
import org.kobic.kobis.knnrrc.dao.KnnrrcDAOService;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.vo.D1BodyFluidVO;
import org.kobic.kobis.main.vo.D1CellStrainVO;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.main.vo.D1DnaRnaProteinDerivativesVO;
import org.kobic.kobis.main.vo.D1EmbryoVO;
import org.kobic.kobis.main.vo.D1EtcVO;
import org.kobic.kobis.main.vo.D1ExtractionVO;
import org.kobic.kobis.main.vo.D1IndividualVO;
import org.kobic.kobis.main.vo.D1SourceVO;
import org.kobic.kobis.main.vo.D1SpecimenVO;
import org.kobic.kobis.main.vo.D1StrainVO;
import org.kobic.kobis.taxon.proc.MultipleClassificationProc;
import org.kobic.kobis.util.Utils;

public class KnnrrcServices extends AbstractCommonServices{
	private KnnrrcDAOService knnrrcService;
	
	public KnnrrcServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
		this.knnrrcService = new KnnrrcDAOService( sessionFactory );
	}
	
	private int processCommon( KnnrrcVO vo, String scientificName ) {
		MultipleClassificationProc classifyObj = new MultipleClassificationProc( this.getSessionFactory() );
		
		D1CommonVO d1CommonVo = new D1CommonVO( vo );
		
		classifyObj.validate( scientificName );
		
		boolean canValidateToDatabase = classifyObj.updateDatabase( d1CommonVo, scientificName );
		if ( canValidateToDatabase )	return 1;
		
		return 0;
	}
	
	private int processSource( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1SourceVO vo = new D1SourceVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() )		ret = this.getKobisService().insertD1Source( vo, this.getInsCd() );
		else										ret = this.getUnmapService().insertT2UnmappedSource( vo );

		return ret;
	}

	private int processBodyFluid( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1BodyFluidVO d1BodyFluidVo = new D1BodyFluidVO( kvo );

		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() )	ret = this.getKobisService().insertD1BodyFluid( d1BodyFluidVo, this.getInsCd() );
		else									ret = this.getUnmapService().insertT2UnmappedBodyFluid( d1BodyFluidVo );

		return ret;
	}

	private int processExtraction( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1ExtractionVO d1ExtractVo = new D1ExtractionVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() )	ret = this.getKobisService().insertD1Extraction( d1ExtractVo, this.getInsCd() );
		else									ret = this.getUnmapService().insertT2UnmappedExtraction( d1ExtractVo );

		return ret;
	}
	
	private int processStrain( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1StrainVO vo = new D1StrainVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() )	ret = this.getKobisService().insertD1Strain( vo, this.getInsCd() );
		else									ret = this.getUnmapService().insertT2UnmappedStrain( vo );

		return ret;
	}

	private int processCellStrain( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1CellStrainVO d1CellStrainVo = new D1CellStrainVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() ) {
			ret = this.getKobisService().insertD1CellStrain( d1CellStrainVo, this.getInsCd() );
		}else {
			ret = this.getUnmapService().insertT2UnmappedCellStrain( d1CellStrainVo );
		}

		return ret;
	}

	private int processSpecimen( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1SpecimenVO vo = new D1SpecimenVO( kvo );

		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() )		ret = this.getKobisService().insertD1Specimen( vo, this.getInsCd() );
		else										ret = this.getUnmapService().insertT2UnmappedSpecimen( vo );

		return ret;
	}
	
	private int processEmbryo( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1EmbryoVO vo = new D1EmbryoVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() ) {
			ret = this.getKobisService().insertD1Embryo(vo, this.getInsCd());
		}else {
			ret = this.getUnmapService().insertT2UnmappedEmbryo(vo);
		}

		return ret;
	}

	private int processIndividual( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1IndividualVO vo = new D1IndividualVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() ) {
			ret = this.getKobisService().insertD1Individual(vo, this.getInsCd());
		}else {
			ret = this.getUnmapService().insertT2UnmappedIndividual(vo);
		}

		return ret;
	}

	private int processDnaRnaProteinDerivatives( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1DnaRnaProteinDerivativesVO d1DnaRnaProteinDerivativesnVo = new D1DnaRnaProteinDerivativesVO( kvo );

		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() ) {
			ret = this.getKobisService().insertD1DnaRnaProteinDerivatives(d1DnaRnaProteinDerivativesnVo, this.getInsCd());
		}else {
			ret = this.getUnmapService().insertT2UnmappedDnaRnaProteinDerivatives( d1DnaRnaProteinDerivativesnVo );
		}

		return ret;
	}
	
	private int processEtc( KnnrrcVO kvo, String accessionNumFromMapTab ) {
		D1EtcVO vo = new D1EtcVO( kvo );
		
		int ret = 0;
		if( !accessionNumFromMapTab.isEmpty() ) {
			ret = this.getKobisService().insertD1Etc(vo, this.getInsCd());
		}else {
			ret = this.getUnmapService().insertT2UnmappedEtc(vo);
		}

		return ret;
	}
	
	public void read() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.knnrrcService.getTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		int mappedCnt = 0;
		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;
			
			List<KnnrrcVO> voList = this.knnrrcService.getKnnrrcDataList(pagingIndex, paging);

			for(KnnrrcVO vo : voList) {
				String scientificName = vo.getGenus() + " " + vo.getSpecies();

				vo.setSds_no( "KNRRC" + vo.getSds_no() );
				
				String acc_num = this.getKobisService().getAccessionNum( vo.getAccession_no(), this.getInsCd() );
				
				if( Utils.nullToEmpty(acc_num).isEmpty() ) {
					int ret = this.processCommon( vo, scientificName );
					mappedCnt += ret;
				}
				wholeCnt++;
				
				System.out.println( ">" + wholeCnt + "/" + totalCnt );
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