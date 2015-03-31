DROP FUNCTION IF EXISTS `SF_GET_NEW_KOBIS_UNIQUE_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_KOBIS_UNIQUE_ID`(dt varchar(8), input_in_cd varchar(8)) RETURNS varchar(25) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(25);
set return_value=null;
select
        concat('KBS-', input_in_cd, '-', lpad(ifnull(max(right(kobis_id, 10)), 0) + 1, 10, '0')) into return_value
from D1_Common
/*where date_format(curdate(), '%Y%m%d')=date_format(fst_dt, '%Y%m%d');*/
where date_format(in_dt, '%Y%m%d')=dt and ins_cd=input_in_cd;
return return_value;
end
 ;;
delimiter ;



-- ----------------------------
--  Function structure for `SF_GET_NEW_NOTICE_ID`
-- ----------------------------
DROP FUNCTION IF EXISTS `SF_GET_NEW_NOTICE_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_NOTICE_ID`(dt varchar(8)) RETURNS varchar(16) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(16);
set return_value=null;
select
        /*concat(concat('KOBIS', date_format(curdate(), '%Y%m%d')), lpad(ifnull(max(right(id, 3)), 0) + 1, 3, '0')) into return_value*/
        concat(concat('KOBIS', date_format(curdate(), '%Y%m%d')), lpad(ifnull(max(right(id, 3)), 0) + 1, 3, '0')) into return_value
from L1_Notice
/*where date_format(curdate(), '%Y%m%d')=date_format(fst_dt, '%Y%m%d');*/
where date_format(fst_dt, '%Y%m%d')=dt;
return return_value;
end
 ;;
delimiter ;

-- ----------------------------
--  Function structure for `SF_GET_NEXT_ARTICLE_IN_NOTICE`
-- ----------------------------
DROP FUNCTION IF EXISTS `SF_GET_NEXT_ARTICLE_IN_NOTICE`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEXT_ARTICLE_IN_NOTICE`(input_id varchar(16)) RETURNS varchar(16) CHARSET utf8
DETERMINISTIC
begin
declare return_value varchar(16);
set return_value=null;

select
        min(id) into return_value
from L1_Notice
where type='01'
and right(id, 11) > (right( input_id, 11));

return return_value;
end
 ;;
delimiter ;

-- ----------------------------
--  Function structure for `SF_GET_PREVIOUS_ARTICLE_IN_NOTICE`
-- ----------------------------
DROP FUNCTION IF EXISTS `SF_GET_PREVIOUS_ARTICLE_IN_NOTICE`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_PREVIOUS_ARTICLE_IN_NOTICE`(input_id varchar(16)) RETURNS varchar(16) CHARSET utf8
DETERMINISTIC
begin
declare return_value varchar(16);
set return_value=null;

select
        max(id) into return_value
from L1_Notice
where type='01'
and right(id, 11) < (right( input_id, 11));

return return_value;
end
 ;;
delimiter ;




DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_NCBI_PARENT_TAX_ID` $$
CREATE FUNCTION `SF_GET_NCBI_PARENT_TAX_ID` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE rv VARCHAR(4024);
    DECLARE cm CHAR(1);
    DECLARE ch INT;

    SET rv = GivenID;
    SET cm = '&';
    SET ch = GivenID;

    WHILE ch > 1 DO
        SELECT IFNULL(`parent_tax_id`, -99) INTO ch FROM
        (
			SELECT `parent_tax_id` FROM X1_NcbiTaxonomyNode WHERE tax_id = ch
		) A;

        IF ch >= 1 THEN
            SET rv = CONCAT(ch, cm, rv);
            SET cm = '&';
        END IF;
    END WHILE;
    RETURN rv;

END $$
DELIMITER ;

DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_NCBI_PARENT_LINEAGE` $$
CREATE FUNCTION `SF_GET_NCBI_PARENT_LINEAGE` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE parent_idx VARCHAR(4024);
    DECLARE lineage VARCHAR(4024);
    DECLARE split CHAR(1);
    DECLARE ch INT;

    SET parent_idx = '';
	SET lineage = '';
    SET split = '';
    SET ch = GivenID;

    WHILE ch > 1 DO
        SELECT 
			AA.`lineage`, AA.`parent_tax_id` INTO parent_idx, ch
		FROM
        (
			SELECT 
				CONCAT(A.`tax_id`, '|', `parent_tax_id`, '|', `rank`, '|', `name_txt`) as lineage
				, A.parent_tax_id
			FROM X1_NcbiTaxonomyNode A, X1_NcbiTaxonomyName B 
			WHERE A.tax_id = ch
			AND A.tax_id=B.tax_id
		) AA;

        IF ch >= 1 THEN
            SET lineage = CONCAT(lineage, split, parent_idx);
            SET split = '&';
        END IF;
    END WHILE;
    RETURN lineage;

