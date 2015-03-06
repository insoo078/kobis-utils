package org.kobic.kobis.rule.interpreter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.formula.functions.Function;
import org.kobic.kobis.mybatis.db.vo.RuleQueryVO;
import org.kobic.kobis.rule.obj.RuleParamObj;

public class LexicalInterpreter {
	private static LexicalInterpreter interpreter;

	private Stack<String> stack;

	public LexicalInterpreter() {
		this.stack = new Stack<String>();
	}
	
	public static LexicalInterpreter getInstance() {
		if( interpreter == null )	return new LexicalInterpreter();
		
		return interpreter;
	}

	public boolean interpret( RuleQueryVO vo, RuleParamObj param ) throws NoSuchMethodException, SecurityException {
		String rule = vo.getRule();

		this.parsing( rule );
		
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
		}else if( operator == KeywordDictionary.LE ) {
			if( operand1 instanceof Number && operand2 instanceof Number ) {
				if( (double)operand1  <= (double)operand2 )		return true;
				else											return false;
			}else {
				System.err.println("Syntax error : ");
				System.exit(1);
			}
		}else if( operator == KeywordDictionary.GE ) {
			if( operand1 instanceof Number && operand2 instanceof Number ) {
				if( (double)operand1  >= (double)operand2 )		return true;
				else											return true;
			}else {
				System.err.println("Syntax error : ");
				System.exit(1);
			}
		}
		return false;
	}
	
	@SuppressWarnings("static-access")
	private boolean processIfCondition(String ifStatement) {
		Pattern p1 = Pattern.compile( "(.+)THEN" );
		Matcher m1 = p1.matcher( ifStatement );
		 
		if( m1.find() ) {
			for(int i=0; i<m1.groupCount(); i++) {
				
			}

			String line = m1.group(1);
			
			StringTokenizer st = new StringTokenizer( line.trim() );

			Object operand1 = null;
			Object operand2 = null;
			int operator = -1;
			int conjunction = -1;
			Boolean condition = null;
			while( st.hasMoreElements() ) {
				String word = (String) st.nextElement();

				if( KeywordDictionary.getInstance().reservedWords.contains(word) ) {
					if( word.equals("AND") )		conjunction = KeywordDictionary.AND;
					else if( word.equals("OR") )	conjunction = KeywordDictionary.OR;
				}else if( KeywordDictionary.getInstance().operators.contains(word) ){
					if( word.equals("EQ") )			operator = KeywordDictionary.EQUAL;
					else if( word.equals("LT") )	operator = KeywordDictionary.LT;
					else if( word.equals("GT") )	operator = KeywordDictionary.GT;
					else if( word.equals("LE") )	operator = KeywordDictionary.LE;
					else if( word.equals("GE") )	operator = KeywordDictionary.GE;
				}else {
					if( operand1 == null )	operand1 = word;
					else					operand2 = word;
					
					if( operand1 != null && operand2 != null ) {
						condition = this.join( operand1, operand2, condition, operator, conjunction );
					}
				}
			}
			return condition;
		}
		return false;
	}

	public void processIfStatement(String ifStatement) throws NoSuchMethodException, SecurityException {
		if( !this.processIfCondition(ifStatement) ) {
			String pattern = "THEN(.+)";
			Pattern p = Pattern.compile( pattern );
			Matcher m = p.matcher( ifStatement );
			
			if( m.find() ) {
				String ifContent = m.group(1).trim();
			}
		}
	}
	
	public void parsing( String rule ) throws NoSuchMethodException, SecurityException {
		String pattern = "^IF(.+)FI";

		Pattern p = Pattern.compile( pattern );
		Matcher m = p.matcher( rule.replace("\n", "") );
		 
		if( m.find() ) {
			String ifStatement = m.group(1);
			this.processIfStatement( ifStatement );
		}
	}
}
