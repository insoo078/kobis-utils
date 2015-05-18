package org.kobic.kobis.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

public class ReadBigExcel extends ReadExcel{
	private static Logger logger = Logger.getLogger(ReadBigExcel.class); 

	private int rowNum = 0;
	private OPCPackage opcPkg;
	private ReadOnlySharedStringsTable stringsTable;
	private XMLStreamReader xmlReader;

	public ReadBigExcel() {
		super();
	}

	@Override
	public void readExcelFile( String filePath, String output, String header ) throws Exception{
		this.opcPkg = OPCPackage.open(filePath, PackageAccess.READ);
		this.stringsTable = new ReadOnlySharedStringsTable(opcPkg);
		 
		XSSFReader xssfReader = new XSSFReader(opcPkg);
		XMLInputFactory factory = XMLInputFactory.newInstance();

		XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
		while (iter.hasNext()) {
		    InputStream inputStream = iter.next();
		    String sheetName = iter.getSheetName();

		    this.xmlReader = factory.createXMLStreamReader( inputStream );

			while (this.xmlReader.hasNext()) {
				this.xmlReader.next();
				if (this.xmlReader.isStartElement()) {
					if ( this.xmlReader.getLocalName().equals("sheetData") )
						break;
				}
			}

//			while( this.xmlReader.hasNext() ) {
			if( sheetName.equals("Sheet3") || sheetName.equals("Sheet7") || sheetName.equals("Sheet8") || sheetName.equals("Sheet1") ) {
				List<String[]> data = this.readRows( 100 );
				System.out.println( sheetName );
				for(int i=0; i<3; i++) {
					String[] columns = data.get(i);
					for(int j=0; j<columns.length; j++) {
						System.out.print( columns[j] + " " );
					}
					System.out.println("");
				}
			}
//			}

			this.rowNum = 0;
		}
	}
	
	public List<String[]> readRows(int batchSize) throws XMLStreamException {
		String elementName = "row";
		List<String[]> dataRows = new ArrayList<String[]>();
		if (batchSize > 0) {
			while (xmlReader.hasNext()) {
				xmlReader.next();
				if (xmlReader.isStartElement()) {
					if (xmlReader.getLocalName().equals(elementName)) {
						rowNum++;
						dataRows.add(getDataRow());
						if (dataRows.size() == batchSize)
							break;
					}
				}
			}
		}
		return dataRows;
	}
		 
	private String[] getDataRow() throws XMLStreamException {
		List<String> rowValues = new ArrayList<String>();
		while (xmlReader.hasNext()) {
			xmlReader.next();
			if (xmlReader.isStartElement()) {
				if (xmlReader.getLocalName().equals("c")) {
					CellReference cellReference = new CellReference(xmlReader.getAttributeValue(null, "r"));
		     // Fill in the possible blank cells!
					while (rowValues.size() < cellReference.getCol()) {
						rowValues.add("");
					}
					String cellType = xmlReader.getAttributeValue(null, "t");
					rowValues.add(getCellValue(cellType));
				}
			} else if (xmlReader.isEndElement() && xmlReader.getLocalName().equals("row")) {
				break;
			}
		}
		return rowValues.toArray(new String[rowValues.size()]);
	}
		 
	private String getCellValue(String cellType) throws XMLStreamException {
		String value = ""; // by default
		while (xmlReader.hasNext()) {
			xmlReader.next();
			if (xmlReader.isStartElement()) {
				if (xmlReader.getLocalName().equals("v")) {
					if (cellType != null && cellType.equals("s")) {
						int idx = Integer.parseInt(xmlReader.getElementText());
						return new XSSFRichTextString(stringsTable.getEntryAt(idx)).toString();
					} else {
						return xmlReader.getElementText();
					}
				}
			} else if (xmlReader.isEndElement() && xmlReader.getLocalName().equals("c")) {
				break;
			}
		}
		return value;
	}
		 
	protected void finalize() throws Exception {
		if (opcPkg != null)
			opcPkg.close();
	}

	@Override
	public void usage() {
		System.err.println("####################################");
		System.err.println("java ReadBigExcel -i [input file] -o [output directory] -header header prefix");
	}

	public static void main( String[] args ) {
		String[][] params = new String[][]{
				{"-o", "/Users/lion/Desktop", "-i", "/Users/lion/git/kobis-utils/KobisUtils/sample/KOBIS_정보연계표준안_국립중앙과학관.xlsx", "-header", "INS00007"}
		};

		for(int i=0; i<params.length; i++) {
			ReadBigExcel read = new ReadBigExcel();
			try {
				System.out.println( params[i][5] + " processing" );
				read.run( params[i] );
			}catch(Exception e) {
				e.printStackTrace();
			}

			try {
				read.finalize();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
