package org.kobic.kobis.rule.interpreter;

import java.util.List;

public class Functions {
	public static String REPLACE(List<String> list) {
		return list.get(0).replace(list.get(1), list.get(2));
	}
}