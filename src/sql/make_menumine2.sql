alter table `menumine`.`tblmasterfood` engine = myisam;
create index mf_chainid on `menumine`.`tblmasterfood` (ChainID);
create index chain_chainid on `menumine`.`tblchain` (`1`);
create index mf_daypartcategory on `menumine`.`tblmasterfood` (DayPartCategory);
create index mf_hqregion on `menumine`.`tblmasterfood` (HQRegion);
create fulltext index mf_keywords on `menumine`.`tblmasterfood` (keywords);

update `menumine`.`tblmasterfood` join `menumine`.`tblchain` on tblmasterfood.ChainID = tblchain.`1` set
tblmasterfood.SectorName = tblchain.SectorName,
tblmasterfood.Segment = tblchain.Segment,
tblmasterfood.OperationName = tblchain.Chain,
tblmasterfood.YearPutInDatabase = tblchain.FirstYearInDatabase,
tblmasterfood.HQState = tblchain.HQState,
tblmasterfood.HQRegion = tblchain.HQRegion,
tblmasterfood.OperatorType = tblchain.OperatorType,
tblmasterfood.CountryLoc = tblchain.CountryLoc;


create index mf_marketsegment on `menumine`.`tblmasterfood` (Segment);
create index mf_marketsector on `menumine`.`tblmasterfood` (SectorName);
create index mf_menupart on `menumine`.`tblmasterfood` (GenMenuPart);
create index mf_basicprotein on `menumine`.`tblmasterfood` (BasicProtein);
create index mf_cuisineofitem on `menumine`.`tblmasterfood` (Cuisine);
create index mf_cookingmethod on `menumine`.`tblmasterfood` (CookMeth);
create index mf_operationname on `menumine`.`tblmasterfood` (OperationName);
create index mf_cuisinefamily on `menumine`.`tblmasterfood` (`Cuisine, Family`);
create index mf_gencookingmethod on `menumine`.`tblmasterfood` (GenCookMeth);
create index mf_menuitemclass on `menumine`.`tblmasterfood` (`Menu Item Class`);
create index mf_menustatus on `menumine`.`tblmasterfood` (MenuStatus);
create index mf_cakeuse on `menumine`.`tblmasterfood` (CakeUse);
create index mf_cookieuse on `menumine`.`tblmasterfood` (CookieUse);
create index mf_proteintypecut on `menumine`.`tblmasterfood` (`Protein Type/Cut`);
create index mf_proteintype on `menumine`.`tblmasterfood` (ProteinType);
create index mf_finfishspecies on `menumine`.`tblmasterfood` (`Finfish species`);
create index mf_newitembrag on `menumine`.`tblmasterfood` (NewItemBrag);
create index mf_proteinflavorapp on `menumine`.`tblmasterfood` (ProteinFlavorApp);