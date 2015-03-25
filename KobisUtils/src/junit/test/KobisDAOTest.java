package junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kobic.kobis.main.dao.KobisDAO;
import org.kobic.kobis.main.dao.KobisDAOService;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class KobisDAOTest {
	private KobisDAO dao;

	@Before
	public void setUp() throws Exception {
		this.dao = new KobisDAOService( MyBatisConnectionFactory.getSqlSessionFactory() );
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
