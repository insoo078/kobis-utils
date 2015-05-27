package org.kobic.kobis.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.kobic.kobis.main.services.CommonServices;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;

public class KobisTextParser {
	private SqlSessionFactory sessionFactory;
	
	public KobisTextParser() {
		this.sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public static void main(String[] args) {
		KobisTextParser parser = new KobisTextParser();
		try {
			parser.toDatabase();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toDatabase() throws IOException {
		int lineNo = 0;
		BufferedReader br = null;
		String line = "";
		
		BufferedWriter bw = null;
		
		String fileName = "/Users/lion/Desktop/result/result_text_parsing.txt";
		
		LineNumberReader  lnr = new LineNumberReader(new FileReader(new File( fileName )));
		lnr.skip(Long.MAX_VALUE);
		int totalLineNo = lnr.getLineNumber() + 1;
		lnr.close();

		CommonServices service = new CommonServices(null, null, this.sessionFactory);
		List<LineObj> lst = new ArrayList<LineObj>();
		try {
			br = new BufferedReader(new FileReader( fileName ));

			while ((line = br.readLine()) != null) {
				lineNo++;

				System.out.println( lineNo + "/" + totalLineNo + " is precessing" );
				String[] div = line.split("\\|", -1);
				LineObj obj = new LineObj( div, true );
				
				lst.add( obj );
				
				if( lst.size() == 500 ) {
					service.textParsing( lst );
					lst = null;
					lst = new ArrayList<LineObj>();
					System.out.println( "map clear : " + lst.size() );
				}
			}
			
			service.textParsing( lst );
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void parseText() throws IOException {
		int lineNo = 0;
		BufferedReader br = null;
		String line = "";
		
		BufferedWriter bw = null;
		
		String filename = "/Users/lion/Desktop/text_parser.txt";
		String outFileName = "/Users/lion/Desktop/result/result_text_parsing.txt";
		
		LineNumberReader  lnr = new LineNumberReader(new FileReader(new File( filename )));
		lnr.skip(Long.MAX_VALUE);
		int totalLineNo = lnr.getLineNumber() + 1;
		lnr.close();

//		List<LineObj> lst = new ArrayList<LineObj>();
		try {
			br = new BufferedReader(new FileReader( filename ));
			bw = new BufferedWriter(new FileWriter( outFileName ) );

			while ((line = br.readLine()) != null) {
				lineNo++;

//				if( lineNo < 1110146 ) continue;
				System.out.println( lineNo + "/" + totalLineNo + " is precessing" );

				String[] div = line.split("\\|", -1);
				LineObj obj = new LineObj( div );
				
				bw.write( obj.getLine() );
				bw.newLine();
				
//				lst.add( obj );
			}
			br.close();			

//			for(LineObj obj:lst) {
//				bw.write( obj.getLine() );
//				bw.newLine();
//			}

			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMeaningWords( String words ) {
		String[] div = words.split(" ", -1);
		
		String ret = "";
		for(String str:div) {
			ret += " " + KobisTextParser.getArrayMeaningWords( str.toCharArray() );
		}
		return ret.trim();
	}
	
	private static String getArrayMeaningWords( char[] words ) {
		int i=0;

		String full_words = "";
		for(int word_size=2; word_size<=words.length; word_size++) {
			int j = word_size;

			while( i+j <= words.length ) {
				for(int pos1=i; pos1<i+j; pos1++) {
					full_words += words[pos1];
				}
				full_words += " ";
				i++;
			}
			i=0;
		}
		
		return full_words.trim();
	}
	
	public class LineObj{
		private int uid;
		private String kor_name;
		private String line_name;
		private String varierty_name;
		private String institution;
		private String category1;
		private String category2;
		private String category3;
		private String keywords;
		private String taxonomy;

		public LineObj(String[] div) {
			this(div, false);
		}
		
		public LineObj(String[] div, boolean flag) {
			if( flag == false ) {
				if( div.length == 10) {
					this.setUid( Integer.parseInt(div[0]) );
					this.setKor_name2( div[1] );
					this.setLine_name2( div[2] );
					this.setVarierty_name2(  div[3] );
					this.setInstitution2(  div[4] );
					this.setCategory12( div[5] );
					this.setCategory22( div[6] );
					this.setCategory32( div[7] );
					this.setKeywords2( div[8] );
					this.setTaxonomy2( div[9] );
				}
			}else {
				this.setUid( Integer.parseInt(div[0]) );
				this.setKor_name( div[1] );
				this.setLine_name( div[2] );
				this.setVarierty_name(  div[3] );
				this.setInstitution(  div[4] );
				this.setCategory1( div[5] );
				this.setCategory2( div[6] );
				this.setCategory3( div[7] );
				this.setKeywords( div[8] );
				this.setTaxonomy( div[9] );
			}
		}
		
		public String getLine() {
			String line = this.uid + "|" + this.kor_name + "|" + this.line_name + "|" + this.varierty_name + "|";
			line += this.institution + "|" + this.category1 + "|" + this.category2 + "|" + this.category3 + "|";
			line += this.keywords + "|" + this.taxonomy;
			
			return line;
		}

		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getKor_name() {
			return kor_name;
		}
		public void setKor_name2(String kor_name) {
			this.kor_name = this.removeBrace( kor_name );
		}
		public String getLine_name() {
			return line_name;
		}
		public void setLine_name2(String line_name) {
			this.line_name = KobisTextParser.getMeaningWords( line_name );
		}
		public String getVarierty_name() {
			return varierty_name;
		}
		public void setVarierty_name2(String varierty_name) {
			this.varierty_name = KobisTextParser.getMeaningWords( varierty_name );
		}
		public String getInstitution() {
			return institution;
		}
		public void setInstitution2(String institution) {
			this.institution = KobisTextParser.getMeaningWords( institution );
		}
		public String getCategory1() {
			return category1;
		}
		public void setCategory12(String category1) {
			this.category1 = this.removeBrace( category1 );
		}
		public String getCategory2() {
			return category2;
		}
		public void setCategory22(String category2) {
			this.category2 = this.removeBrace( category2 );
		}
		public String getCategory3() {
			return category3;
		}
		public void setCategory32(String category3) {
			this.category3 = this.removeBrace( category3 );
		}
		public String getKeywords() {
			return keywords;
		}
		public void setKeywords2(String keywords) {
			this.keywords = KobisTextParser.getMeaningWords( keywords );
		}
		public String getTaxonomy() {
			return taxonomy;
		}
		public void setTaxonomy2(String taxonomy) {
			if( taxonomy.contains(">") ) {
				String[] split = taxonomy.split("\\>", -1);
				String result = "";

				for(String str:split) {
					result += this.removeBrace( str );
				}
				this.taxonomy = result;
			}else {
				this.taxonomy = this.removeBrace( taxonomy );
			}
		}

		public String removeBrace( String word ) {
			if( word.contains("(") ) {
				String[] split = word.split("\\(", -1);
	
				String result = "";
				for(String str:split) {
					result += " " + KobisTextParser.getMeaningWords( str.replace(")", "").trim() );
				}
				return result.trim();
			}else {
				return KobisTextParser.getMeaningWords( word.trim() );
			}
		}
		
		
		
		
		
		
		
		public void setKor_name(String kor_name) {
			this.kor_name = kor_name;
		}
		public void setLine_name(String line_name) {
			this.line_name = line_name;
		}
		public void setVarierty_name(String varierty_name) {
			this.varierty_name = varierty_name;
		}
		public void setInstitution(String institution) {
			this.institution = institution;
		}
		public void setCategory1(String category1) {
			this.category1 = category1;
		}
		public void setCategory2(String category2) {
			this.category2 = category2;
		}
		public void setCategory3(String category3) {
			this.category3 = category3;
		}
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		public void setTaxonomy(String taxonomy) {
			this.taxonomy = taxonomy;
		}
	}
}
