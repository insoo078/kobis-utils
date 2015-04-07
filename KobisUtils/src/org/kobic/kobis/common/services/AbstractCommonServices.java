package org.kobic.kobis.common.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.main.dao.KobisDAOService;
import org.kobic.kobis.unmapped.dao.UnmappedDAOService;

public class AbstractCommonServices {
	private String insCd;
	private SqlSessionFactory sessionFactory;
	
	private KobisDAOService kobisService;
	private UnmappedDAOService unmapService;
	
	public AbstractCommonServices(String insCd, SqlSessionFactory sessionFactory) {
		this.insCd = insCd;
		this.sessionFactory = sessionFactory;
		
		this.kobisService = new KobisDAOService( this.getSessionFactory() );
		this.unmapService = new UnmappedDAOService( this.getSessionFactory() );
	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String getInsCd() {
		return insCd;
	}

	public void setInsCd(String insCd) {
		this.insCd = insCd;
	}

	public KobisDAOService getKobisService() {
		return kobisService;
	}

	public UnmappedDAOService getUnmapService() {
		return unmapService;
	}
}
