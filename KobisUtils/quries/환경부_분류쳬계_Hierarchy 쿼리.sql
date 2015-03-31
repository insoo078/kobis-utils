-- kingdom
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select
	substring_index(kingdom, '|', 1)	name_txt
    , 0 parent_tax_id
    , 'kingdom' rank
	, substring_index(kingdom, '|', 1)	lineage
from kobis2.X1_PhylogeneticTree
group by kingdom
order by kingdom
;

-- phylum
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select name_txt, parent_tax_id, rank, concat(parent, '-', name_txt) lineage
from (
	select
		substring_index(phylum, '|', 1)	name_txt
		, (
			select
				A.tax_id 
			from ITIS.X1_KobicTaxonomyName A
			where A.rank='kingdom' and A.name_txt=substring_index(KK.kingdom, '|', 1)
		) parent_tax_id
		, 'phylum' rank 
		, (
			select
				A.name_txt 
			from ITIS.X1_KobicTaxonomyName A
			where A.rank='kingdom' and A.name_txt=substring_index(KK.kingdom, '|', 1)
		) parent
	from ITIS.X1_PhylogeneticTree KK
	group by kingdom, phylum
	order by kingdom, phylum
) TT
group by name_txt, parent_tax_id, rank, concat(parent, '-', name_txt)
;

-- class
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select * from (
	select 
		name_txt
		, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=TT.lineage and rank='phylum') parent_tax_id
		, rank
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			substring_index(class, '|', 1)	name_txt
			, 'class' rank 
			, concat(substring_index(KK.kingdom, '|', 1), '-', substring_index(KK.phylum, '|', 1)) lineage
		from ITIS.X1_PhylogeneticTree KK
		group by kingdom, phylum, class
		order by kingdom, phylum, class
	) TT
) XX
group by name_txt, parent_tax_id, rank, lineage
;

-- ordered
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select * from (
	select 
		name_txt
		, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=TT.lineage and rank='class') parent_tax_id
		, rank
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			substring_index(ordered, '|', 1)	name_txt
			, 'order' rank 
			, concat(substring_index(KK.kingdom, '|', 1), '-', substring_index(KK.phylum, '|', 1), '-', substring_index(KK.class, '|', 1)) lineage
		from ITIS.X1_PhylogeneticTree KK
		group by kingdom, phylum, class, ordered
		order by kingdom, phylum, class, ordered
	) TT
) XX
group by name_txt, parent_tax_id, rank, lineage
;

-- family
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select * from (
	select 
		name_txt
		, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=TT.lineage and rank='order') parent_tax_id
		, rank
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			substring_index(family, '|', 1)	name_txt
			, 'family' rank 
			, concat(substring_index(KK.kingdom, '|', 1), '-', substring_index(KK.phylum, '|', 1), '-', substring_index(KK.class, '|', 1), '-', substring_index(KK.ordered, '|', 1)) lineage
		from ITIS.X1_PhylogeneticTree KK
		group by kingdom, phylum, class, ordered, family
		order by kingdom, phylum, class, ordered, family
	) TT
) XX
group by name_txt, parent_tax_id, rank, lineage
;



-- genus
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select * from (
	select 
		name_txt
		, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=TT.lineage and rank='family') parent_tax_id
		, rank
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			substring_index(genus, '|', 1)	name_txt
			, 'genus' rank 
			, concat(substring_index(KK.kingdom, '|', 1), '-', substring_index(KK.phylum, '|', 1), '-', substring_index(KK.class, '|', 1), '-', substring_index(KK.ordered, '|', 1), '-', substring_index(KK.family, '|', 1)) lineage
		from ITIS.X1_PhylogeneticTree KK
		group by kingdom, phylum, class, ordered, family, genus
		order by kingdom, phylum, class, ordered, family, genus
	) TT
) XX
group by name_txt, parent_tax_id, rank, lineage
;


-- species
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select
	concat( (select name_txt from ITIS.X1_KobicTaxonomyName where tax_id=XX.parent_tax_id), ' ', name_txt) name_txt
	, parent_tax_id
	, rank
	, lineage
