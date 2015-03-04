package org.kobic.kobis.rule.interpreter;

import java.util.Stack;
import java.util.StringTokenizer;

import org.kobic.kobis.mybatis.db.vo.RuleQueryVO;
import org.kobic.kobis.rule.obj.RuleParamObj;

public class LexicalInterpreter {
	private Stack<String> stack;
	public LexicalInterpreter() {
		this.stack = new Stack<String>();
	}

	public static boolean interpret( RuleQueryVO vo, RuleParamObj param ) {
//		String rule = vo.getRule();

		return true;
	}
	
	public void processIfStatement() {
		for(int i=0; i<this.stack.size(); i++) {
			String currentWord = this.stack.pop();
			System.out.println( currentWord );
			if( KeywordDictionary.reservedWords.contains( currentWord ) ) {
				System.out.println( currentWord );
			}
		}
	}

	public void test(String rule) {
		StringTokenizer st = new StringTokenizer( rule );

		boolean pushToStack = false;
		while (st.hasMoreElements()) {
			String word = (String) st.nextElement();
			if( word.toUpperCase().equals("IF") ) 			{
				pushToStack = true;
				continue;
			}else if( word.toUpperCase().equals("FI") )		pushToStack = false;

			if( pushToStack )	{
				this.stack.push( word );
				System.out.println( word );
			}else {
//				this.processIfStatement();
			}
		}
	}
}
