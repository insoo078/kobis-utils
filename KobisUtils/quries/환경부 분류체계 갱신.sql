-- class
update kobis2.X1_PhylogeneticTree
set class='Dothideomycetes|구멍지의강'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class in ('Dothideomycetes|국명없음', 'Dothideomycetes|입술버섯강');

update kobis2.X1_PhylogeneticTree
set class='Lecanoromycetes|접시지의강'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Lecanoromycetes|쌍봉버섯강';

update kobis2.X1_PhylogeneticTree
set class='Sordariomycetes|동충하초강'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|국명없음';

update kobis2.X1_PhylogeneticTree
set class='Ulvophyceae|갈파래강'
where kingdom='Protista|원생생물계' and phylum='Chlorophyta|녹조식물문' and class='Ulvophyceae|국명없음';


select * from kobis2.X1_PhylogeneticTree
where ordered like 'Limnomedusae%';

-- ordered
update kobis2.X1_PhylogeneticTree
set ordered='Coleoptera|딱정벌레목'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered in ('Coleoptera|집게벌레목');


update kobis2.X1_PhylogeneticTree
set ordered='Hymenoptera|풀잠자리목'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered in ('Hymenoptera|벌목');

update kobis2.X1_PhylogeneticTree
set ordered='Limnomedusae|담수해파리목'
where kingdom='Animalia|동물계' and phylum='Cnidaria|자포동물문' and class='Hydrozoa|히드라충강' and ordered in ('Limnomedusae|국명없음');


update kobis2.X1_PhylogeneticTree
set ordered='Macrodasyida|긴띠털배벌레목'
where kingdom='Animalia|동물계' and phylum='Gastrotricha|복모동물' and class='Notassignedclass|국명없음' and ordered='Macrodasyida|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Archaeogastropoda|원시복족목'
where kingdom='Animalia|동물계' and phylum='Mollusca|연체동물문' and class='Gastropoda|복족강' and ordered='Archaeogastropoda|삿갓조개목'

update kobis2.X1_PhylogeneticTree
set ordered='Incertaesedis|국명없음'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Dothideomycetes|구멍지의강' and ordered='Incertaesedis|incertaesedis'

update kobis2.X1_PhylogeneticTree
set ordered='Incertaesedis|국명없음'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Dothideomycetes|구멍지의강' and ordered='Incertaesedis|incertaesedis'

update kobis2.X1_PhylogeneticTree
set ordered='Pleosporales|얇은공버섯목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Dothideomycetes|구멍지의강' and ordered='Pleosporales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Trypetheliales|유두지의목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Dothideomycetes|구멍지의강' and ordered='Trypetheliales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Lecanorales|접시지의목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Lecanoromycetes|접시지의강' and ordered='Lecanorales|쌍봉버섯목'

update kobis2.X1_PhylogeneticTree
set ordered='Umbilicariales|석이지의목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Lecanoromycetes|접시지의강' and ordered='Umbilicariales|석이목'


update kobis2.X1_PhylogeneticTree
set ordered='Rhytismatales|색찌끼버섯목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Leotiomycetes|두건버섯강' and ordered='Rhytismatales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Diaporthales|오리나무버섯목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Diaporthales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Hypocreales|동충하초목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Hypocreales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Xylariales|콩꼬투리버섯목'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Xylariales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Septobasidiales|고약병균목'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Pucciniomycetes|녹균강' and ordered='Septobasidiales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Ustilaginales|깜부기균목'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Ustilaginomycetes|깜부기균강' and ordered='Ustilaginales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Ulvales|갈파래목'
where kingdom='Protista|원생생물계' and phylum='Chlorophyta|녹조식물문' and class='Ulvophyceae|갈파래강' and ordered='Ulvales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Choreotrichida|폐구환소목충목'
where kingdom='Protista|원생생물계' and phylum='Ciliophora|섬모충문' and class='Spirotrichea|선모강' and ordered='Choreotrichida|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Oscillatoriales|흔들말목'
where kingdom='Monera|원핵생물계' and phylum='Cyanobacteria|남조식물문&남세균문' and class='Cyanophyceae|남조강' and ordered='Oscillatoriales|국명없음'

