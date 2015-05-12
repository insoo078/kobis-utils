package org.kobic.kobis.unmap2map.services;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.services.AbstractCommonServices;
import org.kobic.kobis.knnrrc.vo.KnnrrcVO;
import org.kobic.kobis.main.dao.KobisDAOService;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.unmap2map.dao.Unmap2MapDAOService;
import org.kobic.kobis.unmapped.dao.UnmappedDAOService;

public class Unmap2MapServices{
	private static Logger logger = Logger.getLogger(Unmap2MapServices.class);
	
	private SqlSessionFactory sessionFactory;

	private Unmap2MapDAOService unmap2MapService;
	
	public Unmap2MapServices(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

		this.unmap2MapService = new Unmap2MapDAOService( this.sessionFactory );
	}
	
	public void read() throws NoSuchMethodException, SecurityException, Exception {
		// TODO Auto-generated method stub
		int totalCnt = this.unmap2MapService.getUnmappedCommonTotalCount();
		System.out.println("total count : "+ totalCnt );

		int paging = 1000;
		int pagingIndex = 0;
		
		double noOfPage = Math.ceil( (double)totalCnt / paging );

		for(int i=0; i<=noOfPage; i++) {
			pagingIndex = paging * i;
			
			List<D1CommonVO> voList = this.unmap2MapService.getUnmappedCommon(pagingIndex, pagingIndex);
			
			for(D1CommonVO vo : voList) {
				String scientificName = vo.getGenus() + " " + vo.getSpecies();
			}
		}
	}
}