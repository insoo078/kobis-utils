package org.kobic.kobis.rule.interpreter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import org.apache.poi.ss.formula.functions.Function;
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

	public boolean join(Object operand1, Object operand2, Boolean condition, int operator, int conjunction) {
		if( conjunction == KeywordDictionary.NOTHING )	condition = this.operate(operand1, operand2, operator);
		else if( conjunction == KeywordDictionary.AND )	condition &= this.operate(operand1, operand2, operator);
		else if( conjunction == KeywordDictionary.OR )	condition |= this.operate(operand1, operand2, operator);
		
		return condition;
	}

	public boolean operate(Object operand1, Object operand2, int operator ) {
		if( operator == KeywordDictionary.EQUAL ) {
			if( operand1 instanceof Number && operand2 instanceof Number ) {
				if( operand1 == operand2 )		return true;
				else							return false;
			}else {
				if( operand1.equals(operand2) ) return true;
				else							return false;
			}
		}else if( operator == KeywordDictionary.LT ) {
			if( operand1 instanceof Number && operand2 instanceof Number ) {
				if( (double)operand1  < (double)operand2 )		return true;
				else											return false;
			}else {
				System.err.println("Syntax error : ");
				System.exit(1);
			}
		}else if( operator == KeywordDictionary.GT ) {
			if( operand1 instanceof Number && operand2 instanceof Number ) {
				if( (double)operand1  > (double)operand2 )		return true;
				else											return true;
			}else {
				System.err.println("Syntax error : ");
				System.exit(1);
			}
		}
		return false;
	}
	
	@SuppressWarnings("static-access")
	public void processIfStatement() throws NoSuchMethodException, SecurityException {
		Map<String, Object> map = new HashMap<String, Object>(); 

		Boolean condition = null;
		int conjunction = KeywordDictionary.NOTHING;
		int operator = KeywordDictionary.NOTHING;

		Object operand1 = null;
		Object operand2 = null;

		Collections.reverse( this.stack );
		int length = this.stack.size();
		for(int i=0; i<length; i++) {
			String currentWord = this.stack.pop();

//			1==2 AND 2==2 OR 3==4
			boolean isContainInReservedWords	= KeywordDictionary.getInstance().reservedWords.contains(currentWord);
			boolean isContainInFunctions		= KeywordDictionary.getInstance().functions.contains(currentWord);
			boolean isContainOperators			= KeywordDictionary.getInstance().operators.contains(currentWord);
			if( isContainInReservedWords ) {
				if( currentWord.equals("IF") ) {
				}else if( currentWord.equals("AND") )	conjunction = KeywordDictionary.AND;
				else if( currentWord.equals("OR") )		conjunction = KeywordDictionary.OR;
				else if( currentWord.equals("THEN") ){

				}else if( currentWord.equals("FI") ) {
					
				}
			}else if( isContainOperators ){
				if( currentWord.equals("EQ") )		operator = KeywordDictionary.EQUAL;
				else if( currentWord.equals("LT") )	operator = KeywordDictionary.LT;
				else if( currentWord.equals("GT") )	operator = KeywordDictionary.GT;
			}else if( isContainInFunctions ) {
				java.lang.reflect.Method method = Functions.class.getMethod( currentWord, List.class );
			}else {
				if( operand1 == null )	operand1 = currentWord;
				else					operand2 = currentWord;
				
				if( operand1 != null && operand2 != null && operator != KeywordDictionary.NOTHING ) {
					condition = this.join( operand1, operand2, condition, operator, conjunction );

					operand1 = null;
					operand2 = null;
				}
			}
		}
	}

	public void test(String rule) throws NoSuchMethodException, SecurityException {
		StringTokenizer st = new StringTokenizer( rule );

		while (st.hasMoreElements()) {
			String word = (String) st.nextElement();

			if( word.toUpperCase().equals("IF") ) {
				this.stack.push( word );
			}else if( word.toUpperCase().equals("FI") ){
				this.stack.push( word );
				this.processIfStatement();
			}else {
				this.stack.push( word );
			}

		}
	}
}
