#!/bin/sh
# Set the root of the menumine directory
MENUMINE=~/Development/menumine-intellij/menumine599/

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
XP=$XP:$DIST/jotm.jar
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
echo "download menumine from production server" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log 
mysqldump --opt --max_allowed_packet=32M -u root -ppassword -h menumine.fsrin.com menumine | mysql -u root -ppassword --max_allowed_packet=32M menumine >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# download menumine_admin from production server
echo "download menumine_admin from production server"
echo "download menumine_admin from production server" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
mysqldump --opt --max_allowed_packet=32M -u root -ppassword -h menumine.fsrin.com menumine_admin | mysql -u root -ppassword --max_allowed_packet=32M menumine_admin >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# download flavtrak from data entry machine
echo "download flavtrak from data entry machine"
echo "download flavtrak from data entry machine" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
mysqldump -u root -ppassword -h 192.168.0.132 flavtrak | mysql -u root -ppassword flavtrak >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# Now run the make_menumine sql command works!
echo "Now run the make_menumine sql command"
echo "Now run the make_menumine sql command" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
mysql -u root -ppassword menumine < $SQL/make_menumine.sql >> daily.log

# Update the databasestructure works!
echo "Update the databasestructure"
echo "Update the databasestructure" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
java -cp $MENUMINE/WEB-INF/classes:$XP com.fsrin.menumine.produtil.UpdateDatabaseStructureCommand >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# Now the second SQL command
echo "Now the second SQL command"
echo "Now the second SQL command" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
mysql -u root -ppassword --force menumine < $SQL/make_menumine2.sql >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# and Convert emptys to nulls
echo "and Convert emptys to nulls"
echo "and Convert emptys to nulls" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
java -cp $MENUMINE/WEB-INF/classes:$XP com.fsrin.menumine.produtil.DataEmptyToNullConverterCommand >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# Construct the keywords (takes about an hour)
echo "Construct the keywords (takes about an hour)"
echo "Construct the keywords (takes about an hour)" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
java -cp $MENUMINE/WEB-INF/classes:$XP com.fsrin.menumine.produtil.KeywordBuilderCommand >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

# Send the databases back up to the server.
#echo "send menumine back to menumine.fsrin.com"
#echo "send menumine back to menumine.fsrin.com" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
#mysqldump --opt --max_allowed_packet=32M -u root -ppassword menumine | mysql -u root -ppassword --max_allowed_packet=32M -h menumine.fsrin.com menumine >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log

#echo "send menumine_admin back to menumine.fsrin.com"
#echo "send menumine_admin back to menumine.fsrin.com" >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
#mysqldump --opt --max_allowed_packet=32M -u root -ppassword menumine_admin | mysql -u root -ppassword --max_allowed_packet=32M -h menumine.fsrin.com menumine_admin >> /Users/crackintosh/Documents/workspace/menuminesvn/src/non-java/daily.log
