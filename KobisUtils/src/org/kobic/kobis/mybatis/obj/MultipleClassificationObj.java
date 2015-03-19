package org.kobic.kobis.mybatis.obj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kobic.kobis.mybatis.dao.KobisDAO;
import org.kobic.kobis.mybatis.db.vo.D1CommonVO;
import org.kobic.kobis.mybatis.db.vo.NameWithTaxonIdVO;
import org.kobic.kobis.util.Utils;

public class MultipleClassificationObj {
	private List<NameWithTaxonIdVO> kobicTaxons;
	private List<NameWithTaxonIdVO> ncbiTaxons;
	private List<NameWithTaxonIdVO> itisTaxons;
	private List<NameWithTaxonIdVO> gbifTaxons;
	
	private String message;
	private String errorCode;
	
	private KobisDAO dao;
	
	private static final String[] splitWord = new String[]{"var.", "for.", "f.", "ssp.", "spp.", "susp."};

	public static final String MULTIPLE_MAPPING = "001";
	public static final String NOTHING_TO_MAP = "002";
	public static final String FINE_MAPPING = "000";
	
	public MultipleClassificationObj(KobisDAO dao) {
		this.dao = dao;
		this.message = "";
		this.errorCode = "";
	}

	
	
	public String validate( String scientificName ){
		this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomy( scientificName );
		this.ncbiTaxons = this.dao.getScientificNameFromNcbiTaxonomy( scientificName );
		this.itisTaxons = this.dao.getScientificNameFromItisTaxonomy( scientificName );
		this.gbifTaxons = this.dao.getScientificNameFromGbifTaxonomy( scientificName );
		
		return this.errorCode1Check();
	}

	private String errorCode1Check() {
		if( kobicTaxons.size() > 1 ) 	{ message += "  KOBIC  : " + kobicTaxons.size();	errorCode="001";	}
		if( ncbiTaxons.size() > 1 )		{ message += "  NCBI  : " + ncbiTaxons.size();		errorCode="001";	}
		if( itisTaxons.size() > 1 )		{ message += "  ITIS  : " + itisTaxons.size();		errorCode="001";	}
		if( gbifTaxons.size() > 1 )		{ message += "  GBIF  : " + gbifTaxons.size();		errorCode="001";	}

		if( !errorCode.equals("001") ) {
			if( kobicTaxons.isEmpty() && ncbiTaxons.isEmpty() && itisTaxons.isEmpty() && gbifTaxons.isEmpty() ) {
				errorCode = "002";
			}else {
				errorCode = "000";
			}
		}
		
		return this.errorCode;
	}
	