update kobis2.X1_PhylogeneticTree
set ordered='Polygonales|마디풀목'
where kingdom='Plantae|식물계' and phylum='Magnoliophyta|현화식물문' and class='Magnoliopsida|목련강' and ordered='Polygonales|Unknown'

update kobis2.X1_PhylogeneticTree
set ordered='Lamiales|꿀풀목'
where kingdom='Plantae|식물계' and phylum='Magnoliophyta|현화식물문' and class='Magnoliopsida|목련강' and ordered='Lamiales|현삼목'


-- family
update kobis2.X1_PhylogeneticTree
set family='Phalangiidae|참통거미과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Arachnida|거미강' and ordered='Opillionida|통거미목' and family='Phalangiidae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Macrochelidae|파리응애과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Chelicerata|협각강' and ordered='Mesostigmata|중기문목' and family='Macrochelidae|파리응애과(큰집게좀지드기과)'
;
update kobis2.X1_PhylogeneticTree
set family='Steganacaridae|털조개응애과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Chelicerata|협각강' and ordered='Oribatida|날개응애목' and family='Steganacaridae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Varunidae|참게과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Crustacea|갑각강' and ordered='Decapoda|십각목' and family='Varunidae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Anobiidae|빗살수염벌레과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Coleoptera|딱정벌레목' and family='Anobiidae|빗살(살짝)수염벌레과'
;
update kobis2.X1_PhylogeneticTree
set family='Lonchaeidae|창파리과(신칭)'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Diptera|파리목' and family='Lonchaeidae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Lygaeidae|긴노린재과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Hemiptera|노린재목' and family='Lygaeidae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Corophiidae|육질꼬리옆새우과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Maxillopoda|소악강' and ordered='Amphipoda|단각목' and family='Corophiidae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Cyprididae|참씨벌레과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Ostracoda|패충강' and ordered='Podocopida|절병목' and family='Cyprididae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Calloporidae|단단이끼벌레과'
where kingdom='Animalia|동물계' and phylum='Bryozoa|태형동물문' and class='Gymnolaemata|나후강' and ordered='Cheilostomata|순구목' and family='Calloporidae|국명없음'
;
update kobis2.X1_PhylogeneticTree
set family='Emberizidae|멧새과'
where kingdom='Animalia|동물계' and phylum='Chordata|척삭동물문' and class='Aves|조강' and ordered='Passeriformes|참새목' and family='Emberizidae|멧세과'
;