from (
	select 
		name_txt
		, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=TT.lineage and rank='genus') parent_tax_id
		, rank
		, concat(lineage, '-', genus, ' ', name_txt) lineage
	from (
		select
			substring_index(species, '|', 1)	name_txt
			, 'species' rank
			, substring_index(genus, '|', 1) genus
			, concat(
				substring_index(KK.kingdom, '|', 1), '-', substring_index(KK.phylum, '|', 1), 
				'-', substring_index(KK.class, '|', 1), '-', substring_index(KK.ordered, '|', 1),
				'-', substring_index(KK.family, '|', 1), '-', substring_index(KK.genus, '|', 1) 
			) lineage
		from ITIS.X1_PhylogeneticTree KK
		group by kingdom, phylum, class, ordered, family, genus, species
		order by kingdom, phylum, class, ordered, family, genus, species
	) TT
) XX
group by name_txt, parent_tax_id, rank, lineage
;



-- subspecies
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select
	name_txt
	, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=AA.lineage and rank='species') parent_tax_id
	, 'subspecies' rank
	, concat(lineage, '-', name_txt) lineage
from (
	select
		code
		, concat(kingdom, '-', phylum, '-', class, '-', ordered, '-', family, '-', genus, '-', genus, ' ', species) lineage
		, case when ssp <> '' then
			concat(genus, ' ', species, ' ssp. ', substring_index(ssp, '|', 1))
		end name_txt
		, case when ssp<> '' then	1	else 0 end sspcnt
	from (
		select
			code
 			, substring_index(kingdom, '|', 1) kingdom
 			, substring_index(phylum, '|', 1) phylum
 			, substring_index(class, '|', 1) class
 			, substring_index(ordered, '|', 1) ordered
 			, substring_index(family, '|', 1) family
			, substring_index(genus, '|', 1) genus
 			, substring_index(species, '|', 1) species
			, replace(ssp, '종소명없음|국명없음', '') ssp
		from kobis2.X1_PhylogeneticTree
	) TT
) AA
where sspcnt > 0
group by name_txt, lineage
;


-- variety
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select
	name_txt
	, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=AA.lineage and rank='species') parent_tax_id
	, 'variety' rank
	, concat(lineage, '-', name_txt) lineage
from (
	select
		code
		, concat(kingdom, '-', phylum, '-', class, '-', ordered, '-', family, '-', genus, '-', genus, ' ', species) lineage
		, case when var <> '' then
			concat(genus, ' ', species, ' var. ', substring_index(var, '|', 1))
		end name_txt
		, case when var<> '' then	1	else 0 end varcnt
	from (
		select
			code
 			, substring_index(kingdom, '|', 1) kingdom
 			, substring_index(phylum, '|', 1) phylum
 			, substring_index(class, '|', 1) class
 			, substring_index(ordered, '|', 1) ordered
 			, substring_index(family, '|', 1) family
			, substring_index(genus, '|', 1) genus
 			, substring_index(species, '|', 1) species
			, replace(var, '종소명없음|국명없음', '') var
		from kobis2.X1_PhylogeneticTree
	) TT
) AA
where varcnt > 0
group by name_txt, lineage
;


-- forma
insert into ITIS.X1_KobicTaxonomyName(name_txt, parent_tax_id, rank, lineage)
select
	name_txt
	, (select tax_id from ITIS.X1_KobicTaxonomyName where lineage=AA.lineage and rank='species') parent_tax_id
	, 'forma' rank
	, concat(lineage, '-', name_txt) lineage
from (
	select
		code
		, concat(kingdom, '-', phylum, '-', class, '-', ordered, '-', family, '-', genus, '-', genus, ' ', species) lineage
		, case when f <> '' then
			concat(genus, ' ', species, ' f. ', substring_index(f, '|', 1))
		end name_txt
		, case when f<> '' then	1	else 0 end fcnt
	from (
		select
			code
 			, substring_index(kingdom, '|', 1) kingdom
 			, substring_index(phylum, '|', 1) phylum
 			, substring_index(class, '|', 1) class
 			, substring_index(ordered, '|', 1) ordered
 			, substring_index(family, '|', 1) family
			, substring_index(genus, '|', 1) genus
 			, substring_index(species, '|', 1) species
			, replace(f, '종소명없음|국명없음', '') f 
		from kobis2.X1_PhylogeneticTree
	) TT
) AA
where fcnt > 0
group by name_txt, lineage
;



