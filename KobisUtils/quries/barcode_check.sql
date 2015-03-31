-- create table kobis_barcode.ncbi_gbif_barcode
-- select species_name from (
-- 	select species_name from (
-- 		select
-- 			species_name 
-- 		from kobis_barcode.barcode_service_list
-- 		group by species_name
-- 		having  species_name <> ''
-- 	) A
-- 	where A.species_name not in (
-- 		select name_txt from kobis2.X1_NcbiTaxonomyName
-- 	)
-- ) AA
-- where AA.species_name not in (
-- 	select name_txt from kobis2.X1_GbifTaxonomyName
-- )


select * from kobis_barcode.barcode_service_list
where species_name in (
	select * from (
		select * from kobis_barcode.ncbi_gbif_barcode
		where species_name not in (
			select name_txt from kobis2.X1_KobicTaxonomyName
		)
	) AA
	where AA.species_name not in (
		select name_txt from kobis2.X1_ItisTaxonomyName
	)
)
;


select distinct species_name from kobis_barcode.barcode_service_list