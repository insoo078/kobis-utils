package org.kobic.kobis.rule.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KeywordDictionary {
	private static KeywordDictionary dictionary;
	
	public static final String DBL_QUOTATION = "\"";
	public static final String SNGL_QUOTATION = "\'";
	
	public static final int AND = 0;
	public static final int OR = 1;
	
	public static final int EQUAL			= 0x01;
	public static final int NOT_EQUAL		= 0x02;
	public static final int LESS_THAN		= 0x02;
	public static final int GRATER_THAN		= 0x03;
	public static final int LESS_OR_EQUAL	= 0x04;
	public static final int GRATER_OR_EQUAL	= 0x05;
	
	public static int NOTHING = -1;

	public Map<String, Integer> conjunctions = new LinkedHashMap<String, Integer>();
	{
		conjunctions.put( "AND", KeywordDictionary.AND );
		conjunctions.put( "OR", KeywordDictionary.OR );
//		conjunctions.addAll( Arrays<Keyword>.asList( new Keyword[]{ new Keyword("AND", KeywordDictionary.AND), new Keyword("OR", KeywordDictionary.OR)} ) );
	}
	
	public Map<String, Integer> operators = new LinkedHashMap<String, Integer>();
	{
		operators.put( "EQ", KeywordDictionary.EQUAL );
		operators.put( "NE", KeywordDictionary.NOT_EQUAL );
		operators.put( "LT", KeywordDictionary.LESS_THAN );
		operators.put( "GT", KeywordDictionary.GRATER_THAN );
		operators.put( "LE", KeywordDictionary.LESS_OR_EQUAL );
		operators.put( "GE", KeywordDictionary.GRATER_OR_EQUAL );
//		operators.addAll( Arrays.asList( new String[]{"EQ", "NE", "LT", "GT", "LE", "GE"} ) );
	}
	
	public List<String> functions = new ArrayList<String>();
	{
		functions.addAll( Arrays.asList( new String[]{"REPLACE", "TRIM", "SUBSTR"} ) );
	}
	
	public static String getOperatorString() {
		String operatorStr = "";
		for(Iterator<String> iter = KeywordDictionary.getInstance().operators.keySet().iterator(); iter.hasNext();) {
			String key = iter.next();
			if( iter.hasNext() )	operatorStr += key + "|";
			else					operatorStr += key;
		}
		return operatorStr;
	}

	public static KeywordDictionary getInstance() {
		if( dictionary == null )	dictionary = new KeywordDictionary();
		
		return dictionary;
	}
}