-- select 
-- 	code
-- 	, kingdom
-- 	, phylum
-- 	, class
-- 	, ordered
-- 	, family
-- 	, genus
-- 	, species
-- 	, replace(ssp, '종소명없음|국명없음', '') ssp
-- 	, replace(var, '종소명없음|국명없음', '') var
-- 	, replace(f, '종소명없음|국명없음', '') f
-- from kobis2.X1_PhylogeneticTree
-- where (kingdom, phylum, class, ordered, family, genus, species) in (
-- 	select 
-- 	-- 	code
-- 		kingdom
-- 		, phylum
-- 		, class
-- 		, ordered
-- 		, family
-- 		, genus
-- 		, species
-- 	-- 	, ssp
-- 	-- 	, var
-- 	-- 	, f
-- 	from (
-- 		select
-- 			code
-- 			, case when ssp <> '' then
-- 				concat(genus, ' ', species, ' ssp. ', substring_index(ssp, '|', 1))
-- 			when var <> '' then
-- 				concat(genus, ' ', species, ' var. ', substring_index(var, '|', 1))
-- 			when f <> '' then
-- 				concat(genus, ' ', species, ' f. ', substring_index(f, '|', 1))
-- 			end name_txt
-- 			, case when ssp<> '' then	1	else 0 end sspcnt
-- 			, case when var<> '' then	1	else 0 end varcnt
-- 			, case when f<> '' then	1	else 0 end fcnt
-- 			, substring_index(ssp_nm, '|', 1) ssp_eng
-- 			, substring_index(ssp_nm, '|', -1) ssp_kor
-- 			, substring_index(var_nm, '|', 1) var_eng
-- 			, substring_index(var_nm, '|', -1) var_kor
-- 			, substring_index(f_nm, '|', 1) f_eng
-- 			, substring_index(f_nm, '|', -1) f_kor
-- 			, ssp
-- 			, var
-- 			, f
-- 			, kingdom
-- 			, phylum
-- 			, class
-- 			, ordered
-- 			, family
-- 			, genus
-- 			, species
-- 		from (
-- 			select 
-- 				code
-- 				, kingdom
-- 				, phylum
-- 				, class
-- 				, ordered
-- 				, family
-- 				, genus
-- 				, species
-- 				, ssp ssp_nm
-- 				, var var_nm
-- 				, f f_nm
-- 	-- 			, substring_index(genus, '|', 1) genus
-- 	-- 			, substring_index(species, '|', 1) species
-- 				, replace(ssp, '종소명없음|국명없음', '') ssp
-- 				, replace(var, '종소명없음|국명없음', '') var
-- 				, replace(f, '종소명없음|국명없음', '') f 
-- 			from kobis2.X1_PhylogeneticTree
-- 		) TT
-- 	) AA
-- 	where (sspcnt + varcnt + fcnt) > 0
-- 	and (
-- 		(ssp_eng = '종소명없음' and ssp_kor <> '국명없음')
-- 		or
-- 		(var_eng = '종소명없음' and var_kor <> '국명없음')
-- 		or
-- 		(f_eng = '종소명없음' and f_kor <> '국명없음')
-- 	)
-- )
-- ;



-- kingdom kor name
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select
	A.tax_id
	, substring_index(B.kingdom, '|', -1) kor_name
from ITIS.X1_KobicTaxonomyName A, kobis2.X1_PhylogeneticTree B
where A.rank='kingdom'
and A.name_txt=substring_index(B.kingdom, '|', 1)
group by tax_id, kor_name;

-- phylum kor name
-- select * from (
-- 	select
-- 		B.tax_id
-- 		, substring_index(A.phylum, '|', -1) kor_name
-- 	from kobis2.X1_PhylogeneticTree A, ITIS.X1_KobicTaxonomyName B
-- 	where B.rank='phylum' and concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1))=B.lineage
-- ) TT
-- group by tax_id, kor_name;


insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='phylum'
) A, (
	select
		substring_index(phylum, '|', -1) kor_name
		, concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
		) lineage
	from kobis2.X1_PhylogeneticTree
) B
where A.lineage=B.lineage
group by tax_id, kor_name;

