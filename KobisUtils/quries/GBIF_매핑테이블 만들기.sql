select * from ITIS.taxon;

delete from kobis2.X1_GbifTaxonomyName;
commit;

insert into kobis2.X1_GbifTaxonomyName
select taxonID tax_id, canonicalName name_txt, scientificName scientific_name from ITIS.taxon;

delete from kobis2.X1_GbifTaxonomyNode;
commit;

replace into kobis2.X1_GbifTaxonomyNode(tax_id, parent_tax_id, rank)
select * from tmp
;

replace into kobis2.X1_GbifTaxonomyNode(tax_id, parent_tax_id, rank)
select * from (
	create table tmp
	select 
		BB.taxonID tax_id
		, case when BB.parentNameUsageID = '' or BB.parentNameUsageID is null then
			SF_GET_GBIF_PARENT_TAX_ID(acceptedNameUsageId)
		else	
			BB.parentNameUsageID 
		end parent_tax_id
		, BB.taxonRank rank 
	/*	, BB.scientificName*/
	from ITIS.taxon BB
) AAA
where parent_tax_id is null
;


select SF_GET_GBIF_PARENT_TAX_ID(2891993);

/*4,416,348*/
select count(*) from ITIS.taxon;

		SELECT 
			IFNULL( IF(parentNameUsageID = '', NULL, parentNameUsageID), -99)
			, parentNameUsageID
			, acceptedNameUsageId
			, a.*
		FROM ITIS.taxon a
		where taxonID=2891990;


SELECT 
	*
FROM ITIS.taxon 
WHERE taxonID = 2891990;


select SF_GET_GBIF_PARENT_TAX_ID(2891990);



update X1_GbifTaxonomyName
	set name_txt=scientific_name
where name_txt = ''


