package org.kobic.kobis.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.kobic.kobis.rule.interpreter.KeywordDictionary;

public class Utils {
	public static String emptyToNull(String value) {
		if( value == null )				return null;
		if( value.trim().isEmpty() )	return null;
		
		return value.trim();
	}
	
	public static String getTimeStamp( long e, long s ) {
		return ((double)(e - s) / 1000) + "sec";
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
	
	public static boolean isBoolean(String bool) {
		if( bool.toLowerCase().equals("true") || bool.toLowerCase().equals("false") )	return true;
		return false;
	}
	
	public static boolean isNumeric( String value ) {
		return value.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static String lpad( String value, int size ) {
		return org.apache.commons.lang.StringUtils.leftPad( value, size, '0' );
	}

	public static Object getValueByField( Object obj, String fieldName ) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BeanInfo info = Introspector.getBeanInfo(obj.getClass(), Object.class);
	    PropertyDescriptor[] props = info.getPropertyDescriptors();

	    Object value = null;
	    for (PropertyDescriptor pd : props) {
	        String name = pd.getName();
	        if( !name.equals(fieldName) )	continue;

	        Method getter = pd.getReadMethod();
//	        Class<?> type = pd.getPropertyType();

	        value = getter.invoke( obj ).toString();
	        break;
	    }
	    return value;
	}
}
