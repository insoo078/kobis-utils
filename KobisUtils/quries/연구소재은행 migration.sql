-- 미매핑
select 
	SDS_NO as accession_num
	, BANK_NAME as institution
	, CATEGORY_FIRST as category_1
	, CATEGORY_SECOND as category_2
	, GENUS	as genus
	, SPECIES	as species
	, ISO_SOURCE as source
-- 	, SF_GET_NEW_KOBIS_UNIQUE_ID(DATE_FORMAT(CURDATE(), '%Y%m%d'), 'INS00006') as kobis_id
	, 'INS00006' as ins_cd
	, CURRENT_TIMESTAMP() as in_dt
from T9_KNRRC_RESOURCE A
where genus = '' and species = ''
;

select 
	SDS_NO as accession_num
	, BANK_NAME as institution
	, CATEGORY_FIRST as category_1
	, CATEGORY_SECOND as category_2
	, GENUS	as genus
	, SPECIES	as species
	, ISO_SOURCE as source
-- 	, SF_GET_NEW_KOBIS_UNIQUE_ID(DATE_FORMAT(CURDATE(), '%Y%m%d'), 'INS00006') as kobis_id
	, 'INS00006' as ins_cd
	, CURRENT_TIMESTAMP() as in_dt
from T9_KNRRC_RESOURCE A
where genus <> '' or species <> ''
;


select concat(genus, ' ', species), count(*) cnt from T9_KNRRC_RESOURCE
group by concat(genus, ' ', species)


select * from T9_KNRRC_RESOURCE
where genus='Magnaporthe' and accession_no='2009-101-01387';