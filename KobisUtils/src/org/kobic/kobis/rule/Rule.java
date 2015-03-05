package org.kobic.kobis.rule;

import java.util.Iterator;
import java.util.List;

import org.kobic.kobis.mybatis.dao.RuleDAO;
import org.kobic.kobis.mybatis.db.vo.RuleQueryVO;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;
import org.kobic.kobis.rule.interpreter.LexicalInterpreter;
import org.kobic.kobis.rule.obj.RuleParamObj;

public class Rule {
	private String insCd;
	private RuleDAO dao;

	public Rule( String insCd ) {
		this.insCd = insCd;

		this.dao = new RuleDAO( MyBatisConnectionFactory.getSqlSessionFactory() );
	}

	public RuleDAO getDAO() {
		return this.dao;
	}

	public boolean rule( RuleParamObj obj ) throws NoSuchMethodException, SecurityException {
		List<RuleQueryVO> ruleList = this.dao.getRulesByInsId( this.insCd );
		for(Iterator<RuleQueryVO> iter = ruleList.iterator(); iter.hasNext();) {
			LexicalInterpreter.getInstance().interpret( iter.next(), obj );
		}

		return true;
	}
}