package org.kobic.kobis.rule.interpreter.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kobic.kobis.mybatis.dao.RuleDAO;
import org.kobic.kobis.rule.interpreter.LexicalInterpreter;

public class LexicalInterpreterTest {
	private RuleDAO dao;
	
	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		String rule = "IF ${FIELD} EQ ${VAL} AND ${FIELD} NE ${VAL2} THEN REPLACE(${FIELD}, ${BEFORE}, ${AFTER}) FI";
		
		LexicalInterpreter liptr = new LexicalInterpreter();
		liptr.parsing( rule );
	}
}