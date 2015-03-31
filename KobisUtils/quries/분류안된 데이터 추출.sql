
select count(*) from ITIS.T2_UnMappedCommon
where message like '[002]%';

select ins_cd, count(*) from ITIS.T2_UnMappedCommon
group by ins_cd;


select
	accession_num			자원고유번호
	, family				상위분류군
	, genus					속명
	, subgenus				아속명
	, species				종소명
	, synonym				동종이명
	, common_name			일반명
	, kor_name				국명
	, in_species_type		종내_분류군명_종류
	, in_species_name		종내_분류군명_종명이하
	, line_name				계통명
	, variety_name			품종명
	, taxonomy				분류체계
	, institution			기관명
	, category_1			대구분
	, category_2			중구분
	, category_3			부처별자원구분
	, detail_url			상세정보url
	, gene_name				유전자이름
	, accession_no			등록번호
	, sequence				핵산서열
	, keywords				핵심어
	, img_url_1				대표이미지
	, ins_user_email		등록자메일주소
	, message				오류메시지
from ITIS.T2_UnMappedCommon
where ins_cd='INS00001'
and accession_num not in (
	select accession_num from ITIS.T2_UnMappedCommon
	where ins_cd='INS00001'
	and genus = '' or species = ''
);