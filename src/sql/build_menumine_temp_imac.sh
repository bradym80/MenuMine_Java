#!/bin/sh
# Set the root of the menumine directory
MENUMINE=~/Documents/workspace/menumine

# Location of SQL
SQL=$MENUMINE/src/sql

# Now the location of the libraries
DIST=$MENUMINE/lib/dist

# Set the classpath
XP=
XP=$XP:$DIST/activation.jar
XP=$XP:$DIST/ant-1.5.3.jar
XP=$XP:$DIST/ant-optional-1.5.3.jar
XP=$XP:$DIST/antlr.jar
XP=$XP:$DIST/asm-1.5.3.jar
XP=$XP:$DIST/batik-awt-util.jar
XP=$XP:$DIST/batik-dom.jar
XP=$XP:$DIST/batik-svggen.jar
XP=$XP:$DIST/batik-util.jar
XP=$XP:$DIST/batik-xml.jar
XP=$XP:$DIST/c3p0-0.9.0.2.jar
XP=$XP:$DIST/cewolf.jar
XP=$XP:$DIST/cglib-2.1_3.jar
XP=$XP:$DIST/commons-attributes-api.jar
XP=$XP:$DIST/commons-attributes-compiler.jar
XP=$XP:$DIST/commons-beanutils.jar
XP=$XP:$DIST/commons-collections.jar
XP=$XP:$DIST/commons-dbcp.jar
XP=$XP:$DIST/commons-digester.jar
XP=$XP:$DIST/commons-fileupload.jar
XP=$XP:$DIST/commons-lang-2.1.jar
XP=$XP:$DIST/commons-logging.jar
XP=$XP:$DIST/commons-pool.jar
XP=$XP:$DIST/concurrent-1.3.3.jar
XP=$XP:$DIST/connector-api.jar
XP=$XP:$DIST/connector.jar
XP=$XP:$DIST/cos-multipart.jar
XP=$XP:$DIST/crimson.jar
XP=$XP:$DIST/dom4j.jar
XP=$XP:$DIST/ehcache-0.9.jar
XP=$XP:$DIST/fivesticks-dates-2005-12-17.jar
XP=$XP:$DIST/fivesticks-messages.jar
XP=$XP:$DIST/freemarker.jar
XP=$XP:$DIST/hibernate3.jar
XP=$XP:$DIST/itext-1.02b.jar
XP=$XP:$DIST/jaas.jar
XP=$XP:$DIST/jai_codec.jar
XP=$XP:$DIST/jai_core.jar
XP=$XP:$DIST/jai_imageio.jar
XP=$XP:$DIST/jakarta-oro.jar
XP=$XP:$DIST/jasperreports-0.6.1.jar
XP=$XP:$DIST/jaxp.jar
XP=$XP:$DIST/jcommon-1.0.0.jar
XP=$XP:$DIST/jcs-1.0-dev.jar
XP=$XP:$DIST/jdbc2_0-stdext.jar
XP=$XP:$DIST/jdom.jar
XP=$XP:$DIST/jfreechart-1.0.1.jar
XP=$XP:$DIST/jgroups-2.2.3.jar
XP=$XP:$DIST/jmock-1.0.1.jar
XP=$XP:$DIST/jmock-cglib-1.0.1.jar
XP=$XP:$DIST/jotm.jarpr
XP=$XP:$DIST/jta.jar
XP=$XP:$DIST/junit.jar
XP=$XP:$DIST/log4j-1.2.8.jar
XP=$XP:$DIST/mail.jar
XP=$XP:$DIST/mysql-connector-java-3.1.7-bin.jar
XP=$XP:$DIST/odmg-3.0.jar
XP=$XP:$DIST/ognl.jar
XP=$XP:$DIST/oscache-2.0.jar
XP=$XP:$DIST/oscore.jar
XP=$XP:$DIST/pell-multipart.jar
XP=$XP:$DIST/poi-2.5.1-final-20040804.jar
XP=$XP:$DIST/proxool-0.8.3.jar
XP=$XP:$DIST/quartz.jar
XP=$XP:$DIST/rome-0.6.jar
XP=$XP:$DIST/sitemesh-fstx-2004-05-12.jar
XP=$XP:$DIST/spring-1.2.6.jar
XP=$XP:$DIST/spring-aop-1.2.6.jar
XP=$XP:$DIST/spring-beans-1.2.6.jar
XP=$XP:$DIST/spring-context-1.2.6.jar
XP=$XP:$DIST/spring-core-1.2.6.jar
XP=$XP:$DIST/spring-dao-1.2.6.jar
XP=$XP:$DIST/spring-hibernate-1.2.6.jar
XP=$XP:$DIST/spring-jdbc-1.2.6.jar
XP=$XP:$DIST/spring-mock-1.2.6.jar
XP=$XP:$DIST/spring-orm-1.2.6.jar
XP=$XP:$DIST/spring-remoting-1.2.6.jar
XP=$XP:$DIST/spring-support-1.2.6.jar
XP=$XP:$DIST/spring-web-1.2.6.jar
XP=$XP:$DIST/spring-webmvc-1.2.6.jar
XP=$XP:$DIST/spring-xwork-integration.jar
XP=$XP:$DIST/swarmcache-1.0rc2.jar
XP=$XP:$DIST/velocity-1.4.jar
XP=$XP:$DIST/velocity-dep.jar
XP=$XP:$DIST/velocity-tools-generic-1.1.jar
XP=$XP:$DIST/webwork-fsrin-2.1.7.jar
XP=$XP:$DIST/xalan-2.4.0.jar
XP=$XP:$DIST/xapool.jar
XP=$XP:$DIST/xerces-2.4.0.jar
XP=$XP:$DIST/xml-apis.jar
XP=$XP:$DIST/xwork-1.0.5.jar

