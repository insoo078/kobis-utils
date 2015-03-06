package org.kobic.kobis.rule.interpreter;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Token> tokens;
	
	public Tokenizer() {
		this.tokenInfos = new LinkedList<TokenInfo>();
		this.tokens = new LinkedList<Token>();
	}
	
	public class Token {
		public final int token;
		public final String sequence;
		
		public Token(int token, String sequence) {
			super();
			this.token = token;
			this.sequence = sequence;
		}
	}

	private class TokenInfo{
		public final Pattern regex;
		public final int token;
		
		public TokenInfo(Pattern regex, int token) {
			super();
			this.regex = regex;
			this.token = token;
		}
	}
	
	public void add(String regex, int token) {
		this.tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
	}
	
	public void tokenize(String str) {
		String s = str.trim();
	    this.tokens.clear();

		while( !s.equals("") ) {
			boolean match = false;
			
			for(TokenInfo info : tokenInfos) {
				Matcher m = info.regex.matcher(s);
				if( m.find() ) {
					match = true;
					
					String tok = m.group().trim();
					s = m.replaceFirst("").trim();
					this.tokens.add( new Token(info.token, tok) );
					break;
				}
			}
			if (!match) throw new RuntimeException("Unexpected character in input: "+s);
		}
	}
	
	public LinkedList<Token> getTokens() {
		return tokens;
	}

	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer();
	    tokenizer.add("sin|cos|exp|ln|sqrt", 1);
	    tokenizer.add("\\(", 2);
	    tokenizer.add("\\)", 3);
	    tokenizer.add("\\+|-", 4);
	    tokenizer.add("\\*|/", 5);
	    tokenizer.add("[0-9]+",6);
	    tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 7);
		
		try {
			tokenizer.tokenize(" sin(x) * (1 + var_12) ");

			for (Tokenizer.Token tok : tokenizer.getTokens()) {
				System.out.println("" + tok.token + " " + tok.sequence);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
