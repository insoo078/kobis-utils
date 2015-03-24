package org.kobic.kobis.taxon.proc;

import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;

import org.kobic.kobis.main.dao.KobisDAO;
import org.kobic.kobis.main.vo.D1CommonVO;

public class MultipleClassificationProc {
//	private List<NameWithTaxonIdVO> kobicTaxons;
//	private List<NameWithTaxonIdVO> ncbiTaxons;
//	private List<NameWithTaxonIdVO> itisTaxons;
//	private List<NameWithTaxonIdVO> gbifTaxons;
	private Map<String, TaxonProc> taxons;
//	private TaxonProc ncbiTaxons;
//	private TaxonProc itisTaxons;
//	private TaxonProc gbifTaxons;
	
	private String message;
	private String errorCode;
	
	private KobisDAO dao;

	private static final String[] splitWord = new String[]{ "var.", "for.", "f.", "ssp.", "spp.", "susp." };

	public static final String FINE_MAPPING				= "000";
	public static final String MULTIPLE_MAPPING			= "001";
	public static final String NOTHING_TO_MAP_IN_ALL	= "002";
	public static final String ERROR_IN_DB				= "003";

	public MultipleClassificationProc(KobisDAO dao) {
		this.dao = dao;
		this.message = "";
		this.errorCode = "";
		this.taxons = new HashMap<String, TaxonProc>();
	}
	
//	private List<NameWithTaxonIdVO> toFindFinalMatching( List<NameWithTaxonIdVO> list, String scientificName ) {
//		if( list.isEmpty() ) {
//			
//		}else if( list.size()  > 0 ) {
//			return list;
//		}
//		
//		return list;
//	}

	public String validate( String scientificName ){
		this.taxons.put( TaxonProc.CLS_TAB_KOBIC,	new TaxonProc( TaxonProc.CLS_TAB_KOBIC,	this.dao.getScientificNameFromKobicTaxonomy( scientificName ) ) );
		this.taxons.put( TaxonProc.CLS_TAB_NCBI,	new TaxonProc( TaxonProc.CLS_TAB_NCBI,	this.dao.getScientificNameFromNcbiTaxonomy( scientificName ) ) );
		this.taxons.put( TaxonProc.CLS_TAB_ITIS,	new TaxonProc( TaxonProc.CLS_TAB_ITIS,	this.dao.getScientificNameFromItisTaxonomy( scientificName ) ) );
		this.taxons.put( TaxonProc.CLS_TAB_GBIF,	new TaxonProc( TaxonProc.CLS_TAB_GBIF,	this.dao.getScientificNameFromGbifTaxonomy( scientificName ) ) );

		return this.errorCode1Check();
	}

	private String errorCode1Check( ) {
		int emptyTaxons = 0;
		for(Iterator<TaxonProc> iter = this.taxons.values().iterator(); iter.hasNext();) {
			TaxonProc taxon = iter.next();
			if( taxon.isStatus( MultipleClassificationProc.MULTIPLE_MAPPING) ) {
				// 어느 하나의 분류체계에서 2개이상 매핑되는 것이 나오면 들어온 레코드 데이터는 중복으로 처리한다
				this.message += taxon.getMessage();
				this.errorCode = MultipleClassificationProc.MULTIPLE_MAPPING;
			}else if( taxon.isStatus( MultipleClassificationProc.NOTHING_TO_MAP_IN_ALL ) )	{ emptyTaxons++;	}
		}

		if( !errorCode.equals( MultipleClassificationProc.MULTIPLE_MAPPING ) ) {
			// 모든 분류체계에서 검색이 안되는 레코드는 현재상태를 미매핑으로 처리한다
			if( emptyTaxons == this.taxons.size() )	this.errorCode = MultipleClassificationProc.NOTHING_TO_MAP_IN_ALL;
			else									this.errorCode = MultipleClassificationProc.FINE_MAPPING;
		}

		return this.errorCode;
	}

//	private void toFindMatchedTaxon( String scientificName ) {
//		String splitChar = this.getSubDetailSplitingWords( scientificName );
//		if( splitChar != null ) {
//			String[] ref = scientificName.split( splitChar, -1 );
//			if( ref.length == 2 ) {
//				String newScientificName = ref[0];
//				this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomy(scientfic_name)
////				Map<String, String> map = new HashMap<String, String>();
////				map.put("scientific_name", ref[0]);
////				map.put("detail", ref[1]);
////
////				this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
//				if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
//			}
//		}
//	}

//	public void doProcessing( String currentStatus, String scientificName ) throws Exception{
//		if( currentStatus.equals( MultipleClassificationObj.MULTIPLE_MAPPING) ) {
//			for(Iterator<TaxonProc> iter = this.taxons.values().iterator(); iter.hasNext();) {
//				TaxonProc taxon = iter.next();
//				if( taxon.getCurrentStatus().equals( MultipleClassificationObj.MULTIPLE_MAPPING) )	this.toFindMatchedTaxon( scientificName );
//			}
//			this.errorCode1Check();
//		}else if( currentStatus.equals( MultipleClassificationObj.NOTHING_TO_MAP_IN_ALL ) ) {
//			for(Iterator<TaxonProc> iter = this.taxons.values().iterator(); iter.hasNext();) {
//				TaxonProc taxon = iter.next();
//				this.toFindMatchedTaxon( scientificName );
//			}
//			this.errorCode1Check();
//		}
//	}

//	public void doProcessing2( String currentStatus, String scientificName ) throws Exception{
//		if( currentStatus.equals( MultipleClassificationObj.MULTIPLE_MAPPING) ) {
//			String splitChar = this.getSubDetailSplitingWords( scientificName );
//			if( splitChar != null ) {
//				String[] ref = scientificName.split( splitChar, -1 );
//				if( ref.length == 2 ) {
//					String newScientificName = ref[0];
//					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomy(scientfic_name)
////					Map<String, String> map = new HashMap<String, String>();
////					map.put("scientific_name", ref[0]);
////					map.put("detail", ref[1]);
////
////					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
//					if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
//				}
//			}else {
//				// Litsea japonica 로 검색했을 경우 여러개 매핑이 된다면, 실제 환경부 분류체계에서 '종소명없음|국명없음' 없음을 선택하도록 한다
//				this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyPure( scientificName );
//				if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
//				else if( this.kobicTaxons.size() == 0 ) {
//					// 만약 매핑된것이 없다면 species로 var. ssp, f. 를 찾아 일치하는 것을 선택해 준다.
//					String[] ref = scientificName.split(" ", -1);
//					if( ref.length == 2 ) {
//						Map<String, String> map = new HashMap<String, String>();
//						map.put("scientific_name", scientificName);
//						map.put("detail", ref[1]);
//						
//						this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
//						if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
//					}
//				}
//			}
//		}else if( currentStatus.equals( MultipleClassificationObj.NOTHING_TO_MAP_IN_ALL ) ) {
//			// 한곳에도 매핑되는 경우가 없는 경우 var. f. ssp. susp. 등을 제거하고 조회해 본다.   Trichosa kirolowil var. japonica
//			String splitChar = this.getSubDetailSplitingWords( scientificName );
//			if( splitChar != null ) {
//				String[] ref = scientificName.split( splitChar, -1 );
//				if( ref.length == 2 ) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("scientific_name", scientificName);
//					map.put("detail", ref[1]);
//					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
//					
//					if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING; 
//					else {
//						scientificName = ref[0];
//						currentStatus = this.validate( scientificName );
//		
//						this.doProcessing( currentStatus, scientificName );
//					}
//				}
//			}else {
//				// 만약 매핑된것이 없다면 species로 var. ssp, f. 를 찾아 일치하는 것을 선택해 준다.
//				String[] ref = scientificName.split(" ", -1);
//				if( ref.length == 2 ) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("scientific_name", scientificName);
//					map.put("detail", ref[1]);
//					
//					this.kobicTaxons = this.dao.getScientificNameFromKobicTaxonomyDetail( map );
//					if( this.kobicTaxons.size() == 1 )	this.errorCode = MultipleClassificationObj.FINE_MAPPING;
//				}
//			}
//		}else {
//			this.errorCode = MultipleClassificationObj.FINE_MAPPING;
//		}
//	}
	
