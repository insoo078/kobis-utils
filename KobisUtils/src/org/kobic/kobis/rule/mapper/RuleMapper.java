package org.kobic.kobis.rule.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.rule.vo.RuleQueryVO;

public interface RuleMapper {
	public List<RuleQueryVO> getRulesByInsId( Map<String, String> map );
}
