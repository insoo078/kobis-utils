package org.kobic.kobis.kbr.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.bris.dao.BrisDAOService;
import org.kobic.kobis.common.services.AbstractCommonServices;
import org.kobic.kobis.kbr.dao.KbrDAOService;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.util.Utils;

public class KbrServices  extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(KbrServices.class);
	
	private KbrDAOService kbrService;
	
	public KbrServices(String insCd, SqlSessionFactory sessionFactory) {
		super(insCd, sessionFactory);
		this.kbrService = new KbrDAOService( sessionFactory );
	}

	public void read() throws NoSuchMethodException, SecurityException, Exception {		// TODO Auto-generated method stub
		int totalCnt = this.kbrService.getTotalCount();
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

			List<D1CommonVO> voList = this.kbrService.getCommon( pagingIndex, paging );

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

	// Synonym 처리
	public void read3() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.kbrService.getTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		int wholeCnt = 0;
		int mappedCnt = 0;

		List<D1CommonVO> mapList = new ArrayList<D1CommonVO>();
		
		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;

			List<D1CommonVO> voList = this.kbrService.getCommon( pagingIndex, paging );

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
