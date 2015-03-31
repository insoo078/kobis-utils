insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000001', 'INS00001', 'changeFor2F', 01, '${in_species_type} EQ \'f.\' AND CONTAINS(${species}, \'for.\') EQ true', 'set :species=REPLACE(${species}, \'for.\', \'f.\')', 'D1CommonVO');

insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000002', 'INS00001', 'changeSPP2SSP', 02, '${in_species_type} EQ \'spp.\'', 'set :species=REPLACE(${species}, \'spp.\', \'ssp.\')', 'D1CommonVO');

insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000003', 'INS00002', 'removeSp', 02, '${species} EQ \'sp.\'', 'set :species=REPLACE(${species}, \'sp.\', \'\')', 'D1CommonVO');

insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000004', 'INS00002', 'removeSp', 02, '${species} EQ \'sp,\'', 'set :species=REPLACE(${species}, \'sp,\', \'\')', 'D1CommonVO');

insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000005', 'INS00002', 'removeSp', 02, '${species} EQ \'sp\'', 'set :species=REPLACE(${species}, \'sp\', \'\')', 'D1CommonVO');

insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000006', 'INS00002', 'removeSp', 02, '${species} EQ \'sp.nov\'', 'set :species=REPLACE(${species}, \'sp.nov\', \'\')', 'D1CommonVO');

insert into R1_RuleTable(rule_id, ins_cd, rule_name, rule_type, rule_condition, rule, sheetName)
values('RULE000007', 'INS00002', 'addHeader', 03, 'STARTWITH(${access_num}, \'KCTC\') EQ false', 'set :access_num=CONCAT(\'KCTC\', ' ', ${access_num})', 'D1DnaRnaProteinDerivativesVO');