package org.kobic.kobis.rule.interpreter.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kobic.kobis.rule.interpreter.LexicalInterpreter;

public class LexicalInterpreterTest {

	@Test
	public void test() {
		String rule = "IF ${FIELD} EQUAL ${VAL} THEN REPLACE ${FIELD} ${BEFORE} ${AFTER} FI";
		
		LexicalInterpreter liptr = new LexicalInterpreter();
		liptr.test( rule );
	}
}