	public boolean updateDatabase( D1CommonVO d1CommonVo, String scientificName ) {
		if( this.errorCode.equals( MultipleClassificationProc.MULTIPLE_MAPPING ) )	{
			d1CommonVo.setMessage( "["+MultipleClassificationProc.MULTIPLE_MAPPING+"] " + scientificName + "이 여러군데 매핑됩니다. " + message );
			this.dao.insertUnmappedD1Common( d1CommonVo );
			
			return false;
		}else if( this.errorCode.equals( MultipleClassificationProc.NOTHING_TO_MAP_IN_ALL ) )	{
			d1CommonVo.setMessage( "["+MultipleClassificationProc.NOTHING_TO_MAP_IN_ALL+"] " + this.dao.getInstitutionId(d1CommonVo.getIns_cd()) + " " + scientificName + " 는 어디에도 매핑되지 않습니다." );
			this.dao.insertUnmappedD1Common( d1CommonVo );
			
			return false;
		}else {
			Map<String, String> map = new HashMap<String, String>();
			for(Iterator<TaxonProc> iter = this.taxons.values().iterator(); iter.hasNext();) {
				TaxonProc taxon = iter.next();
				if( taxon.getName().equals(TaxonProc.CLS_TAB_KOBIC ) && taxon.getCurrentStatus().equals( MultipleClassificationProc.FINE_MAPPING ) )	map.put("kobic_tax_id", taxon.getTaxId() );
				if( taxon.getName().equals(TaxonProc.CLS_TAB_NCBI ) && taxon.getCurrentStatus().equals( MultipleClassificationProc.FINE_MAPPING ) )		map.put("ncbi_tax_id", taxon.getTaxId() );
				if( taxon.getName().equals(TaxonProc.CLS_TAB_ITIS ) && taxon.getCurrentStatus().equals( MultipleClassificationProc.FINE_MAPPING ) )		map.put("itis_tax_id", taxon.getTaxId() );
				if( taxon.getName().equals(TaxonProc.CLS_TAB_GBIF ) && taxon.getCurrentStatus().equals( MultipleClassificationProc.FINE_MAPPING ) )		map.put("gbif_tax_id", taxon.getTaxId() );
			}
			map.put("scientific_name", scientificName );

			int ret = this.dao.insertCommonSheet( d1CommonVo, map );
			if( ret == 0 ) {
				d1CommonVo.setMessage( "["+MultipleClassificationProc.ERROR_IN_DB+"] " + this.dao.getInstitutionId(d1CommonVo.getIns_cd()) + " " + d1CommonVo.getAccess_num() + " 데이터베이스 반영중 오류 발생." );
				return false;
			}

    		return true;
		}
	}

	private String getSubDetailSplitingWords( String scientificName ) {
		String ret = null;

		for(int i=0; i<MultipleClassificationProc.splitWord.length; i++) {
			if( scientificName.contains( MultipleClassificationProc.splitWord[i] ) ) {
				ret = MultipleClassificationProc.splitWord[i];
				break;
			}
		}
		return ret;
	}
}
