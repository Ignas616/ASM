ASM
===

Asset Management System

Requirements: jetty8, jdk1.6+, pgsql, PG_admin, maven, git, windows

SETUP inviroment

Jetty instalation.
1) Download jetty 8 from here
http://dist.codehaus.org/jetty/jetty-hightide-8.1.9/jetty-hightide-8.1.9.v20130131.zip
2) Unpack it. In future the path to this folder will be called JETTY_HOME


JDK Instalation
1) Download JDK here
http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
2)Install it
3) Make sure you have JAVA_HOME enviremental variable set up and pointing to installed JDK folder
4) Make sure you have the JAVA_HOME/bin in the PATH enviremental variables


pgsql installation
1) Download and install
http://www.enterprisedb.com/products-services-training/pgdownload


PG admin
1) Download and install
http://ftp.postgresql.org/pub/pgadmin3/release/v1.16.1/win32/pgadmin3-1.16.1.zip


Maven
1) Download and unpack
http://maven.apache.org/download.cgi
2) Make sure you have M2_HOME enviremental variable set up and pointing to the maven unpacked folder


Git 
1) Download and instal git
http://git-scm.com/downloads


Downloading the ASM project
1)Go to your development tool
2)Import the ASM project as maven project from gitHub. Or download as usual and then convert it to maven
GItHub link:
https://github.com/Ignas616/ASM.git


Creating DB.
1) Open pgadmin
2) Go to sql execution 
3) Import and run as skript the following file : 
src/main/resources/asmdatabase.sql
4) NB! IMPORTANT
Switch databases to newly create asm database
5) Import and run as skript the following file : 
src/main/resources/asmdatadump.sql


Making war for asm project.
1) To get the asm project war either download the created project here
http://www.mediafire.com/download.php?205c753php8935v
Or do the maven clean and then maven install

Setting up the war
1) Copy the newly created asm.war to the JETTY_HOME/webapps folder
2) go back to jetty home and launch the jetty server with the command
java - jar start.jar
3) Open browser and check that the http://localhost:8080/asm link works
