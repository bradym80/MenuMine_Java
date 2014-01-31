//2006-08-02 reid@fivesticks.com hibernate should take care of these.

alter table tblmasterfood add column SectorName varchar(255);
alter table tblmasterfood add column Segment varchar(255);
alter table tblmasterfood add column OperationName varchar(255);
alter table tblmasterfood add column YearPutInDatabase integer;
alter table tblmasterfood add column HQState varchar(255);
alter table tblmasterfood add column HQRegion varchar(255);
alter table tblmasterfood add column OperatorType varchar(255);
alter table tblmasterfood add column CountryLoc varchar(255);

//stop

alter table tblmasterfood engine = myisam;

alter table tblmasterfood add primary key (ID);

create index mf_chainid on tblmasterfood (ChainID);

create index chain_chainid on tblchain (`1`);

create index mf_daypartcategory on tblmasterfood (DayPartCategory);

create index mf_hqregion on tblmasterfood (HQRegion);

create fulltext index mf_keywords on tblmasterfood (keywords);
 
update tblmasterfood join tblchain on tblmasterfood.ChainID = tblchain.`1` set
tblmasterfood.SectorName = tblchain.SectorName,
tblmasterfood.Segment = tblchain.Segment,
tblmasterfood.OperationName = tblchain.Chain,
tblmasterfood.YearPutInDatabase = tblchain.FirstYearInDatabase,
tblmasterfood.HQState = tblchain.HQState,
tblmasterfood.HQRegion = tblchain.HQRegion,
tblmasterfood.OperatorType = tblchain.OperatorType,
tblmasterfood.CountryLoc = tblchain.CountryLoc;

//indexes



create index mf_marketsegment on tblmasterfood (Segment);
create index mf_marketsector on tblmasterfood (SectorName);
create index mf_menupart on tblmasterfood (GenMenuPart);
create index mf_basicprotein on tblmasterfood (BasicProtein);


create index mf_cuisineofitem on tblmasterfood (Cuisine);
create index mf_cookingmethod on tblmasterfood (CookMeth);
create index mf_operationname on tblmasterfood (OperationName);
create index mf_cuisinefamily on tblmasterfood (`Cuisine, Family`);
create index mf_gencookingmethod on tblmasterfood (GenCookMeth);
create index mf_menuitemclass on tblmasterfood (`Menu Item Class`);
create index mf_menustatus on tblmasterfood (MenuStatus);
create index mf_cakeuse on tblmasterfood (CakeUse);
create index mf_cookieuse on tblmasterfood (CookieUse);

create index mf_proteintypecut on tblmasterfood (`Protein Type/Cut`);
create index mf_proteintype on tblmasterfood (ProteinType);
create index mf_finfishspecies on tblmasterfood (`Finfish species`);
create index mf_newitembrag on tblmasterfood (NewItemBrag);
create index mf_proteinflavorapp on tblmasterfood (ProteinFlavorApp);



