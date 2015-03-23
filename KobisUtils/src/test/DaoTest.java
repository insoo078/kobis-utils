package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kobic.kobis.mybatis.dao.KobisDAO;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class DaoTest {
	private KobisDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.dao = new KobisDAO( MyBatisConnectionFactory.getSqlSessionFactory() );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
