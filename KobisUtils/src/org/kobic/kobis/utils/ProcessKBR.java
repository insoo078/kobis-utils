package org.kobic.kobis.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.kobic.kobis.kbr.services.KbrServices;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class ProcessKBR {
	private static Logger logger = Logger.getLogger( ProcessKNRRC.class ); 

	private SqlSessionFactory sessionFactory;
	
//	private String[] files = new String[]{
//			"common.csv", "bodyfluid.csv", "culture.csv", "dna_sequence.csv", "expression.csv", "observation.csv", "proteinsequence.csv", "source.csv", "strain.csv"
//			, "cellstrain.csv", "distribution.csv", "embryo.csv", "extraction.csv", "organ.csv", "reference.csv", "specimen.csv", "structure.csv"
//			, "dna_rna_protein_derivatives.csv", "etc.csv", 	"individual.csv", "patent.csv", "seed.csv", "store.csv", "sysnonym.csv"
//		};
//	
//	
	
	public ProcessKBR() {
		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public void doSomething( String insCd ) throws NoSuchMethodException, SecurityException, Exception {
		KbrServices service = new KbrServices( insCd, this.sessionFactory );
		
		service.read3();
	}

	public static void main(String[] args) {
		ProcessKBR proc = new ProcessKBR();
		
		try {
			proc.doSomething( "INS00009" );
		}catch(Exception e) {
			logger.error( e.getMessage() );
		}
	}
}
