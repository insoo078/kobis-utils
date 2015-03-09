package org.kobic.kobis.rule.interpreter;

import org.kobic.kobis.util.Utils;

public class Functions {
	public static String REPLACE(String[] list)  throws Exception{ 
		String ret = Utils.removeQuot(list[0], LexicalInterpreter.DBL_QUOTATION ).trim().replace(
					Utils.removeQuot(list[1].trim(), LexicalInterpreter.DBL_QUOTATION )
					,
					Utils.removeQuot(list[2].trim(), LexicalInterpreter.DBL_QUOTATION)
				);
		
		return ret;
	}

	public static String SUBSTR(String[] list) throws Exception{
		return Utils.removeQuot(list[0].trim(), LexicalInterpreter.DBL_QUOTATION).substring( 
				Integer.valueOf( Utils.removeQuot(list[1].trim(), LexicalInterpreter.DBL_QUOTATION )  )
				, 
				Integer.valueOf(Utils.removeQuot(list[2].trim(), LexicalInterpreter.DBL_QUOTATION ))
		);
	}

	public static String TRIM(String... list)  throws Exception{
		String ret  = Utils.removeQuot( list[0].trim(), LexicalInterpreter.DBL_QUOTATION ).trim();
		return ret;
	}
}