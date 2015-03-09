package org.kobic.kobis.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
	
	public static Object getterValue(Object obj, String field) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Map<String, Object> map = new HashMap<String, Object>();
		BeanInfo info = Introspector.getBeanInfo(obj.getClass(), Object.class);
		PropertyDescriptor[] props = info.getPropertyDescriptors();

	    for (PropertyDescriptor pd : props) {
	    	String name = pd.getName();

	        Method getter = pd.getReadMethod();

	        map.put( name, getter.invoke( obj ) );
	    }
	    String ret = map.get( field );
	}
}
