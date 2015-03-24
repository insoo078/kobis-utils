package org.kobic.kobis.main.mapper;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.file.excel.obj.XObservationSheetObj;
import org.kobic.kobis.main.vo.D1CommonVO;
import org.kobic.kobis.taxon.vo.NameWithTaxonIdVO;

public interface KobisMapper {
    public String getInstitutionId(String insCd);    
    public String getAccessionNum(String accession_num);

    public List<NameWithTaxonIdVO> getScientificNameFromNcbiTaxonomy(String scientfic_name);
    public List<NameWithTaxonIdVO> getScientificNameFromGbifTaxonomy(String scientfic_name);
    public List<NameWithTaxonIdVO> getScientificNameFromItisTaxonomy(String scientfic_name);

    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomy(String scientfic_name);
    public int insertCommonSheet( D1CommonVO d1CommonVo, Map<String, String> crossTaxonMap );
    public int insertUnmappedD1Common( D1CommonVO commonSheet );
    public int insertMappedD1Common( D1CommonVO commonSheet );
    public int insertObservation( XObservationSheetObj observationSheet );
}
