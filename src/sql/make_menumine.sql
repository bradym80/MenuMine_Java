/*use this script to create a new database for menumine.*/

/*this moves tblmasterfood into menumine*/
DROP TABLE IF EXISTS `menumine`.`tblmasterfood`;
CREATE TABLE `menumine`.`tblmasterfood` LIKE `flavtrak`.`tblmasterfood`;
INSERT INTO `menumine`.`tblmasterfood` SELECT * FROM `flavtrak`.`tblmasterfood`;


/* This changes the field names so they work properly with MenuMine */
ALTER TABLE `menumine`.`tblmasterfood`
CHANGE `Protein Type_Cut` `Protein Type/Cut` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Batter_Breading_Coating` `Batter/Breading/Coating` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Bread_Wrap_Chips` `Bread/Wrap/Chips` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Cheese_CheeseSauceFillingType` `Cheese/CheeseSauceFillingType` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Side_AccompDishFlavor` `Side/AccompDishFlavor` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Syrup_Topping` `Syrup/Topping` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Hot_Cold Cereal` `Hot/Cold Cereal` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `OtherTop_Ingred` `OtherTop/Ingred` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
CHANGE `Top_Fill_IngredMM` `Top/Fill/IngredMM` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL;

/*This moves tblchain into menumine */

DROP TABLE IF EXISTS `menumine`.`tblchain`;
CREATE TABLE `menumine`.`tblchain` LIKE `07`.`tblchain`; 
INSERT INTO `menumine`.`tblchain` SELECT * FROM `07`.`tblchain`;

/*This inserts tblstatelocation into menumine */

DROP TABLE IF EXISTS `menumine`.`tblstatelocation`;
CREATE TABLE `menumine`.`tblstatelocation` LIKE `07`.`tblstatelocation`;
INSERT INTO `menumine`.`tblstatelocation` SELECT * FROM `07`.`tblstatelocation`;

/* This erases all the indexes on tblmasterfood, tblchain and tblstatelocation when imported from flavtrak. 
Not sure if this is necessary, check on IRC, fix sql and comment once completed. Ask this: on line 153 of 
this script http://pastebin.com/d2e94b9b if I remove lines 154 to 157, will it mess up the copy? 
should I add a line later that removes those keys instead? */

ALTER TABLE  `menumine`.`tblmasterfood` DROP INDEX  `ID`;
ALTER TABLE  `menumine`.`tblmasterfood` DROP INDEX  `Chain`;
ALTER TABLE  `menumine`.`tblmasterfood` DROP INDEX  `ChainID`;
ALTER TABLE  `menumine`.`tblmasterfood` DROP INDEX  `DayPartCategory`;
ALTER TABLE  `menumine`.`tblchain` DROP INDEX `Chain`;
ALTER TABLE  `menumine`.`tblchain` DROP INDEX `ChainSegment`;
ALTER TABLE  `menumine`.`tblchain` DROP INDEX `ID`;
ALTER TABLE  `menumine`.`tblchain` DROP INDEX `RiMagSalesVol`;
ALTER TABLE  `menumine`.`tblchain` DROP INDEX `SectorName`;
ALTER TABLE  `menumine`.`tblchain` DROP INDEX `StatePickUpArea`;
ALTER TABLE  `menumine`.`tblstatelocation` DROP INDEX `ID`;
ALTER TABLE  `menumine`.`tblstatelocation` DROP INDEX `IDnumber`;

/* This changes all decimal fields to double in tblmasterfood */
ALTER TABLE  `menumine`.`tblmasterfood` CHANGE  `'96 Price`  `'96 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `'97 Price`  `'97 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `'98 Price`  `'98 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `'99 Price`  `'99 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2000 Price`  `2000 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2001 Price`  `2001 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2002 Price`  `2002 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2003 Price`  `2003 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2004 Price`  `2004 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2005 Price`  `2005 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2006 Price`  `2006 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2007 Price`  `2007 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2008 Price`  `2008 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2009 Price`  `2009 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2010 Price`  `2010 Price` DOUBLE NULL DEFAULT NULL ,
CHANGE  `2011 Price`  `2011 Price` DOUBLE NULL DEFAULT NULL;


/* This changes all decimal fields to double in tblchain */
ALTER TABLE  `menumine`.`tblchain`
CHANGE  `Sales2008`  `Sales2008` DOUBLE NULL DEFAULT NULL ,
CHANGE  `Sales2007`  `Sales2007` DOUBLE NULL DEFAULT NULL ,
CHANGE  `Sales2006`  `Sales2006` DOUBLE NULL DEFAULT NULL ,
CHANGE  `Sales2005`  `Sales2005` DOUBLE NULL DEFAULT NULL ,
CHANGE  `Sales2004`  `Sales2004` DOUBLE NULL DEFAULT NULL ,
CHANGE  `Sales2003`  `Sales2003` DOUBLE NULL DEFAULT NULL ;

/* These do not have proper character length when moved over from flavtrak */
ALTER TABLE  `menumine`.`tblmasterfood` CHANGE  `Segment`  `Segment` VARCHAR( 255 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL;

ALTER TABLE `tblmasterfood` ADD `SectorName` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  AFTER `ChainID`;
ALTER TABLE `tblmasterfood` ADD `OperationName` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  AFTER `ChainID`;
ALTER TABLE `tblmasterfood` ADD `YearPutInDatabase` INTEGER(10)  AFTER `ChainID`;
ALTER TABLE `tblmasterfood` ADD `HQState` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  AFTER `ChainID`;
ALTER TABLE `tblmasterfood` ADD `HQRegion` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  AFTER `ChainID`;
ALTER TABLE `tblmasterfood` ADD `OperatorType` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  AFTER `ChainID`;
ALTER TABLE `tblmasterfood` ADD `CountryLoc` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci  AFTER `ChainID`;