update kobis2.X1_PhylogeneticTree
set family='Ulvaceae|갈파래과'
where kingdom='Protista|원생생물계' and phylum='Chlorophyta|녹조식물문' and class='Ulvophyceae|갈파래강' and ordered='Ulvales|갈파래목' and family='Ulvaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Biddulphiaceae|실패돌말과'
where kingdom='Protista|원생생물계' and phylum='Bacillariophyta|규조식물문' and class='Bacillariophyceae|규조강' and ordered='Centrales|중심규조목' and family='Biddulphiaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Phormidiaceae|흔들말과'
where kingdom='Monera|원핵생물계' and phylum='Cyanobacteria|남조식물문&남세균문' and class='Cyanophyceae|남조강' and ordered='Oscillatoriales|흔들말목' and family='Phormidiaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Ustilaginaceae|깜부기균과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Ustilaginomycetes|깜부기균강' and ordered='Ustilaginales|깜부기균목' and family='Ustilaginaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Septobasidiaceae|교약병균과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Pucciniomycetes|녹균강' and ordered='Septobasidiales|고약병균목' and family='Septobasidiaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Thelephoraceae|사마귀버섯과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Agaricomycetes|주름버섯강' and ordered='Thelephorales|사마귀버섯목' and family='Thelephoraceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Ganodermataceae|불로초과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Agaricomycetes|주름버섯강' and ordered='Polyporales|구멍장이버섯목' and family='Ganodermataceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Peniophoraceae|껍질고약버섯과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Agaricomycetes|주름버섯강' and ordered='Incertaesedis|국명없음' and family='Peniophoraceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Ceratobasidiaceae|가지잘록병균과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Agaricomycetes|주름버섯강' and ordered='Cantharellales|꾀꼬리버섯목' and family='Ceratobasidiaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Typhulaceae|부들국수버섯과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Agaricomycetes|주름버섯강' and ordered='Agaricales|주름버섯목' and family='Typhulaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Psathyrellaceae|눈물버섯과'
where kingdom='Fungi|균계' and phylum='Basidiomycota|담자균문' and class='Agaricomycetes|주름버섯강' and ordered='Agaricales|주름버섯목' and family='Psathyrellaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Xylariaceae|콩꼬투리버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Xylariales|콩꼬투리버섯목' and family='Xylariaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Plectosphaerellaceae|가지포자균과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Incertaesedis|국명없음' and family='Plectosphaerellaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Nectriaceae|알보리수버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Hypocreales|동충하초목' and family='Nectriaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Hypocreaceae|점버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Hypocreales|동충하초목' and family='Hypocreaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Cordycipitaceae|동충하초과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Hypocreales|동충하초목' and family='Cordycipitaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Gnomoniaceae|침버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Diaporthales|오리나무버섯목' and family='Gnomoniaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Diaporthaceae|오리나무버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Sordariomycetes|동충하초강' and ordered='Diaporthales|오리나무버섯목' and family='Diaporthaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Rhytismataceae|색찌끼버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Leotiomycetes|두건버섯강' and ordered='Rhytismatales|색찌끼버섯목' and family='Rhytismataceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Sclerotiniaceae|균핵버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Leotiomycetes|두건버섯강' and ordered='Helotiales|고무버섯목' and family='Sclerotiniaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Dermateaceae|살갗버섯과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Leotiomycetes|두건버섯강' and ordered='Helotiales|고무버섯목' and family='Dermateaceae|국명없음'
;

update kobis2.X1_PhylogeneticTree
set family='Parmeliaceae|매화나무지의과'
where kingdom='Fungi|균계' and phylum='Ascomycota|자낭균문' and class='Lecanoromycetes|접시지의강' and ordered='Lecanorales|접시지의목' and family='Parmeliaceae|국명없음'
;



-- updated

update kobis2.X1_PhylogeneticTree
set family='Epialtidae|뿔물맞이게과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Crustacea|갑각강' and ordered='Decapoda|십각목' and family='Epialtidae|물맞이게과'
;

update kobis2.X1_PhylogeneticTree
set family='Curculionidae|바구미과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Coleoptera|딱정벌레목' and family='Curculionidae|소바구미과'
;

update kobis2.X1_PhylogeneticTree
set family='Scarabaeidae|소똥구리과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Coleoptera|딱정벌레목' and family='Scarabaeidae|소똥구리붙이과'
;

update kobis2.X1_PhylogeneticTree
set family='Pipunculidae|장구등에과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Diptera|파리목' and family='Pipunculidae|머리파리과'
;

update kobis2.X1_PhylogeneticTree
set family='Derbidae|긴날개멸구과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Hemiptera|노린재목' and family='Derbidae|멸구과'
;

update kobis2.X1_PhylogeneticTree
set family='Choreutidae|뭉뚝날개나방과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Lepidoptera|나비목' and family='Choreutidae|밑두리뿔나방과'
;

update kobis2.X1_PhylogeneticTree
set family='Lecithoceridae|뿔나방붙이과'
where kingdom='Animalia|동물계' and phylum='Arthropoda|절지동물문' and class='Insecta|곤충강' and ordered='Lepidoptera|나비목' and family='Lecithoceridae|남방뿔나방과'
;