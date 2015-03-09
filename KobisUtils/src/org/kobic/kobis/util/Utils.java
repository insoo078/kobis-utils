package org.kobic.kobis.util;

import org.kobic.kobis.rule.interpreter.LexicalInterpreter;

public class Utils {
	public static String emptyToNull(String value) {
		if( value == null )				return null;
		if( value.trim().isEmpty() )	return null;
		
		return value.trim();
	}
	
	public static String nullToEmpty(Object value) {
		if( value == null )				return "";
		
		return value.toString();
	}
	
	public static String wrap(String value, String quot) {
		return quot + value + quot;
	}
	
	public static String removeQuot( String value, String quot ) {
		return value.replace( LexicalInterpreter.DBL_QUOTATION, "" );
	}
}
