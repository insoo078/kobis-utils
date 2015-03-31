select * from T1_ClassificationSystemTable a right outer join X1_GbifTaxonomyName b
on a.scientific_name=b.name_txt;


-- 4,416,348
select count(*) from X1_GbifTaxonomyName;

-- 501,206
select count(*) from X1_ItisTaxonomyName;

-- 1,265,377
select count(*) from X1_NcbiTaxonomyName;




select name_txt from X1_ItisTaxonomyName
select scientific_name from T1_ClassificationSystemTable
;



select * from T1_ClassificationSystemTable a right outer join X1_ItisTaxonomyName b
on a.scientific_name=b.name_txt;


select * from X1_NcbiTaxonomyName a, X1_NcbiTaxonomyNode b
where a.tax_id=b.tax_id and a.name_txt='Abietinella';


select name_txt , count(*) cnt from X1_NcbiTaxonomyName
group by name_txt
having count(*) > 1;


select * from X1_GbifTaxonomyName
where match(name_txt) against('Troximon heterophyllum heterophyllum' in boolean mode)
having name_txt='Troximon heterophyllum heterophyllum';

select * from ITIS.NCBI_names
where name_txt='Acremonium'

select * from ITIS.GBIF_taxon
where canonicalName = ''

select * from (
	select name_txt, count(*) cnt from X1_GbifTaxonomyName
	group by name_txt
	having count(*) > 1
) AA, (
	select name_txt, count(*) cnt from X1_NcbiTaxonomyName
	group by name_txt
	having count(*) > 1
) BB
where AA.name_txt=BB.name_txt;




select name_txt, count(*) from X1_NcbiTaxonomyName
where instr(name_txt, ' ') > 0
group by name_txt
having count(*) > 1;



show variables like 'c%';




INSERT INTO T2_UnMappedCommon(    accession_num, family, genus, subgenus, species, synonym, common_name, kor_name, in_species_type, in_species_name,    line_name, variety_name, taxonomy, institution, category_1, category_2, category_3, detail_url, gene_name,    accession_no, sequence, keywords, img_url_1, ins_user_email, ins_cd   ) 
VALUES(    '001-002-3423', 'Aquifoliaceae (Family)', 'Ilex', '', 'integra', '', '', '감탕나무'    , '', '', '', '', '', '한국생명공학연구원', '식물'    , '추출물(파생물)', '추출물(파생물)', 'http://extract.kribb.re.kr', '', '', '', 'plant extract'    , '', 'plantext@kribb.re.kr', 'INS00001'   )



SELECT    
	CONCAT( trim(substring_index(genus, '|', 1)), ' ', trim(substring_index(species, '|', 1))) scientific_name    
FROM X1_PhylogeneticTree   WHERE CONCAT( trim(substring_index(genus, '|', 1)), ' ', trim(substring_index(species, '|', 1))) = 'yedoense var. poukhanense'


SELECT
	'NCBI'
	, name_txt
FROM X1_NcbiTaxonomyName
WHERE MATCH(name_txt) AGAINST('Penicillium camemberti' IN BOOLEAN MODE)
HAVING name_txt='Penicillium camemberti'
union all
SELECT
	'GBIF'
	, name_txt
FROM X1_GbifTaxonomyName
WHERE MATCH(name_txt) AGAINST('Trachelospermum' IN BOOLEAN MODE)
-- HAVING name_txt='yedoense var. poukhanense'

union all
SELECT
	'ITIS'
	, name_txt
FROM X1_NcbiTaxonomyName
WHERE MATCH(name_txt) AGAINST('Trachelospermum' IN BOOLEAN MODE)
-- HAVING name_txt='yedoense var. poukhanense'


SELECT 
	CODE tax_id
	, CONCAT( trim(substring_index(genus, '|', 1)), ' ', trim(substring_index(species, '|', 1))) name_txt
FROM X1_PhylogeneticTree
WHERE CONCAT( trim(substring_index(genus, '|', 1)), ' ', trim(substring_index(species, '|', 1))) = 'Ligustrum japonicum'


select * from X1_GbifTaxonomyNode a, X1_GbifTaxonomyName b
where a.rank in ('genus', 'superfamily', 'family', 'species', 'subspecies', 'infraspecificname', 'variety', 'form', 'subvariety', 'subform', 'infrasubspecificna')
and a.tax_id=b.tax_id
and name_txt='Acalypha filiformis filiformis'


select name_txt, count(*) cnt from X1_GbifTaxonomyNode a, X1_GbifTaxonomyName b
where a.rank in ('genus', 'superfamily', 'family', 'species', 'subspecies', 'infraspecificname', 'variety', 'form', 'subvariety', 'subform', 'infrasubspecificna')
and a.tax_id=b.tax_id
group by name_txt
having count(*) > 1;



delete from T1_ClassificationSystemTable;
delete from ITIS.T2_UnMappedCommon;


create table ITIS.T2_UnMappedCommon
select * from T2_UnMappedCommon;

create table ITIS.T2_MappedCommon
select * from T2_MappedCommon;


create table ITIS.T1_ClassificationSystemTable
select * from T1_ClassificationSystemTable;