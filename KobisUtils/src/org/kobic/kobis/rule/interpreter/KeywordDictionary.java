package org.kobic.kobis.rule.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeywordDictionary {
	private static KeywordDictionary dictionary;
	
	public static int AND = 0;
	public static int OR = 1;
	
	public static int EQUAL = 01;
	public static int LT = 02;
	public static int GT = 03;
	public static int LE = 04;
	public static int GE = 05;
	
	public static int NOTHING = -1;

	public static List<String> reservedWords = new ArrayList<String>();
	{
		reservedWords.addAll( Arrays.asList( new String[]{"IF", "FI", "THEN", "ELSE", "ELSEIF", "AND", "OR"} ) );
	}
	
	public static List<String> operators = new ArrayList<String>();
	{
		operators.addAll( Arrays.asList( new String[]{"EQ", "NE", "LT", "GT", "LE", "GE"} ) );
	}
	
	public static List<String> functions = new ArrayList<String>();
	{
		functions.addAll( Arrays.asList( new String[]{"REPLACE"} ) );
	}
	
	public static KeywordDictionary getInstance() {
		if( dictionary == null )	dictionary = new KeywordDictionary();
		
		return dictionary;
	}
}