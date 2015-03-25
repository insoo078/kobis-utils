package org.kobic.kobis.main.dao;

import java.util.Map;

import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;

/**
 * KOBIS를 위해 외부기관으로 받은 데이터를 데이터베이스 반영하거나 조회하는 쿼리를 관장하는 Data Access Object
 * 
 * @author insoo078
 *
 */
public interface KobisDAO{
    public String getInstitutionId(String insCd);    
    public String getAccessionNum(String accession_num);

    public int insertCommonSheet( D1CommonVO d1CommonVo, Map<String, String> crossTaxonMap );
    public int insertObservation( XObservationSheetObj observationSheet );

//  public int insertMappedD1Common( D1CommonVO commonSheet );
}
