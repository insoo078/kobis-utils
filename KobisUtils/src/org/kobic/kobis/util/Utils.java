package org.kobic.kobis.util;

public class Utils {
	public static String emptyToNull(String value) {
		if( value == null )				return null;
		if( value.trim().isEmpty() )	return null;
		
		return value.trim();
	}
}
