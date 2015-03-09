package org.kobic.kobis.util;

import org.kobic.kobis.rule.interpreter.KeywordDictionary;

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
		return value.replace( KeywordDictionary.DBL_QUOTATION, "" );
	}
	
	public static boolean isCharacterSequence( String value, String quot ) {
		return value.trim().matches("^\"(\\S|\\s)*\"$");
	}
	
	public static boolean isNumeric( String value ) {
		return value.matches("-?\\d+(\\.\\d+)?");
	}
}
