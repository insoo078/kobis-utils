package org.kobic.kobis.unmapped.mapper;

import java.util.Map;

import org.kobic.kobis.main.vo.D1CommonVO;

public interface UnmappedMapper {
	public int insertUnmappedD1Common( D1CommonVO commonSheet );
	public String getAccessionNum( Map<String, String> map );
}
