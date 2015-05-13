package org.kobic.kobis.unmap2map.services;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.common.services.AbstractCommonServices;
import org.kobic.kobis.file.excel.obj.XCellStrainSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.taxon.proc.MultipleClassificationProc;
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
				String accessoinNum = vo.getAccess_num();
				String insCd = vo.getIns_cd();

				int uid = this.getKobisService().getUid(accessoinNum, insCd);

				if( uid == -1 ) {
					String scientificName = vo.getScientificName();

					MultipleClassificationProc classifyObj = new MultipleClassificationProc( this.getSessionFactory() );
	
					String errorCode = classifyObj.validate( scientificName );
					
					if( errorCode.equals( MultipleClassificationProc.FINE_MAPPING ) ) {
						XCellStrainSheetObj obj = this.unmap2MapService.getUnmappedCellStrain( vo.getUid() );							
					}
				}
			}
		}
	}
}