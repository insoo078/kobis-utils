package org.kobic.kobis.main.mapper;

import java.util.Map;

import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;

public interface KobisMapper {
    public String getInstitutionId(String insCd);    
    public String getAccessionNum( Map<String, String> map );

    public int insertD1Common( D1CommonVO d1CommonVo );
    public int insertUnmappedD1Common( D1CommonVO commonSheet );
    public int insertMappedD1Common( D1CommonVO commonSheet );
    public int insertObservation( XObservationSheetObj observationSheet );
}
