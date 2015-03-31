insert into kobis2.X1_ItisTaxonomyName(tax_id, name_txt)
select 
	a.tsn tax_id
	, b.complete_name name_txt
from ITIS.hierarchy a, ITIS.taxonomic_units b
where a.tsn=b.tsn
and b.usage in ('valid', 'accepted');


insert into kobis2.X1_ItisTaxonomyName(tax_id, name_txt)
values(1, 'root');

insert into kobis2.X1_ItisTaxonomyNode(tax_id, parent_tax_id, rank)
select 
	a.tsn tax_id
	, case when a.parent_tsn = 0 then 1 else a.parent_tsn end parent_tax_id
	, c.rank_name rank
from ITIS.hierarchy a, ITIS.taxonomic_units b, ITIS.taxon_unit_types c
where a.tsn=b.tsn and b.rank_id=c.rank_id
and b.kingdom_id=c.kingdom_id;