# download menumine from production server GOOD!
echo "download menumine from production server"
mysqldump --opt --max_allowed_packet=64M -u root -ppassword -h menumine.fsrin.com menumine | mysql -u root -ppassword menumine

# download menumine_admin from production server
echo "download menumine_admin from production server"
mysqldump --opt --max_allowed_packet=64M -u root -ppassword -h menumine.fsrin.com menumine_admin | mysql -u root -ppassword menumine_admin

# backup the database locally
echo "backup the database locally"
mysqldump -u root -ppassword --databases menumine menumine_admin > /Users/bradym80/Dropbox/Databases/menumine_backup_$(date +%m%d%Y).sql

# download flavtrak from data entry machine
echo "download flavtrak from data entry machine"
mysqldump -u root -ppassword -h office.fsrin.com flavtrak | mysql -u root -ppassword flavtrak

# download 07 from data entry machine
echo "download 07 from data entry machine"
mysqldump -u root -ppassword -h office.fsrin.com 07 | mysql -u root -ppassword 07

# Now run the make_menumine sql command works!
echo "Now run the make_menumine sql command"
mysql -u root -ppassword menumine < $SQL/make_menumine.sql >> daily.log

# Update the databasestructure works!
echo "Update the databasestructure"
java -cp $MENUMINE/WEB-INF/classes:$XP com.fsrin.menumine.produtil.UpdateDatabaseStructureCommand

# Now the second SQL command
echo "Now the second SQL command"
mysql -u root -ppassword --force menumine < $SQL/make_menumine2.sql

# and Convert emptys to nullsze
echo "and Convert emptys to nulls"
java -cp $MENUMINE/WEB-INF/classes:$XP com.fsrin.menumine.produtil.DataEmptyToNullConverterCommand

# Construct the keywords (takes about an hour)
echo "Construct the keywords (takes about an hour)"
java -cp $MENUMINE/WEB-INF/classes:$XP com.fsrin.menumine.produtil.KeywordBuilderCommand

# dump menumine to /Users/bradym80/menumine.sql
echo "dump menumine"
mysqldump -u root -ppassword --databases menumine menumine_admin > /Users/bradym80/menumine.sql

# Send the databases back up to the server.
#echo "send menumine back to menumine.fsrin.com"
#mysql -u root -ppassword -h menumine.fsrin.com < /Users/bradym80/menumine.sql

# Mission comprete!
echo "DONE!"