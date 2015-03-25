package org.kobic.kobis.rule.dao;

import java.util.List;
import org.kobic.kobis.rule.vo.RuleQueryVO;

public interface RuleDAO {
    public List<RuleQueryVO> getRulesByInsId( String ins_id, String className );
}
