package org.kobic.kobis.rule.antlr4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class Antrl4Test {

	@Test
	public void test() {
		String sentence = "if( value.equals(\"var.\") ){ System.out.println(value);}else if( value.equals(\"insu\") ){ System.out.prinltn(\"else\");}";

		RuleLexer lexer = new RuleLexer( new ANTLRInputStream( sentence ) );
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		RuleParser parser = new RuleParser( tokens );
		
		RuleBaseListener listener = new RuleBaseListener();
		parser.addParseListener( listener );

		parser.ifThenElseStatement();
//		RuleBaseVisitor visitor = new RuleBaseVisitor();
//		System.out.println( visitor.visitIfThenElseStatement( parser.ifThenElseStatement() ) );
//		System.out.println( parser.ifThenElseStatement().getText() );
		
//		IfThenElseStatementContext context = parser.ifThenElseStatement();
//		for(ParseTree tree:context.children ){
//			System.out.println( tree.getText() );
//			if( tree.getChildCount() > 0 ) {
//				for(int i=0; i<tree.getChildCount(); i++) {
//					System.out.println( "         " + tree.getChild(i).getText() );
//				}
//			}
//		}

//		IfThenElseStatementNoShortIfContext context = parser.ifThenElseStatementNoShortIf();
//		
//		ExpressionContext ec = context.expression();
//		for(StatementNoShortIfContext snsic:context.statementNoShortIf()) {
//			System.out.println( snsic.getText() );
//		}
////		StatementContext sc = context.statement();
//		
////		StatementNoShortIfContext snsic = context.statementNoShortIf();
//		
////		System.out.println( ec.getText() );
//////		System.out.println( sc.getText() );
//////		System.out.println( snsic.getText() );
////		
////		System.out.println( context.getText() );
	}
}
