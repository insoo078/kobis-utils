package org.kobic.kobis.naris.services;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.services.AbstractCommonServices;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.file.excel.obj.XSpecimenSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.main.vo.D1ObservationVO;
import org.kobic.kobis.main.vo.D1SpecimenVO;
import org.kobic.kobis.naris.dao.NarisDAOService;
import org.kobic.kobis.naris.vo.NarisSpeciesInfoVO;
import org.kobic.kobis.taxon.proc.MultipleClassificationProc;

public class NarisServices extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(NarisServices.class);

	private NarisDAOService narisService;
	
	public NarisServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
		this.narisService = new NarisDAOService( sessionFactory );
	}
	
	private int processCommon( D1CommonVO d1CommonVo, String scientificName ) {
		MultipleClassificationProc classifyObj = new MultipleClassificationProc( this.getSessionFactory() );
		
		classifyObj.validate( scientificName );
		
		boolean canValidateToDatabase = classifyObj.updateDatabase( d1CommonVo, scientificName );
		if ( canValidateToDatabase )	return 1;
		
		return 0;
	}
	
	private int processSpecimen( XSpecimenSheetObj obj2, String insCd, String accessionNumFromMapTab ) throws IllegalAccessException, InvocationTargetException {
		D1SpecimenVO vo2 = new D1SpecimenVO( obj2 );

		int ret = -1;
		if( !accessionNumFromMapTab.isEmpty() )	ret = this.getKobisService().insertD1Specimen(vo2, insCd);
		else									ret = this.getUnmapService().insertT2UnmappedSpecimen( obj2 );

		return ret;
	}

	private int processObservation( XObservationSheetObj obj2, String insCd, String accessionNumFromMapTab ) throws IllegalAccessException, InvocationTargetException {
		D1ObservationVO vo2 = new D1ObservationVO( obj2 );

		int ret = -1;
		if( !accessionNumFromMapTab.isEmpty() )	ret = this.getKobisService().insertD1Observation(vo2, insCd);
		else									ret = this.getUnmapService().insertT2UnmappedObservation( obj2 );

		return ret;
	}

	public void updateKoreanWithInSpecies() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
//		int totalCnt = this.narisService.getTotalCount();
		List<String> voList = this.narisService.getScientificNameGroupByGenusWithSpecies();
		int totalCnt = voList.size();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		for(String vo:voList) {
			wholeCnt++;

			String scientificName = vo;
			
			System.out.println( ">" + wholeCnt + "/" + totalCnt + " (" + scientificName + ") " );
				
			long start = System.currentTimeMillis();
			List<NarisSpeciesInfoVO> lst = this.narisService.getSpeciesKorNameInfo( scientificName );
			long end = System.currentTimeMillis();

			String time = Double.toString( ((double)end-start)/1000 ) + "sec";
			if( lst != null ) {
				if( lst.size() > 1 ) {
					System.out.println("  more than 1 : " + scientificName + " : " + time);
				}else if( lst.size() == 1 ) {
					System.out.println("  only 1 : " + scientificName + " : " + lst.get(0).getKor_name() + " " + time);
					Map<String, String> map = new HashMap<String, String>();
					map.put("scientific_name", scientificName);
					map.put("kor_name", lst.get(0).getKor_name() );
					map.put("in_species_name", lst.get(0).getIn_species_name());

					int result = this.narisService.updateKorNameWithInspeciesName( map );
				}
			}
		}
	}

	public void read() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.narisService.getTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		int mappedCnt = 0;
		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;

			List<D1CommonVO> voList = this.narisService.getNarisDataList(pagingIndex, paging);

			for( D1CommonVO vo : voList ) {
				wholeCnt++;
				String scientificName = vo.getGenus() + " " + vo.getSpecies();

				int uid = this.getKobisService().getUid( vo.getAccess_num(), this.getInsCd() );
				int unUid = this.getUnmapService().getUid( vo.getAccess_num(), this.getInsCd() );

				System.out.println( ">" + wholeCnt + "/" + totalCnt + " (" + scientificName + ") " );
				if( uid < 0 && unUid < 0 ) {
					int ret = this.processCommon( vo, scientificName );

					mappedCnt += ret;
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