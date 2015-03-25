package org.kobic.kobis.taxon.dao;

import java.util.List;
import java.util.Map;

import org.kobic.kobis.taxon.vo.NameWithTaxonIdVO;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;

public interface TaxonDAO{
    public List<PhylogeneticTreeVO> getPhylogeneticTreeByGenus( String genus);
    public List<PhylogeneticTreeVO> getPhylogeneticTree( Map<String, String> map );
    public String getInstitutionId(String insCd);
    public List<NameWithTaxonIdVO> getScientificNameFromNcbiTaxonomy(String scientfic_name);
    public List<NameWithTaxonIdVO> getScientificNameFromGbifTaxonomy(String scientfic_name);
    public List<NameWithTaxonIdVO> getScientificNameFromItisTaxonomy(String scientfic_name);
    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomy(String scientfic_name);
    public String getT1ClassificationSystemTable(Map<String, String> map);
    public int insertT1ClassificationSystemTable(Map<String, String> map);
}
