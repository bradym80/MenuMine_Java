tblchainalesdecimal2doubles.sql
salesdecimal2doubles.sql
/* Because the name of our database is changed all the time, in order to use this query, you must select which database you want on the command line when running this script. i.e. mysql -u root -p menumine_10_08_07_admin < tblchainsalesdecimal2doubles.sql */
ALTER TABLE `tblchain` CHANGE `Sales2006` `Sales2006` DOUBLE NULL DEFAULT NULL, CHANGE `Sales2005` `Sales2005` DOUBLE NULL DEFAULT NULL, CHANGE `Sales2004` `Sales2004` DOUBLE NULL DEFAULT NULL, CHANGE `Sales2003` `Sales2003` DOUBLE NULL DEFAULT NULL