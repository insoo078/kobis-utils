package org.kobic.kobis.rule;

import org.kobic.kobis.mybatis.dao.RuleDAO;
import org.kobic.kobis.rule.obj.CodeMappingRuleObj;
import org.kobic.kobis.rule.obj.RuleParamObj;

/************************************************
 * 추출물은행 적용 Rule
 * @author lion
 *
 */
public class PlantExtractBankRule extends Rule{
	public PlantExtractBankRule(String insCd) {
		super(insCd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean rule( RuleParamObj obj ) {
		RuleDAO dao = this.getDAO();

		if( obj instanceof CodeMappingRuleObj ) {
			
		}
		// TODO Auto-generated method stub
		return false;
	}
}
