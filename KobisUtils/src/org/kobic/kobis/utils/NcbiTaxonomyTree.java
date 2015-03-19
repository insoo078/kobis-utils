package org.kobic.kobis.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.kobic.kobis.file.csv.obj.GbifObj;
import org.kobic.kobis.file.csv.obj.NcbiTaxonomyNameObj;
import org.kobic.kobis.mybatis.dao.KobisDAO;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;
import org.kobic.kobis.thread.NcbiTaxonomyNameThread;
import org.kobic.kobis.thread.NcbiTaxonomyNodeThread;

public class NcbiTaxonomyTree {
	private static KobisDAO dao = new KobisDAO( MyBatisConnectionFactory.getSqlSessionFactory() );

	public Map<String, String> getNameMap(String filename) {
		BufferedReader br = null;
		String line = "";
		
		Map<String, String> nameMap = new LinkedHashMap<String, String>();
		try {
			br = new BufferedReader(new FileReader(filename ));
			while( (line = br.readLine()) != null ) {
				String[] divs = line.split("\\|");
				String id = divs[0].replace("\t", "").trim();
				String name = divs[1].replace("\t", "").trim();
				String clas = divs[3].replace("\t", "").trim();

				if( clas.equals("scientific name") )	nameMap.put( id, name );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if( br != null ) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return nameMap;
	}

	public Map<String, Map<String, String>> getNodeMap( String filename) {
		BufferedReader br = null;
		String line = "";

		Map<String, Map<String, String>> linkMap = new LinkedHashMap<String, Map<String, String>>();
		
		try {
			br = new BufferedReader(new FileReader(filename ));
			while( (line = br.readLine()) != null ) {
				String[] divs = line.split("\\|");
				String id = divs[0].replace("\t", "").trim();
				String parent = divs[1].replace("\t", "").trim();
				String type = divs[2].replace("\t", "").trim();

				Map<String,String> nodeMap = new LinkedHashMap<String, String>();
				nodeMap.put("parent", parent);
				nodeMap.put("type", type);

				if( linkMap.containsKey(id) )
						System.out.println( linkMap.get(id) );
				else			linkMap.put( id, nodeMap );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if( br != null ) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return linkMap;
	}

	
	private void writeName( String nameFile ) throws IOException {
		System.out.println( "Reading name dump file....");
		Map<String, String> nameMap = this.getNameMap( nameFile );
		
		System.out.println( "Write name map to file....");
		FileOutputStream fout = new FileOutputStream("/Users/lion/git/kobis-utils/KobisUtils/sample/name.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject( nameMap );
		oos.close();	
	}
	
	private void writeLink( String nodeFile ) throws IOException {
		System.out.println( "Reading node dump file....");
		Map<String, Map<String, String>> linkMap = this.getNodeMap( nodeFile );

		System.out.println( "Write link map to file....");
		FileOutputStream fout = new FileOutputStream("/Users/lion/git/kobis-utils/KobisUtils/sample/link.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject( linkMap );
		oos.close();	
	}
	
	private void writeNameCSV( String nameFile ) throws IOException {
		System.out.println( "Reading name dump file....");
		Map<String, String> nameMap = this.getNameMap( nameFile );
		
//		System.out.println( "Write name map to file....");
//
//		BufferedWriter bw = new BufferedWriter(new FileWriter( "/Users/lion/git/kobis-utils/KobisUtils/sample/name.csv" ));
//		for(String str:nameMap.keySet()) {
//			String id = str;
//			String name = nameMap.get(id);
//			
//			bw.write( id + "," + name );
//			bw.newLine();
//		}
//		bw.close();
	}

	private void writeLinkCSV( String nodeFile ) throws IOException {
		System.out.println( "Reading node dump file....");
		Map<String, Map<String, String>> linkMap = this.getNodeMap( nodeFile );
		
//		System.out.println( "Write name map to file....");
//
//		BufferedWriter bw = new BufferedWriter(new FileWriter( "/Users/lion/git/kobis-utils/KobisUtils/sample/node.sv" ));
//		for(String str:linkMap.keySet()) {
//			String id = str;
//			Map<String, String> subMap = linkMap.get(id);
//			String parentId = subMap.get("parent");
//			String type = subMap.get("type");
//			
//			bw.write( id + "," + parentId + "," + type );
//			bw.newLine();
//		}
//		bw.close();
	}

	public void run( String nameFile, String nodeFile ) throws IOException, ClassNotFoundException {
		CountDownLatch latch = new CountDownLatch(2);
		
		NcbiTaxonomyNameThread nameThread = new NcbiTaxonomyNameThread( nameFile, "reading taxonomy name", latch );
		NcbiTaxonomyNodeThread nodeThread = new NcbiTaxonomyNodeThread( nodeFile, "reading taxonomy node", latch );
		
		new Thread( nameThread ).start();
		new Thread( nodeThread ).start();
		
		try {
			latch.await();

			System.out.println( "Getting map from object" );
			Map<String, String> nameMap = nameThread.getMap();
			Map<String, Map<String, String>> linkMap = nodeThread.getMap();
			
			List<String> ret = this.find( "1", nameMap, linkMap );
			
			for(String item:ret) {
				System.out.println( item );
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> find( String parent, Map<String, String> nameMap, Map<String, Map<String, String>> linkMap ) {
		List<String> lineage = new ArrayList<String>();
		for(Iterator<String> iter=linkMap.keySet().iterator(); iter.hasNext();){
			String id = iter.next();
			Map<String, String> itemMap = linkMap.get(id);
			if( itemMap.get("parent").equals( parent ) ) {
				if( id.equals("131567") )	lineage.addAll( this.find( id, nameMap, linkMap ) );
				else						lineage.add( id + " " + nameMap.get(id) + "|" + itemMap.get("type") );
			}
		}
		return lineage;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		String dir = "/Users/lion/git/kobis-utils/KobisUtils/sample/";
//		String nameFileName = dir + "names.dmp";
//		String nodeFileName = dir + "nodes.dmp";
//
//		NcbiTaxonomyTree tree = new NcbiTaxonomyTree();
//
////		if( !new File(dir + "name.obj").exists() )	tree.writeName( nameFileName );
////		if( !new File(dir + "link.obj").exists() )	tree.writeLink( nodeFileName );
//		
////		if( !new File(dir + "name.csv").exists() )	tree.writeNameCSV( nameFileName );
//		if( !new File(dir + "link.csv").exists() )	tree.writeLinkCSV( nodeFileName );
//		
////		tree.run( dir + "name.obj", dir + "link.obj" );
		
		
//		3123367
		
//			NcbiTaxonomyTree.processGbif();
			NcbiTaxonomyTree.processNcbi();

//			while( (line = br.readLine()) != null ) {
//				String[] divs = line.split("\t", -1);
//				
//				if( divs[0].equals("taxonID") )	continue;
//				else							lst.add( divs );
//
//				total++;
//				if( cnt == 1000 ) {
//					cnt = 0;
//
//					System.out.print("update database " + total + "   time : ");
//					long a = System.cu
//					dao.insertTempGBIF( lst );
//					lst = null;
//					lst = new ArrayList<String[]>();
//				}else {
//					cnt++;
//				}
////				if( divs[3].length() > 255 )
////				if(divs[0].equals("2891990") )
////					System.out.println( divs[3] + "\n" + divs[4] + "\n" + divs[5] +  "  " + line.length() );
//			}
//			System.out.println("finish reading taxon file");
//			
//			dao.insertTempGBIF( lst );
	}
	
	public static void processGbif() throws IOException{
		String filename = "/Users/lion/Desktop/KOBIS_BAK/taxon.txt";
		BufferedReader br = null;
		String line = "";

//		Map<String, Map<String, String>> linkMap = new LinkedHashMap<String, Map<String, String>>();
		
		List<GbifObj> lst = new ArrayList<GbifObj>();
		try {
			br = new BufferedReader(new FileReader(filename ));

			int total = 0;
			while( (line = br.readLine()) != null ) {
				String[] divs = line.split("\t", -1);
				
				if( divs[0].equals("taxonID") )	continue;

				lst.add( new GbifObj( divs ) );

				total++;
				if( lst.size() == 1000 ) {
					System.out.print("update database " + total + "   time : ");
					long a = System.currentTimeMillis();
					dao.insertTempGBIF( lst );
					long b = System.currentTimeMillis();
					lst = null;
					lst = new ArrayList<GbifObj>();
					System.out.println( ((double)(b-a))/1000 + "sec    lst size : " + lst.size() );
				}

//				if( divs[3].length() > 255 )
//				if(divs[0].equals("2891990") )
//					System.out.println( divs[3] + "\n" + divs[4] + "\n" + divs[5] +  "  " + line.length() );
			}
			System.out.println("finish reading taxon file");
			
			if( lst != null ) {
				dao.insertTempGBIF( lst );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			br.close();
		}
	}
	
	public static void processNcbi() throws IOException{
		String filename = "/Users/lion/Desktop/KOBIS_BAK/taxdump/names2.dmp";
		BufferedReader br = null;
		String line = "";

//		Map<String, Map<String, String>> linkMap = new LinkedHashMap<String, Map<String, String>>();
		
		List<NcbiTaxonomyNameObj> lst = new ArrayList<NcbiTaxonomyNameObj>();
		try {
			br = new BufferedReader(new FileReader(filename ));

			int total = 0;
			while( (line = br.readLine()) != null ) {
				String[] divs = line.split("\\|", -1);

				lst.add( new NcbiTaxonomyNameObj( divs ) );

				total++;
				if( lst.size() == 1000 ) {
					System.out.print("update database " + total + "   time : ");
					long a = System.currentTimeMillis();
					dao.insertTempNCBIName( lst );
					long b = System.currentTimeMillis();
					lst = null;
					lst = new ArrayList<NcbiTaxonomyNameObj>();
					System.out.println( ((double)(b-a))/1000 + "sec    lst size : " + lst.size() );
				}

//				if( divs[3].length() > 255 )
//				if(divs[0].equals("2891990") )
//					System.out.println( divs[3] + "\n" + divs[4] + "\n" + divs[5] +  "  " + line.length() );
			}
			System.out.println("finish reading taxon file");
			
			if( lst != null ) {
				dao.insertTempNCBIName( lst );
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			br.close();
		}
	}
	
//	private static KobisDAO dao = new KobisDAO( MyBatisConnectionFactory.getSqlSessionFactory() );
//	
//	public static String getParent(String str) {
//		String[] args = str.split("\t");
//		
//		return args[0];
//	}
//
////	public static Map<String, String> getCodeMap( Map<String, String> parentMap, List<String> list, int dpeth ) {
////		Collections.sort( list );
////
////		if( parentMap == null )	{
////			parentMap = new LinkedHashMap<String, String>();
////			
////			int i = 1;
////			for( String item:list ) {
////				parentMap.put( item, StringUtils.leftPad( Integer.toString(i++).toString(), 1, "0") );
////			}
////		}else {
////			Map<String, Integer> subMaxCount = new LinkedHashMap<String, Integer>();
////			for( String item:list ) {
////				String parentItem = NcbiTaxonomyTree.getParent( item );
////
////				if( subMaxCount.containsKey(parentItem) )	subMaxCount.put(parentItem, subMaxCount.get(parentItem) + 1 );
////				else										subMaxCount.put(parentItem, 1);
////	
////				if( parentMap.containsKey( parentItem ) )	{
////					int width = subMaxCount.get(parentItem).toString().length();
////					String id = Utils.nullToEmpty( parentMap.get(parentItem) ) + StringUtils.leftPad( subMaxCount.get(parentItem).toString(), width, "0");
////					parentMap.put( item, id );
////				}
////			}
////		}
////
////		return parentMap;
////	}
//	
//	public static void getCodeMap( List<String> list, int depth ) {
//		Collections.sort( list );
//
//		int i = 1;
//		Map<String, Integer> subMaxCount = new LinkedHashMap<String, Integer>();
//
//		for( String item:list ) {
//			String parentItem = NcbiTaxonomyTree.getParent( item );
//			
//			String parentId = NcbiTaxonomyTree.dao.getTempNCBI( parentItem );
//			if( depth == 0 ) {
//				Map<String, String> map = new LinkedHashMap<String, String>();
//				
//				String id = StringUtils.leftPad( Integer.toString(i++).toString(), 1, "0");
//				map.put("lineage", item);
//				map.put("id", id);
//
//				int ret = dao.insertTempNCBI( map );
//			}else {
//				if( subMaxCount.containsKey(parentItem) )	subMaxCount.put(parentItem, subMaxCount.get(parentItem) + 1 );
//				else										subMaxCount.put(parentItem, 1);
//
//				if( parentId != null )	{
////					int width = subMaxCount.get(parentItem).toString().length();
//					String id = parentId + StringUtils.leftPad( subMaxCount.get(parentItem).toString(), 3, "0");
//					
//					Map<String, String> map = new LinkedHashMap<String, String>();
//					map.put("lineage", item);
//					map.put("id", id);
//
//					int ret = dao.insertTempNCBI( map );
//				}
//
//				System.out.println( parentItem );
//			}
//		}
////
////		NcbiTaxonomyTree.dao.getTempNCBI( )
////		if( parentMap == null )	{
////			parentMap = new LinkedHashMap<String, String>();
////			
////			int i = 1;
////			for( String item:list ) {
////				parentMap.put( item, StringUtils.leftPad( Integer.toString(i++).toString(), 1, "0") );
////			}
////		}else {
////			Map<String, Integer> subMaxCount = new LinkedHashMap<String, Integer>();
////			for( String item:list ) {
////				String parentItem = NcbiTaxonomyTree.getParent( item );
////
////				if( subMaxCount.containsKey(parentItem) )	subMaxCount.put(parentItem, subMaxCount.get(parentItem) + 1 );
////				else										subMaxCount.put(parentItem, 1);
////	
////				if( parentMap.containsKey( parentItem ) )	{
////					int width = subMaxCount.get(parentItem).toString().length();
////					String id = Utils.nullToEmpty( parentMap.get(parentItem) ) + StringUtils.leftPad( subMaxCount.get(parentItem).toString(), width, "0");
////					parentMap.put( item, id );
////				}
////			}
////		}
//
//		return;
//	}
//
//	public static String getLastItem(String[] arraryVal, int width) {
//		String ret = "";
//		try {
//			for(int i=0; i<=width; i++) {
//				if( i == width )	ret += arraryVal[arraryVal.length-1-i];
//				else				ret += arraryVal[arraryVal.length-1-i] + "\t";
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return ret;
//	}
//
//
//	public static void main(String[] args){
//		BufferedReader br = null;
//		String line = "";
//
//		String filename = "/Users/lion/git/kobis-utils/KobisUtils/sample/ncbi_taxonomy_names_v2";
//
//		try {
//			br = new BufferedReader(new FileReader(filename ));
//			
//			while( (line = br.readLine()) != null ) {
//				String[] arrays = line.replace("	cellular organisms|no rank", "").split("\t");
//
//				String[] newArray = Arrays.copyOfRange( arrays, 1, arrays.length );
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally{
//			if( br != null ) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}		
//		
////		Map<String, String> parentMap = null;
//
////		System.out.println("Truncate TempNCBI table");
////		NcbiTaxonomyTree.dao.deleteTempNCBI();
//
////		for(int i=0; i<39; i++) {
////			List<String> lineage = new ArrayList<String>();
////			try {
////				br = new BufferedReader(new FileReader(filename ));
////	
////				while( (line = br.readLine()) != null ) {
////					if( line.contains("|species") ) {
////						String[] arrays = line.replace("	cellular organisms|no rank", "").split("\t");
////
////							String[] newArray = Arrays.copyOfRange( arrays, 1, arrays.length );
////
////							if( newArray.length > i ) {
////								String lastItem = NcbiTaxonomyTree.getLastItem( newArray, i );
////								if( !lineage.contains(lastItem) )	{
////									lineage.add( lastItem );
////								}
////							}
////					}
////				}
////
//////				parentMap = NcbiTaxonomyTree.getCodeMap( parentMap, lineage, i );
////				NcbiTaxonomyTree.getCodeMap( lineage, i );
////			}catch(Exception e) {
////				e.printStackTrace();
////			}finally{
////				if( br != null ) {
////					try {
////						br.close();
////					} catch (IOException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////				}
////			}
////		}
//	}
}
