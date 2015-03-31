select 
	sum(unmapped) + sum(mapped) 합계
	, sum(unmapped) 매핑안된것
	, sum(mapped) 매핑된것
    , sum(classtable) 분류코드갯수
    , concat(sum(mapped)/(sum(mapped)+sum(unmapped)) * 100, '%') 매핑률
from (
	select 
		if(type='Unmapped', cnt, 0) unmapped
		, if( type='Mapped', cnt, 0) mapped
        , if( type='Class', cnt, 0) classtable
	from (
		SELECT 'Unmapped' type, count(*) cnt FROM T2_UnMappedCommon
		UNION ALL
		SELECT 'Mapped' type, count(*) cnt from D1_Common
        UNION ALL
        SELECT 'Class' type, count(*) cnt from T1_ClassificationSystemTable
	) AA
) BB;