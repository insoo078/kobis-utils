package org.kobic.kobis.rule.interpreter;

import org.kobic.kobis.mybatis.db.vo.RuleVO;
import org.kobic.kobis.rule.obj.RuleParamObj;

public class LexicalInterpreter {
	public static boolean interpret( RuleVO vo, RuleParamObj param ) {
		String rule = vo.getRule();
		
		return true;
	}
}