-- class kor name
-- select tax_id from (
-- select * from (
-- 	select
-- 		B.tax_id
-- 		, substring_index(A.class, '|', -1) kor_name
-- 	from kobis2.X1_PhylogeneticTree A, ITIS.X1_KobicTaxonomyName B
-- 	where B.rank='class' and concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1), '-', substring_index(class, '|', 1))=B.lineage
-- ) TT
-- group by tax_id, kor_name
-- ) K group by tax_id
-- having count(*) > 1;
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='class'
) A, (
	select
		substring_index(class, '|', -1) kor_name
		, concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
			, '-', substring_index(class, '|', 1)
		) lineage
	from kobis2.X1_PhylogeneticTree
) B
where A.lineage=B.lineage
group by tax_id, kor_name;


-- order
-- select tax_id from (
-- 737
-- select * from (
-- 	select
-- 		B.tax_id
-- 		, substring_index(A.ordered, '|', -1) kor_name
-- 	from kobis2.X1_PhylogeneticTree A, ITIS.X1_KobicTaxonomyName B
-- 	where B.rank='order' and concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1), '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1))=B.lineage
-- ) TT
-- group by tax_id, kor_name
-- ) K group by tax_id
-- having count(*) > 1;
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='order'
) A, (
	select
		substring_index(ordered, '|', -1) kor_name
		, concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
			, '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1)
		) lineage
	from kobis2.X1_PhylogeneticTree
) B
where A.lineage=B.lineage
group by tax_id, kor_name;



-- family
-- select * from (
-- 	select
-- 		B.tax_id
-- 		, substring_index(A.family, '|', -1) kor_name
-- 	from kobis2.X1_PhylogeneticTree A, ITIS.X1_KobicTaxonomyName B
-- 	where B.rank='family' and concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1), '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1), '-', substring_index(family, '|', 1))=B.lineage
-- ) TT
-- group by tax_id, kor_name;

-- 3339
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='family'
) A, (
	select
		substring_index(family, '|', -1) kor_name
		, concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
			, '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1)
			, '-', substring_index(family, '|', 1)
		) lineage
	from kobis2.X1_PhylogeneticTree
) B
where A.lineage=B.lineage
group by tax_id, kor_name;


-- genus
-- select * from (
-- 	select
-- 		B.tax_id
-- 		, substring_index(A.genus, '|', -1) kor_name
-- 	from kobis2.X1_PhylogeneticTree A, ITIS.X1_KobicTaxonomyName B
-- 	where B.rank='genus' 
-- 	and B.lineage=concat(
-- 				substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
-- 				, '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1)
-- 				, '-', substring_index(family, '|', 1), '-', substring_index(genus, '|', 1)
-- 	)
-- ) TT
-- group by tax_id, kor_name;


-- 33461
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='genus'
) A, (
	select
		substring_index(genus, '|', -1) kor_name
		, concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
			, '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1)
			, '-', substring_index(family, '|', 1), '-', substring_index(genus, '|', 1)
		) lineage
	from kobis2.X1_PhylogeneticTree
) B
where A.lineage=B.lineage
group by tax_id, kor_name;


-- species
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='species'
) A, (
	select
		substring_index(species, '|', -1) kor_name
		, concat(substring_index(kingdom, '|', 1), '-', substring_index(phylum, '|', 1)
			, '-', substring_index(class, '|', 1), '-', substring_index(ordered, '|', 1)
			, '-', substring_index(family, '|', 1), '-', substring_index(genus, '|', 1)
			, '-', concat(substring_index(genus, '|', 1), ' ', substring_index(species, '|', 1))
		) lineage
	from kobis2.X1_PhylogeneticTree
) B
where A.lineage=B.lineage
group by tax_id, kor_name;
-- and A.name_txt=B.species;







