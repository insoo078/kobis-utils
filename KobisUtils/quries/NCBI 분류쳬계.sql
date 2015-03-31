select name_txt, count(*) cnt from ITIS.NCBI_names
where name_class='scientific name'
group by name_txt
having count(*) > 1;




select field1, field2, field3 from ITIS.NCBI_nodes
limit 100;


insert into kobis2.X1_NcbiTaxonomyName(tax_id, name_txt)
select tax_id, name_txt from ITIS.NCBI_names
where name_class='scientific name';


insert into kobis2.X1_NcbiTaxonomyNode(tax_id, parent_tax_id, rank)
select field1, field2, field3 from ITIS.NCBI_nodes