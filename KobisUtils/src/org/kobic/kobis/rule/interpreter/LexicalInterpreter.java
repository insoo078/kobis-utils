package org.kobic.kobis.rule.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kobic.kobis.mybatis.db.vo.RuleQueryVO;
import org.kobic.kobis.rule.obj.RuleParamObj;
import org.kobic.kobis.util.Utils;

public class LexicalInterpreter {
	public static final String DBL_QUOTATION = "\"";
	public static final String SNGL_QUOTATION = "\'";

	private static LexicalInterpreter interpreter;
	
	public static LexicalInterpreter getInstance() {
		if( interpreter == null )	return new LexicalInterpreter();
		
		return interpreter;
	}

	public boolean interpret( RuleQueryVO vo, RuleParamObj param ) throws NoSuchMethodException, SecurityException {
		vo.setRule_condition( this.bindingParams(vo.getRule_condition(), param) );
		vo.setRule( this.bindingParams(vo.getRule(), param) );

		if( this.isTrueConditionStatement( vo.getRule_condition() ) ) {
			;
		}
		return true;
	}
	
	private boolean isTrueConditionStatement( String condition ) {
//		String pattern = "([\"|a-zA-Z0-9])\\s+[EQ|NE|GT|LT|GE|LE]\\s+";
		String pattern = "([EQ|NE|GT|LT|GE|LE])";
		Pattern p = Pattern.compile( pattern );
		Matcher m = p.matcher( condition );
		
		System.out.println( condition );
		while( m.find() ) {
			System.out.println( m.group() );
		}

		return false;
	}

	private void parsing( RuleQueryVO query ) {
		
	}
	
	private String[] functionParameters(String str) {
		String[] div = str.split(",");
		
		return div;
	}

	private String functionTranslate( String statement ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String pattern = "([a-zA-Z0-9]+)\\(([\"|\\s|a-zA-Z0-9|\\,]*)\\)";
		Pattern p = Pattern.compile( pattern );
		Matcher m = p.matcher( statement );

		while( m.find() ) {
			String methodName= m.group(1);
			String[] params = this.functionParameters( m.group(2) );

			Method method = Functions.class.getMethod( m.group(1), new Class[]{String[].class} );
			Object result = method.invoke( methodName, new Object[]{params} );
			
			if( result instanceof String )	result = LexicalInterpreter.DBL_QUOTATION + result.toString() + LexicalInterpreter.DBL_QUOTATION ;
			statement = statement.replace( m.group(), result.toString() );
		}

		return statement;
	}
	
	private String variableTranslate(String statement, RuleParamObj param) {
		String pattern = "\\$\\{\\s*[a-z|A-Z|\\_|0-9]+\\s*\\}";
		Pattern p = Pattern.compile( pattern );
		Matcher m = p.matcher( statement );

		String condition = statement;
		while( m.find() ) {
			String oldStr = m.group();
			String newStr = Utils.wrap( Utils.nullToEmpty( param.getParam(m.group()) ), LexicalInterpreter.DBL_QUOTATION );
			
			condition = condition.replace( oldStr, newStr );
		}
		condition = condition.replace( LexicalInterpreter.SNGL_QUOTATION, LexicalInterpreter.DBL_QUOTATION );
		
		return condition;
	}

	private String bindingParams( String statement, RuleParamObj param ) {
		String variableTranslatedStatement = this.variableTranslate( statement, param );
		String fulctionTranslatedStatement;
		try {
			fulctionTranslatedStatement = this.functionTranslate(variableTranslatedStatement);

			return fulctionTranslatedStatement;
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
