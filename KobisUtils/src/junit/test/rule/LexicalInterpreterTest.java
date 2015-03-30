package junit.test.rule;

import org.junit.Test;
import org.kobic.kobis.main.vo.D1DnaRnaProteinDerivativesVO;
import org.kobic.kobis.rule.Rule;
import org.kobic.kobis.rule.dao.RuleDAO;

public class LexicalInterpreterTest {
	private RuleDAO dao;
	
	@Test
	public void test() throws Exception {
		D1DnaRnaProteinDerivativesVO obj = new D1DnaRnaProteinDerivativesVO();
		obj.setAccess_num("12345");
		
		Rule rule = new Rule( "INS00002" );
		rule.rule( obj );
	}
}