END $$
DELIMITER ;




DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_ITIS_PARENT_LINEAGE` $$
CREATE FUNCTION `SF_GET_ITIS_PARENT_LINEAGE` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE parent_idx VARCHAR(4024);
    DECLARE lineage VARCHAR(4024);
    DECLARE split CHAR(1);
    DECLARE ch INT;

    SET parent_idx = '';
	SET lineage = '';
    SET split = '';
    SET ch = GivenID;

    WHILE ch > -1 DO
        SELECT 
			AA.`lineage`, AA.`parent_tax_id` INTO parent_idx, ch
		FROM
        (
			SELECT 
				CONCAT(A.`tax_id`, '|', `parent_tax_id`, '|', `rank`, '|', `name_txt`) as lineage
				, A.parent_tax_id
			FROM X1_ItisTaxonomyNode A, X1_ItisTaxonomyName B 
			WHERE A.tax_id = ch
			AND A.tax_id=B.tax_id
		) AA;

        IF ch >= -1 THEN
            SET lineage = CONCAT(lineage, split, parent_idx);
            SET split = '&';
        END IF;
    END WHILE;
    RETURN lineage;

END $$
DELIMITER ;



DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_ITIS_PARENT_TAX_ID` $$
CREATE FUNCTION `SF_GET_ITIS_PARENT_TAX_ID` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE rv VARCHAR(4024);
    DECLARE cm CHAR(1);
    DECLARE ch INT;

    SET rv = GivenID;
    SET cm = '&';
    SET ch = GivenID;

    WHILE ch > -1 DO
        SELECT IFNULL(`parent_tax_id`, -99) INTO ch FROM
        (
			SELECT `parent_tax_id` FROM X1_ItisTaxonomyNode WHERE tax_id = ch
		) A;

        IF ch >= -1 THEN
            SET rv = CONCAT(ch, cm, rv);
            SET cm = '&';
        END IF;
    END WHILE;
    RETURN rv;

END $$
DELIMITER ;


DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_KOBIC_PARENT_TAX_ID` $$
CREATE FUNCTION `SF_GET_KOBIC_PARENT_TAX_ID` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE rv VARCHAR(4024);
    DECLARE cm CHAR(1);
    DECLARE ch INT;

    SET rv = GivenID;
    SET cm = '&';
    SET ch = GivenID;

    WHILE ch > 0 DO
        SELECT IFNULL(`parent_tax_id`, -99) INTO ch FROM
        (
			SELECT `parent_tax_id` FROM X1_KobicTaxonomyNode WHERE tax_id = ch
		) A;

        IF ch >= 0 THEN
            SET rv = CONCAT(ch, cm, rv);
            SET cm = '&';
        END IF;
    END WHILE;
    RETURN rv;

END $$
DELIMITER ;

DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_KOBIC_PARENT_LINEAGE` $$
CREATE FUNCTION `SF_GET_KOBIC_PARENT_LINEAGE` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE parent_idx VARCHAR(4024);
    DECLARE lineage VARCHAR(4024);
    DECLARE split CHAR(1);
    DECLARE ch INT;

    SET parent_idx = '';
	SET lineage = '';
    SET split = '';
    SET ch = GivenID;

    WHILE ch > 0 DO
        SELECT 
			AA.`lineage`, AA.`parent_tax_id` INTO parent_idx, ch
		FROM
        (
			SELECT 
				CONCAT(A.`tax_id`, '|', `parent_tax_id`, '|', `rank`, '|', `name_txt`) as lineage
				, A.parent_tax_id
			FROM X1_KobicTaxonomyNode A, X1_KobicTaxonomyName B 
			WHERE A.tax_id = ch
			AND A.tax_id=B.tax_id
		) AA;

        IF ch >= 0 THEN
            SET lineage = CONCAT(lineage, split, parent_idx);
            SET split = '&';
        END IF;
    END WHILE;
    RETURN lineage;

