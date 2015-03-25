package org.kobic.kobis.taxon.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.common.dao.CommonDAOService;
import org.kobic.kobis.taxon.vo.NameWithTaxonIdVO;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;

public class TaxonDAOService extends CommonDAOService implements TaxonDAO{
    public TaxonDAOService(SqlSessionFactory sqlSessionFactory){
        super(sqlSessionFactory);
    }
    
    @Override
    public List<PhylogeneticTreeVO> getPhylogeneticTreeByGenus( String genus) {
    	List<PhylogeneticTreeVO> list = null;
    	// autocommit is false
    	SqlSession session = this.getSessionFactory().openSession();

    	try {
    		 list = session.selectList("Taxon.getPhylogeneticTreeByGenus", genus );
    	}finally{
    		session.close();
    	}
    	return list;
    }

    @Override
    public String getInstitutionId(String insCd) {
    	SqlSession session = this.getSessionFactory().openSession();
    	String result = null;
    	try {
        	result = session.selectOne("Taxon.getInstitutionId", insCd);
	   	}finally{
	   		session.close();
	   	}

    	return Utils.emptyToNull( result );
    }

    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromNcbiTaxonomy(String scientfic_name) {
    	SqlSession session = this.getSessionFactory().openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromNcbiTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   		

    	return result;
    }
    
    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromGbifTaxonomy(String scientfic_name) {
    	SqlSession session = this.getSessionFactory().openSession();
    	List<NameWithTaxonIdVO> result = null;
    	
    	try {
    		result = session.selectList("Taxon.getScientificNameFromGbifTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   	
    	
    	return result;
    }
    
    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromItisTaxonomy(String scientfic_name) {
    	SqlSession session = this.getSessionFactory().openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromItisTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}
    	
    	return result;
    }

    @Override
    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomy(String scientfic_name) {
    	SqlSession session = this.getSessionFactory().openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}

    	return result;
    }

	@Override
	public List<PhylogeneticTreeVO> getPhylogeneticTree(Map<String, String> map) {
    	SqlSession session = this.getSessionFactory().openSession();
    	List<PhylogeneticTreeVO> result = null;
    	try {
    		result = session.selectList("Kobis.getPhylogeneticTree", map);
    	}finally{
    		session.close();
    	}

    	return result;
	}

	@Override
	public String getT1ClassificationSystemTable(Map<String, String> map) {
    	SqlSession session = this.getSessionFactory().openSession();
    	String result = null;
    	try {
    		result = session.selectOne("Kobis.getT1ClassificationSystemTable", map);
    	}finally{
    		session.close();
    	}

    	return result;
	}

	@Override
	public int insertT1ClassificationSystemTable(Map<String, String> map) {
    	SqlSession session = this.getSessionFactory().openSession( false );

    	int ret = 0;
    	try {
    		ret = session.insert( "Kobis.insertT1ClassificationSystemTable", map);
    		session.commit();
    	}catch(Exception e) {
    		ret = 0;
    		e.printStackTrace();
    		session.rollback();
    	}finally{
    		session.close();
    	}
    	return ret;
	}
}
