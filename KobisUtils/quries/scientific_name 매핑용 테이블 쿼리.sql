-- create table ITIS.id_table
-- -- insert into ITIS.scientfic_name
-- select distinct scientific_name from (
-- 	select 
-- 		concat( trim(substring_index(genus, '|', 1)), ' ', trim(substring_index(species, '|', 1))) scientific_name 
-- 	from X1_PhylogeneticTree
-- 	union all
-- 	select
-- 			name_txt scientific_name
-- 	from X1_NcbiTaxonomyName
-- 	union all
-- 	select
-- 			name_txt scientific_name
-- 	from X1_ItisTaxonomyName
-- 	union all
-- 	select
-- 		name_txt scientific_name
-- 	from X1_GbifTaxonomyName
-- ) AA
-- order by scientific_name
-- 

insert into T1_ClassificationSystemTable(scientific_name)
select * from ITIS.id_table
where scientific_name <> ''


select * from X1_NcbiTaxonomyName
where match(name_txt) against('top phytoplasma');

-- insert into T1_ClassificationSystemTable(tab_id, scientific_name)
-- create table ITIS.id_table
-- select md5(uuid()) tab_id, scientific_name from ITIS.scientfic_name;

-- commit;

-- insert into T1_ClassificationSystemTable(tab_id, scientific_name)
-- select * from ITIS.id_table;


delete from T1_ClassificationSystemTable;

-- select * from X1_ItisTaxonomyName
-- where match(name_txt) against('"\'"' in boolean mode);