
select
	'' tab_id
	, code KOBIS_CODE
	, tax_id ncbi_tax_id
	, ''
	, ''
	, A.original_name
from (
	select CD_TYPE, code, ucase(scientific_name) scientific_name, scientific_name original_name
	from (
		SELECT 
			'KOBIS' CD_TYPE
			, code, ucase(concat(concat(substring_index(genus, '|', 1), ' '), substring_index(species, '|', 1) )) scientific_name
		FROM X1_PhylogeneticTree
	) M
) A left outer join (select tax_id, UCASE(name_txt) name_txt, name_txt orginal_name from X1_NcbiTaxonomyName) B
ON A.scientific_name=B.name_txt

union all

select
	'' tab_id
	, A.code KOBIS_CODE
	, B.tax_id ncbi_tax_id
	, '' T1_CD
	, '' T2_CD
	, B.orginal_name
from (
	select CD_TYPE, code, ucase(scientific_name) scientific_name, scientific_name original_name
	from (
		SELECT 
			'KOBIS' CD_TYPE
			, code, ucase(concat(concat(substring_index(genus, '|', 1), ' '), substring_index(species, '|', 1) )) scientific_name
		FROM X1_PhylogeneticTree
	) M
) A right outer join (select tax_id, UCASE(name_txt) name_txt, name_txt orginal_name from X1_NcbiTaxonomyName) B
ON A.scientific_name=B.name_txt
;