package org.kobic.kobis.rule;

import org.kobic.kobis.mybatis.dao.RuleDAO;
import org.kobic.kobis.rule.obj.CodeMappingRuleObj;
import org.kobic.kobis.rule.obj.RuleObj;

/************************************************
 * 추출물은행 적용 Rule
 * @author lion
 *
 */
public class PlantExtractBankRule extends Rule{
	@Override
	public boolean rule( RuleObj obj ) {
		RuleDAO dao = this.getDAO();

		if( obj instanceof CodeMappingRuleObj ) {
			
		}
		// TODO Auto-generated method stub
		return false;
	}
}