	public void doProcessing( String currentStatus, String scientificName ) throws Exception{
		if( currentStatus.equals( MultipleClassificationObj.MULTIPLE_MAPPING) ) {
			String splitChar = this.getSubDetailWord( scientificName );
			if( splitChar != null ) {
				String[] ref = scientificName.split( splitChar, -1 );
				if( ref.length == 2 ) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("scientific_name", ref[0]);
					map.put("detail", ref[1]);

					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
					if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
				}
			}else {
				// Litsea japonica 로 검색했을 경우 여러개 매핑이 된다면, 실제 환경부 분류체계에서 '종소명없음|국명없음' 없음을 선택하도록 한다
				this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyPure( scientificName );
				if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
				else if( this.kobicTaxons.size() == 0 ) {
					// 만약 매핑된것이 없다면 species로 var. ssp, f. 를 찾아 일치하는 것을 선택해 준다.
					String[] ref = scientificName.split(" ", -1);
					if( ref.length == 2 ) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("scientific_name", scientificName);
						map.put("detail", ref[1]);
						
						this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
						if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
					}
				}
			}
		}else if( currentStatus.equals( MultipleClassificationObj.NOTHING_TO_MAP ) ) {
			// 한곳에도 매핑되는 경우가 없는 경우 var. f. ssp. susp. 등을 제거하고 조회해 본다.   Trichosa kirolowil var. japonica
			String splitChar = this.getSubDetailWord( scientificName );
			if( splitChar != null ) {
				String[] ref = scientificName.split( splitChar, -1 );
				if( ref.length == 2 ) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("scientific_name", scientificName);
					map.put("detail", ref[1]);
					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
					
					if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING; 
					else {
						scientificName = ref[0];
						currentStatus = this.validate( scientificName );
		
						this.doProcessing( currentStatus, scientificName );
					}
				}
			}else {
				// 만약 매핑된것이 없다면 species로 var. ssp, f. 를 찾아 일치하는 것을 선택해 준다.
				String[] ref = scientificName.split(" ", -1);
				if( ref.length == 2 ) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("scientific_name", scientificName);
					map.put("detail", ref[1]);
					
					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
					if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
				}
			}
		}else {
			this.errorCode = MultipleClassificationObj.FINE_MAPPING;
		}
	}
	
	public void updateDatabase( D1CommonVO d1CommonVo, String scientificName ) {
		if( this.errorCode.equals( MultipleClassificationObj.MULTIPLE_MAPPING ) )	{
			d1CommonVo.setMessage( "[001] " + scientificName + "이 여러군데 매핑됩니다. " + message );
			int result = this.dao.insertUnmappedD1Common( d1CommonVo );
		}else if( this.errorCode.equals( MultipleClassificationObj.NOTHING_TO_MAP ) )	{
			d1CommonVo.setMessage( "[002] " + this.dao.getInstitutionId(d1CommonVo.getIns_cd()) + " " + scientificName + " 는 어디에도 매핑되지 않습니다." );
			int result = this.dao.insertUnmappedD1Common( d1CommonVo );
		}else {
			Map<String, String> map = new HashMap<String, String>();
			if( kobicTaxons.size() > 0 )	map.put("KOBIS_CODE", kobicTaxons.get(0).getTax_id() );
			if( ncbiTaxons.size() > 0 )		map.put("ncbi_tax_id", ncbiTaxons.get(0).getTax_id() );
			if( itisTaxons.size() > 0 )		map.put("itis_tax_id", itisTaxons.get(0).getTax_id() );
			if( gbifTaxons.size() > 0 )		map.put("gbif_tax_id", gbifTaxons.get(0).getTax_id() );
			map.put("scientific_name", scientificName );

			String tab_id = Utils.nullToEmpty( this.dao.getT1ClassificationSystemTable( map ) );

    		if( tab_id.isEmpty() ) {
    			int ret = this.dao.insertT1ClassificationSystemTable( map );
    			tab_id = Utils.nullToEmpty( this.dao.getT1ClassificationSystemTable( map ) );
    		}
    		d1CommonVo.setCode( tab_id );
    		this.dao.insertMappedD1Common( d1CommonVo );
		}
	}

	private String getSubDetailWord( String scientificName ) {
		String ret = null;

		for(int i=0; i<splitWord.length; i++) {
			if( scientificName.contains( splitWord[i] ) ) {
				ret = splitWord[i];
				break;
			}
		}
		return ret;
	}
		
//		if( kobicTaxons.isEmpty() && ncbiTaxons.isEmpty() && itisTaxons.isEmpty() && gbifTaxons.isEmpty() ) {
//			// 한곳에도 매핑되는 경우가 없는 경우 var. f. ssp. susp. 등을 제거하고 조회해 본다.   Trichosa kirolowil var. japonica
//			String specific_detail = "";
//
//			String[] ref = this.splitScientificNameByDetail( scientificName );
//			if( ref != null && ref.length == 2 ) {
//				scientificName = ref[0].trim();
//				specific_detail = ref[1].trim();
//			}
//
//			kobicTaxons = this.getDao().getScientificNameFromKobicTaxonomy( scientificName );
//			ncbiTaxons = this.getDao().getScientificNameFromNcbiTaxonomy( scientificName );
//			itisTaxons = this.getDao().getScientificNameFromItisTaxonomy( scientificName );
//			gbifTaxons = this.getDao().getScientificNameFromGbifTaxonomy( scientificName );
//			
//			message = "";
//			if( kobicTaxons.size() > 1 ) 		{message += "  KOBIC  : " + kobicTaxons.size();	print = true;}
//			else if( ncbiTaxons.size() > 1 )	{message += "  NCBI  " + ncbiTaxons.size();		print = true;}
//			else if( itisTaxons.size() > 1)		{message += "  ITIS  " + itisTaxons.size();		print = true;}
//			else if( gbifTaxons.size() > 1 )	{message += "  GBIF  " + gbifTaxons.size();		print = true;}
//
//			// 만약 다시 여러개가 검출이 된다면 var. ssp. f. susp. 등을 참조하여 일치하는 정보를 불러온다
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("scientific_name", scientificName);
//			map.put("detail", specific_detail);
//			kobicTaxons = this.getDao().getScientificNameFromKobicTaxonomyDetail( map );
//			if( kobicTaxons.size() < 2 )	print = false;
//		}else if( kobicTaxons.size() > 1 ) {
//			// 환경부 분류체계의 여러곳에 매핑되는 경우를 해결하기위해
//			if( scientificName.contains("var.") || scientificName.contains("for.") || scientificName.contains("f.") || scientificName.contains("ssp.") || scientificName.endsWith("susp.") ) {
//				;
//			}else {
//				kobicTaxons = this.getDao().getScientificNameFromKobicTaxonomyPure( scientificName );
//				if( kobicTaxons.size() < 2 )	print = false;
//			}
//		}
//	}
}
