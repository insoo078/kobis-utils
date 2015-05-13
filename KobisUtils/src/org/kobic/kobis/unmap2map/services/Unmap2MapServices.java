package org.kobic.kobis.unmap2map.services;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.services.AbstractCommonServices;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.unmap2map.dao.Unmap2MapDAOService;

public class Unmap2MapServices extends AbstractCommonServices{
	private static Logger logger = Logger.getLogger(Unmap2MapServices.class);

	private Unmap2MapDAOService unmap2MapService;
	
	public Unmap2MapServices(SqlSessionFactory sessionFactory) {
		super(null, sessionFactory);

		this.unmap2MapService = new Unmap2MapDAOService( this.getSessionFactory() );
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
			
			List<D1CommonVO> voList = this.unmap2MapService.getUnmappedCommon( pagingIndex, pagingIndex );
			
			for( D1CommonVO vo : voList ) {
				int uid = this.getKobisService().getUid( vo.getAccession_no(), vo.getIns_cd() );
				int unUid = this.getUnmapService().getUid( vo.getAccession_no(), vo.getIns_cd() );
			}
		}
	}
}