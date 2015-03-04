package org.kobic.kobis.rule.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeywordDictionary {
	public static List<String> reservedWords = new ArrayList<String>();
	{
		reservedWords.addAll( Arrays.asList( new String[]{"IF", "FI", "THEN", "ELSE", "ELSEIF", "AND", "OR"} ) );
	}
	
	public static List<String> operators = new ArrayList<String>();
	{
		operators.addAll( Arrays.asList( new String[]{"EQUAL"} ) );
	}
	
	public static List<String> functions = new ArrayList<String>();
	{
		functions.addAll( Arrays.asList( new String[]{"REPLACE"} ) );
	}
}