-- subspecies
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='subspecies'
) A, (
	select
		name_txt
		, kor_name
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			code
			, concat(kingdom, '-', phylum, '-', class, '-', ordered, '-', family, '-', genus, '-', genus, ' ', species) lineage
			, case when ssp <> '' then	concat(genus, ' ', species, ' ssp. ', substring_index(ssp, '|', 1)) end name_txt
			, substring_index(ssp, '|', -1) kor_name
			, case when ssp<> '' then	1	else 0 end sspcnt
		from (
			select
				code
				, substring_index(kingdom, '|', 1) kingdom
				, substring_index(phylum, '|', 1) phylum
				, substring_index(class, '|', 1) class
				, substring_index(ordered, '|', 1) ordered
				, substring_index(family, '|', 1) family
				, substring_index(genus, '|', 1) genus
				, substring_index(species, '|', 1) species
				, replace(ssp, '종소명없음|국명없음', '') ssp
			from kobis2.X1_PhylogeneticTree
		) TT
	) AA
	where sspcnt > 0
) B
where A.lineage=B.lineage
group by tax_id, kor_name
;

-- variety
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='variety'
) A, (
	select
		name_txt
		, kor_name
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			code
			, concat(kingdom, '-', phylum, '-', class, '-', ordered, '-', family, '-', genus, '-', genus, ' ', species) lineage
			, case when var <> '' then concat(genus, ' ', species, ' var. ', substring_index(var, '|', 1)) end name_txt
			, substring_index(var, '|', -1) kor_name
			, case when var<> '' then	1	else 0 end varcnt
		from (
			select
				code
				, substring_index(kingdom, '|', 1) kingdom
				, substring_index(phylum, '|', 1) phylum
				, substring_index(class, '|', 1) class
				, substring_index(ordered, '|', 1) ordered
				, substring_index(family, '|', 1) family
				, substring_index(genus, '|', 1) genus
				, substring_index(species, '|', 1) species
				, replace(var, '종소명없음|국명없음', '') var
			from kobis2.X1_PhylogeneticTree
		) TT
	) AA
	where varcnt > 0
) B
where A.lineage=B.lineage
group by tax_id, kor_name
;


-- forma
insert into ITIS.X1_KobicTaxonomyKorName(tax_id, kor_name)
select tax_id, kor_name from (
	select * from ITIS.X1_KobicTaxonomyName
	where rank='forma'
) A, (
	select
		name_txt
		, kor_name
		, concat(lineage, '-', name_txt) lineage
	from (
		select
			code
			, concat(kingdom, '-', phylum, '-', class, '-', ordered, '-', family, '-', genus, '-', genus, ' ', species) lineage
			, case when f <> '' then concat(genus, ' ', species, ' f. ', substring_index(f, '|', 1)) end name_txt
			, substring_index(f, '|', -1) kor_name
			, case when f<> '' then	1	else 0 end fcnt
		from (
			select
				code
				, substring_index(kingdom, '|', 1) kingdom
				, substring_index(phylum, '|', 1) phylum
				, substring_index(class, '|', 1) class
				, substring_index(ordered, '|', 1) ordered
				, substring_index(family, '|', 1) family
				, substring_index(genus, '|', 1) genus
				, substring_index(species, '|', 1) species
				, replace(f, '종소명없음|국명없음', '') f 
			from kobis2.X1_PhylogeneticTree
		) TT
	) AA
	where fcnt > 0
) B
where A.lineage=B.lineage
group by tax_id, kor_name
;


insert into kobis2.X1_KobicTaxonomyName
select tax_id, name_txt from ITIS.X1_KobicTaxonomyName
order by tax_id;


insert into kobis2.X1_KobicTaxonomyNode(tax_id, parent_tax_id, rank)
select tax_id, parent_tax_id, rank from ITIS.X1_KobicTaxonomyName
order by tax_id;

insert into kobis2.X1_KobicTaxonomyKorName(id, tax_id, kor_name)
select id, tax_id, kor_name from ITIS.X1_KobicTaxonomyKorName;

insert into kobis2.X1_KobicTaxonomyName(name_txt)
values('root');

update kobis2.X1_KobicTaxonomyName
set tax_id=0
where name_txt='root'

insert into kobis2.X1_KobicTaxonomyNode(tax_id, parent_tax_id, rank)
values(0, 0, 'root');

select * from ITIS.X1_KobicTaxonomyKorName
where match(kor_name) against('과립*' in boolean mode);