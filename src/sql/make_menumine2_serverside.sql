--Runs preparation script 2 on prep databases
alter table `menumine_databaseprep`.`tblmasterfood` engine = myisam;
create index mf_chainid on `menumine_databaseprep`.`tblmasterfood` (ChainID);
create index chain_chainid on `menumine_databaseprep`.`tblchain` (`1`);
create index mf_daypartcategory on `menumine_databaseprep`.`tblmasterfood` (DayPartCategory);
create index mf_hqregion on `menumine_databaseprep`.`tblmasterfood` (HQRegion);
create fulltext index mf_keywords on `menumine_databaseprep`.`tblmasterfood` (keywords);

update `menumine_databaseprep`.`tblmasterfood` join `menumine_databaseprep`.`tblchain` on tblmasterfood.ChainID = tblchain.`1` set
tblmasterfood.SectorName = tblchain.SectorName,
tblmasterfood.Segment = tblchain.Segment,
tblmasterfood.OperationName = tblchain.Chain,
tblmasterfood.YearPutInDatabase = tblchain.FirstYearInDatabase,
tblmasterfood.HQState = tblchain.HQState,
tblmasterfood.HQRegion = tblchain.HQRegion,
tblmasterfood.OperatorType = tblchain.OperatorType,
tblmasterfood.CountryLoc = tblchain.CountryLoc;


create index mf_marketsegment on `menumine_databaseprep`.`tblmasterfood` (Segment);
create index mf_marketsector on `menumine_databaseprep`.`tblmasterfood` (SectorName);
create index mf_menupart on `menumine_databaseprep`.`tblmasterfood` (GenMenuPart);
create index mf_basicprotein on `menumine_databaseprep`.`tblmasterfood` (BasicProtein);
create index mf_cuisineofitem on `menumine_databaseprep`.`tblmasterfood` (Cuisine);
create index mf_cookingmethod on `menumine_databaseprep`.`tblmasterfood` (CookMeth);
create index mf_operationname on `menumine_databaseprep`.`tblmasterfood` (OperationName);
create index mf_cuisinefamily on `menumine_databaseprep`.`tblmasterfood` (`Cuisine, Family`);
create index mf_gencookingmethod on `menumine_databaseprep`.`tblmasterfood` (GenCookMeth);
create index mf_menuitemclass on `menumine_databaseprep`.`tblmasterfood` (`Menu Item Class`);
create index mf_menustatus on `menumine_databaseprep`.`tblmasterfood` (MenuStatus);
create index mf_cakeuse on `menumine_databaseprep`.`tblmasterfood` (CakeUse);
create index mf_cookieuse on `menumine_databaseprep`.`tblmasterfood` (CookieUse);
create index mf_proteintypecut on `menumine_databaseprep`.`tblmasterfood` (`Protein Type/Cut`);
create index mf_proteintype on `menumine_databaseprep`.`tblmasterfood` (ProteinType);
create index mf_finfishspecies on `menumine_databaseprep`.`tblmasterfood` (`Finfish species`);
create index mf_newitembrag on `menumine_databaseprep`.`tblmasterfood` (NewItemBrag);
create index mf_proteinflavorapp on `menumine_databaseprep`.`tblmasterfood` (ProteinFlavorApp);