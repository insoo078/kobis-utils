package junit.test.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.file.excel.obj.internal.DistPatentReferenceObj;
import org.kobic.kobis.file.excel.obj.internal.DistributionObj;
import org.kobic.kobis.file.excel.obj.internal.GpsObj;
import org.kobic.kobis.file.excel.obj.internal.PatentObj;
import org.kobic.kobis.file.excel.obj.internal.ReferenceObj;
import org.kobic.kobis.main.dao.KobisDAOService;
import org.kobic.kobis.main.vo.D1ObservationVO;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class KobisDAOServiceTest {
	KobisDAOService kobisService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.kobisService = new KobisDAOService( MyBatisConnectionFactory.getSqlSessionFactory() );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			XObservationSheetObj obj = new XObservationSheetObj();
			
			DistributionObj dist = new DistributionObj();
			dist.setDistUrl("http://www.naver.com");
			dist.setDistYn("Y");
			PatentObj patent = new PatentObj();
			patent.setParentNo("DOC123");
			patent.setRegNo("REG123");
			ReferenceObj reference = new ReferenceObj();
			reference.setReference("REFERENCE NAR DB");
	
			DistPatentReferenceObj extra = new DistPatentReferenceObj();
			extra.setDist( dist );
			extra.setPatent( patent );
			extra.setRef( reference );
			
			GpsObj gps = new GpsObj();
			gps.setLatitude("W232,2312,1232,232");
			gps.setLongitude("L32,23343,3243,234");
			
			obj.setAccess_num("12345");
			obj.setExtra(extra);
			obj.setGps(gps);
			
			D1ObservationVO dv = new D1ObservationVO( obj );
			
			this.kobisService.getE1Distribution( dv );
		}catch(Exception e) {
			e.printStackTrace();
			fail("Fail");
		}
	}

}
