package org.kobic.kobis.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.kobic.kobis.file.csv.obj.CateObj;
import org.kobic.kobis.file.csv.obj.NameObj;

public class KobisCate {
	private int idxRowHeader;
	private int idxColHeader;
	private String sep;
	private String filename;
	private HashMap<String, CateObj> root;
	private HashMap<String, Integer> parentList;
	private HashMap<String, String> kingdomMap;
	
	
	private List<String> codeTable;

	public KobisCate( int idxRowHeader, int idxColHeader, String filename, String sep ) {
		this.idxRowHeader = idxRowHeader;
		this.idxColHeader = idxColHeader;
		this.sep = sep;
		this.filename = filename;
		this.root = new LinkedHashMap<String, CateObj>();
		this.kingdomMap = new LinkedHashMap<String, String>();
		this.parentList = new LinkedHashMap<String, Integer>();
		
		String[] codeChars = new String[]{
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
				, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R","S", "T", "U", "V", "W", "X", "Y", "Z"
		};
		
		this.codeTable = new ArrayList<String>();
		for(int i=0; i<codeChars.length; i++) {
			for(int j=0; j<codeChars.length; j++) {
				this.codeTable.add( codeChars[i] + codeChars[j] );
			}
		}
	}
	
	public KobisCate(String filename) {
		this( -1, -1, filename, "," );
	}

	public void readFile(){
		int lineNo = 0;
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader( this.filename ));

			while ((line = br.readLine()) != null) {
				lineNo++;

				if( this.root.containsKey(line) )	continue;

				if( this.idxRowHeader != -1 ) {
					if( this.idxRowHeader == lineNo )	continue;
				}
				String[] country = line.split( this.sep );

				if( country.length == 10 ) {
					CateObj obj = new CateObj();
					obj.setKingdom( country[0] );
					obj.setPhylum( country[1] );
					obj.setClas( country[2] );
					obj.setOrder( country[3] );
					obj.setFamily( country[4] );
					obj.setGenus( country[5] );
					obj.setSpecies( country[6] );
					obj.setSsp( country[7] );
					obj.setVar( country[8] );
					obj.setF( country[9] );

					this.root.put( line, obj );
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found " + e.getLocalizedMessage() );
		} catch (IOException e) {
			throw new RuntimeException("IOException " + e.getLocalizedMessage() );
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void tagging() {
		int depth = 10;

		while( depth > 0 ) {
			for(Iterator<CateObj> iter = this.root.values().iterator(); iter.hasNext();){
				CateObj obj = iter.next();
				
				String parent = "";
				String result = "";
				if( depth == 10 )		{
					parent = "";
					result = obj.getKingdom();
				}else if( depth == 9 ){
					parent = obj.getKingdom();
					result = obj.getKingdom() + "," + obj.getPhylum();
				}else if( depth == 8 ){
					parent = obj.getKingdom() + "," + obj.getPhylum();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas();
				}else if( depth == 7 ){
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder();
				}else if( depth == 6 ){
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily();
				}else if( depth == 5 ){
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus();
				}else if( depth == 4 ){
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies();
				}else if( depth == 3 ){
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies() + "," + obj.getSsp();
				}else if( depth == 2 ){
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies() + "," + obj.getSsp();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies() + "," + obj.getSsp() + "," + obj.getVar();
				}else{
					parent = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies() + "," + obj.getSsp() + "," + obj.getVar();
					result = obj.getKingdom() + "," + obj.getPhylum() + "," + obj.getClas() + "," + obj.getOrder() + "," + obj.getFamily() + "," + obj.getGenus() + "," + obj.getSpecies() + "," + obj.getSsp() + "," + obj.getVar() + "," + obj.getF();
				}

				if( this.kingdomMap.containsKey(result) )	continue;
				
				if( this.parentList.containsKey(parent) && !this.kingdomMap.containsKey(result) ) {
					this.parentList.put( parent, this.parentList.get(parent) + 1 );
					this.kingdomMap.put( result, this.nullToEmpty( this.kingdomMap.get(parent ) ) + this.codeTable.get( this.parentList.get(parent) ) );
				}else {
					this.parentList.put(parent, 0);
					this.kingdomMap.put(result, this.nullToEmpty( this.kingdomMap.get(parent) ) + this.codeTable.get(0) );
				}
				
				if( depth==1 ){
					obj.setCode( this.kingdomMap.get(result) );
				}
			}
			depth--;
		}
	}
	
	public String nullToEmpty(String value) {
		if( value == null )	return "";
		else if( value.isEmpty() )	return "";
		else return value;
	}


	public void print() {
		
		BufferedWriter bw = null;

		try {
			File file = new File(this.filename);
			
			String name = file.getName().split("\\.")[0] + "_final";
			String ext = file.getName().split("\\.")[1];

			String absoluteFile = file.getParent() + File.separator + name + "." + ext;
			bw = new BufferedWriter(new FileWriter( absoluteFile ));

			for(Iterator<CateObj> iter = this.root.values().iterator(); iter.hasNext();){
				CateObj obj = iter.next();
				
				String str = obj.getLine();

				bw.write( obj.getLine() );
				bw.newLine();
			}
			
			bw.close();
		}catch(Exception e) {
			throw new RuntimeException("File write exception : " + e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		KobisCate kc = new KobisCate(1, -1, "/Users/lion/Desktop/kobis_cate.csv", ",");
		kc.readFile();
		kc.tagging();
		kc.print();
	}

	public static NameObj createName(String name) {
		String[] args = name.split("|");
		return new NameObj(args[0], args[1]);
	}
}


//select * from PhylogeneticTree
//where match(KINGDOM, PHYLUM, CLASS, ORDERED, FAMILY, GENUS, SPECIES, SSP, VAR, F)
//against("+'Pino*' -'Pl*'"  in boolean mode);