END $$
DELIMITER ;


DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_GBIF_PARENT_LINEAGE` $$
CREATE FUNCTION `SF_GET_GBIF_PARENT_LINEAGE` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE parent_idx VARCHAR(4024);
    DECLARE lineage VARCHAR(4024);
    DECLARE split CHAR(1);
    DECLARE ch INT;
	DECLARE current_tax_id INT;

    SET parent_idx = '';
	SET lineage = '';
    SET split = '';
    SET ch = GivenID;
	SET current_tax_id = 999;


    WHILE current_tax_id != -1 AND ch != -1 DO
        SELECT 
			AA.`lineage`, AA.`parent_tax_id`, AA.`tax_id` INTO parent_idx, ch, current_tax_id
		FROM
        (
			SELECT 
				CONCAT(A.`tax_id`, '|', `parent_tax_id`, '|', `rank`, '|', `scientific_name`) as lineage
				, A.parent_tax_id
				, A.tax_id
			FROM X1_GbifTaxonomyNode A, X1_GbifTaxonomyName B 
			WHERE A.tax_id = ch
			AND A.tax_id=B.tax_id
		) AA;

        IF ch >= -1 THEN
            SET lineage = CONCAT(lineage, split, parent_idx);
            SET split = '&';
        END IF;
    END WHILE;
    RETURN lineage;

END $$
DELIMITER ;



DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_GBIF_PARENT_TAX_ID` $$
CREATE FUNCTION `SF_GET_GBIF_PARENT_TAX_ID` (GivenID INT) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE rv VARCHAR(4024);
    DECLARE cm CHAR(1);
    DECLARE ch INT;

    SET rv = GivenID;
    SET cm = '&';
    SET ch = GivenID;

    WHILE ch > -1 DO
        SELECT IFNULL(`parent_tax_id`, -99) INTO ch FROM
        (
			SELECT `parent_tax_id` FROM X1_GbifTaxonomyNode WHERE tax_id = ch
		) A;

        IF ch >= -1 THEN
            SET rv = CONCAT(ch, cm, rv);
            SET cm = '&';
        END IF;
    END WHILE;
    RETURN rv;

END $$
DELIMITER ;


-- DELIMITER $$
-- DROP FUNCTION IF EXISTS `SF_GET_GBIF_PARENT_TAX_ID` $$
-- CREATE FUNCTION `SF_GET_GBIF_PARENT_TAX_ID` (GivenID INT) RETURNS int(11)
-- DETERMINISTIC
-- BEGIN
--     DECLARE rv int(11);
-- 	DECLARE id int(11);
-- 
--     SET rv = -99;
-- 	SET id = GivenID;
-- 
--     WHILE rv = -99 DO
-- 		SELECT 
-- 			IFNULL( IF(parentNameUsageID = '', NULL, parentNameUsageID), -99) into rv
-- 		FROM ITIS.taxon 
-- 		WHERE taxonID = id;
-- 
-- 		IF( rv = 99 ) THEN
-- 			SELECT 
-- 				`acceptedNameUsageId` into id 
-- 			FROM ITIS.taxon 
-- 			WHERE taxonID = id;
-- 		END IF;
-- 	END WHILE;
--     RETURN rv;
-- 
-- END $$
-- DELIMITER ;




DELIMITER $$
DROP FUNCTION IF EXISTS `SF_GET_PARENT_TAX_ID` $$
CREATE FUNCTION `SF_GET_PARENT_TAX_ID` (GivenID INT, type varchar(20)) RETURNS VARCHAR(4024)
DETERMINISTIC
BEGIN
    DECLARE rv VARCHAR(4024);

	IF type='NCBI' THEN
		set rv = SF_GET_NCBI_PARENT_TAX_ID( GivenID );
	ELSEIF type='GBIF' THEN
		set rv = SF_GET_GBIF_PARENT_TAX_ID( GivenID );
	ELSEIF type='ITIS' THEN
		set rv = SF_GET_ITIS_PARENT_TAX_ID( GivenID );
	ELSE
		set rv = SF_GET_KOBIC_PARENT_TAX_ID( GivenID );
	END IF;

    RETURN rv;

