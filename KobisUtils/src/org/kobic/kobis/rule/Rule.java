package org.kobic.kobis.rule;

import org.kobic.kobis.mybatis.dao.RuleDAO;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;
import org.kobic.kobis.rule.obj.RuleObj;

public abstract class Rule {
	private RuleDAO dao;

	public Rule() {
		this.dao = new RuleDAO( MyBatisConnectionFactory.getSqlSessionFactory() );
	}

	public RuleDAO getDAO() {
		return this.dao;
	}

	public abstract boolean rule(RuleObj obj);
}
