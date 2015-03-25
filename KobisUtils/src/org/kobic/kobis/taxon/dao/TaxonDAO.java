package org.kobic.kobis.taxon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.taxon.vo.NameWithTaxonIdVO;
import org.kobic.kobis.taxon.vo.PhylogeneticTreeVO;
import org.kobic.kobis.util.Utils;

public class TaxonDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public TaxonDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<PhylogeneticTreeVO> getPhylogeneticTreeByGenus( String genus) {
    	List<PhylogeneticTreeVO> list = null;
    	// autocommit is false
    	SqlSession session = this.sqlSessionFactory.openSession();

    	try {
    		 list = session.selectList("Taxon.getPhylogeneticTreeByGenus", genus );
    	}finally{
    		session.close();
    	}
    	return list;
    }

    public String getInstitutionId(String insCd) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	String result = null;
    	try {
        	result = session.selectOne("Taxon.getInstitutionId", insCd);
	   	}finally{
	   		session.close();
	   	}

    	return Utils.emptyToNull( result );
    }

    public List<NameWithTaxonIdVO> getScientificNameFromNcbiTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromNcbiTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   		

    	return result;
    }
    public List<NameWithTaxonIdVO> getScientificNameFromGbifTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	
    	try {
    		result = session.selectList("Taxon.getScientificNameFromGbifTaxonomy", scientfic_name);
	   	}finally{
	   		session.close();
	   	}   	
    	
    	return result;
    }
    public List<NameWithTaxonIdVO> getScientificNameFromItisTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Taxon.getScientificNameFromItisTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}
    	
    	return result;
    }

    public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomy(String scientfic_name) {
    	SqlSession session = this.sqlSessionFactory.openSession();
    	List<NameWithTaxonIdVO> result = null;
    	try {
    		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomy", scientfic_name);
    	}finally{
    		session.close();
    	}

    	return result;
    }

//  public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomyDetail(Map<String, String> map) {
//	SqlSession session = this.sqlSessionFactory.openSession();
//	List<NameWithTaxonIdVO> result = null;
//	try {
//		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomyDetail", map);
//   	}finally{
//   		session.close();
//   	}   		
//
//	return result;
//}
//public List<NameWithTaxonIdVO> getScientificNameFromKobicTaxonomyPure(String scientfic_name) {
//	SqlSession session = this.sqlSessionFactory.openSession();
//	List<NameWithTaxonIdVO> result = null;
//	try {
//		result = session.selectList("Kobis.getScientificNameFromKobicTaxonomyPure", scientfic_name);
//   	}finally{
//   		session.close();
//   	}   		
//
//	return result;
//}
}