END $$
DELIMITER ;



DROP FUNCTION IF EXISTS `SF_GET_NEW_SYNONYM_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_SYNONYM_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	ifnull(max(synonym_id)+1, 0) into return_value
from E1_Synonym
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;



DROP FUNCTION IF EXISTS `SF_GET_NEW_EXTRACT_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_EXTRACT_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(synonym_id)+1, 0) into return_value
	concat('EXT', ifnull(max(substring_index(protein_seq_id, 'EXT', -1)) + 1, 0)) into return_value
from D1_Extraction
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_ETC_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_ETC_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(etc_id)+1, 0) into return_value
	concat('ETC', ifnull(max(substring_index(protein_seq_id, 'ETC', -1)) + 1, 0)) into return_value
from D1_Etc
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;



DROP FUNCTION IF EXISTS `SF_GET_NEW_DNA_SEQUENCE_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_DNA_SEQUENCE_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(sequence_id)+1, 0) into return_value
	concat('DNA_SEQ', ifnull(max(substring_index(protein_seq_id, 'DNA_SEQ', -1)) + 1, 0)) into return_value
from D1_Dna_Sequence
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_STRUCTURE_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_STRUCTURE_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(structure_id)+1, 0) into return_value
	concat('STR', ifnull(max(substring_index(protein_seq_id, 'STR', -1)) + 1, 0)) into return_value
from D1_Structure
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_EXPRESSION_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_EXPRESSION_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(expression_id)+1, 0) into return_value
	concat('EXP', ifnull(max(substring_index(protein_seq_id, 'EXP', -1)) + 1, 0)) into return_value
from D1_Expression
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_SPECIMEN_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_SPECIMEN_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(expression_id)+1, 0) into return_value
	concat('EXP', ifnull(max(substring_index(specimen_id, 'EXP', -1)) + 1, 0)) into return_value
from D1_Specimen
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_PROTEIN_SEQUENCE_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_PROTEIN_SEQUENCE_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
-- 	ifnull(max(expression_id)+1, 0) into return_value
	concat('PRO_SEQ', ifnull(max(substring_index(protein_seq_id, 'PRO_SEQ', -1)) + 1, 0)) into return_value
from D1_ProteinSequence
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_BODY_FLUID_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_BODY_FLUID_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('B', ifnull(max(substring_index(body_fluid_id, 'B', -1)) + 1, 0)) into return_value
from D1_BodyFluid
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_CELL_STRAIN_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_CELL_STRAIN_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('C', ifnull(max(substring_index(cellstrain_id, 'C', -1)) + 1, 0)) into return_value
from D1_CellStrain
where accession_num=acc_num;
return return_value;
end
 ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_STRAIN_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_STRAIN_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('S', ifnull(max(substring_index(strain_id, 'S', -1)) + 1, 0)) into return_value
from D1_Strain
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_SPECIMEN_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_SPECIMEN_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('SPE', ifnull(max(substring_index(specimen_id, 'SPE', -1)) + 1, 0)) into return_value
from D1_Specimen
where accession_num=acc_num;
return return_value;
end
 ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_OBSERVATION_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_OBSERVATION_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('OBS', ifnull(max(substring_index(obs_id, 'OBS', -1)) + 1, 0)) into return_value
from D1_Observation
where accession_num=acc_num;
return return_value;
end
 ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_INDIVIDUAL_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_INDIVIDUAL_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('IND', ifnull(max(substring_index(individual_id, 'IND', -1)) + 1, 0)) into return_value
from D1_Individual
where accession_num=acc_num;
return return_value;
end
 ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_ORGAN_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_ORGAN_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('ORG', ifnull(max(substring_index(individual_id, 'ORG', -1)) + 1, 0)) into return_value
from D1_Organ
where accession_num=acc_num;
return return_value;
end
 ;


DROP FUNCTION IF EXISTS `SF_GET_NEW_SOURCE_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_SOURCE_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('SOU', ifnull(max(substring_index(source_id, 'SOU', -1)) + 1, 0)) into return_value
from D1_Source
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_SEED_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_SEED_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('SEE', ifnull(max(substring_index(seed_id, 'SEE', -1)) + 1, 0)) into return_value
from D1_Seed
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_EMBRYO_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_EMBRYO_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('EMB', ifnull(max(substring_index(embryo_id, 'EMB', -1)) + 1, 0)) into return_value
from D1_Embryo
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_DNA_RNA_PROT_DEV_ID`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_DNA_RNA_PROT_DEV_ID`(acc_num varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	concat('DRPD', ifnull(max(substring_index(derivatives_id, 'DRPD', -1)) + 1, 0)) into return_value
from D1_DNA_RNA_Protein_Derivatives
where accession_num=acc_num;
return return_value;
end
 ;;
delimiter ;

DROP FUNCTION IF EXISTS `SF_GET_NEW_REFERENCE_ORD`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_GET_NEW_REFERENCE_ORD`(acc_num varchar(20), input_id varchar(20)) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(20);
set return_value=null;
select
	ifnull(max(ord) + 1, 0) into return_value
from E1_Reference
where accession_num=acc_num and id=input_id;
return return_value;
end
 ;;
delimiter ;




DROP FUNCTION IF EXISTS `SF_MAPPING_TAXONOMIES`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SF_MAPPING_TAXONOMIES`(scientific_name varchar(100)) RETURNS varchar(200) CHARSET utf8
    DETERMINISTIC
begin
declare return_value varchar(200);
declare tmp_val varchar(100);
set return_value='';
set tmp_val='';

		SELECT IFNULL(tax_id, '') into tmp_val
		FROM (
			SELECT
				tax_id
				, name_txt
			FROM X1_NcbiTaxonomyName
			WHERE MATCH(name_txt) AGAINST( scientific_name IN BOOLEAN MODE)
			HAVING name_txt=scientific_name
		) AA;

		IF tmp_val='' THEN
			SET return_value='empty|';
		ELSE
			SET return_value = CONCAT(tmp_val, '|');
		END IF;



		SELECT IFNULL(tax_id, '') into tmp_val
		FROM (
			SELECT
				tax_id
				, name_txt
			FROM X1_GbifTaxonomyName
			WHERE MATCH(name_txt) AGAINST( scientific_name IN BOOLEAN MODE)
			HAVING name_txt=scientific_name
		) AA;

		IF tmp_val='' THEN
			set return_value = concat(return_value, 'empty|');
		ELSE
			set return_value = concat(return_value, tmp_val, '|');
		END IF;




		SELECT IFNULL(tax_id, '') into tmp_val
		FROM (
			SELECT
				tax_id
				, name_txt
			FROM X1_ItisTaxonomyName
			WHERE MATCH(name_txt) AGAINST( scientific_name IN BOOLEAN MODE)
			HAVING name_txt=scientific_name
		) AA;

		IF tmp_val='' THEN
			set return_value = concat(return_value, 'empty|');
		ELSE
			set return_value = concat(return_value, tmp_val, '|');
		END IF;

		SELECT IFNULL(tax_id, '') into tmp_val
		FROM (
			SELECT
				tax_id
				, name_txt
			FROM X1_KobicTaxonomyName
			WHERE MATCH(name_txt) AGAINST( scientific_name IN BOOLEAN MODE)
			HAVING name_txt=scientific_name
		) AA;

		IF tmp_val='' THEN
			set return_value = concat(return_value, 'empty');
		ELSE
			set return_value = concat(return_value, tmp_val);
		END IF;

return return_value;
end
 ;;
delimiter ;


DROP FUNCTION IF EXISTS `SPLIT_STR`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `SPLIT_STR`(x VARCHAR(255), delim VARCHAR(12), pos INT) RETURNS varchar(200) CHARSET utf8
    DETERMINISTIC
begin
	RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos), LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1), delim, '');
end
 ;;
delimiter ;