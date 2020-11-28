For leagues.jsp
To configure DataSource in Tomcat, go to local Tomcat directory created by Eclipse. Edit context.xml to include following:

For Oracle XE

			<Resource name="jdbc/coffeeDS" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.driver.OracleDriver"
              url="jdbc:oracle:thin:@localhost:1521:XE" 
              username="COFFEE" password="password" maxActive="20" maxIdle="10"
              maxWait="-1"/>
              
              
For JavaDB (Derby)

			<Resource name="jdbc/coffeeDS" auth="Container"
              type="javax.sql.DataSource" driverClassName="org.apache.derby.jdbc.ClientDriver"
              url="jdbc:derby://localhost:1527/COFFEE;create=true" 
              username="app" password="password" maxActive="20" maxIdle="10"
              maxWait="-1"/>

In the application, create context.xml under META-INF directory of the application, as shown below that would have the data source definition and just
put the definitions code defined before into that file. 
(When I  put that code into Tomcat's local context.xml file the definition is kept deleted.)

<?xml version="1.0" encoding="UTF-8"?>

<Context>

<Resource name="jdbc/coffeeDS" auth="Container"
              type="javax.sql.DataSource" driverClassName="org.apache.derby.jdbc.ClientDriver"
              url="jdbc:derby://localhost:1527/Coffee" 
              username="app" password="password" maxActive="20" maxIdle="10"
              maxWait="-1"/>
              
</Context>


I mean local as the directory created for local Tomcat installation by Eclipse.
              
And in web.xml following should exist:

  <resource-ref>
    <description>
      This defines a JNDI resource reference for
      java:comp/env/jdbc/coffeeDS DataSource which
      is formally declared in the domain.xml.
    </description>
    <res-ref-name>jdbc/coffeeDB</res-ref-name>
    <res-type>javax.sql.DataSource</res-type>
    <res-auth>Container</res-auth>
  </resource-ref>
  
And dont forget to include the jar file for the driver in Tomcat lib directory. 
(Or create a directory named "endorsed" under Tomcat installation directory and
add following 

,/lib/*.jar",${catalina.home}/endorsed/*.jar"

to the end of 

common.loader="${catalina.base}/lib","${catalina.base}/lib/*.jar","${catalina.home}/lib","${catalina.home}/lib/*.jar"

in the file called catalina.properties under conf directory. But I am not sure this works correctly!)



Then create following table and insert rows into it.

CREATE TABLE League (
   LID             INTEGER        PRIMARY KEY,   -- League's object ID
   "year"            INTEGER        NOT NULL,      -- year of league
   season          VARCHAR(10)    NOT NULL,      -- season: Spring/Summer/Fall
   title           VARCHAR(30)    NOT NULL       -- the title of the league
)

INSERT INTO League (LID, "year", season, title)
  VALUES (1, 2003, 'Spring', 'Soccer League (Spring ''03)');
INSERT INTO League (LID, "year", season, title)
  VALUES (2, 2003, 'Summer', 'Summer Soccer Fest 2003');
INSERT INTO League (LID, "year", season, title)
  VALUES (3, 2003, 'Fall', 'Fall Soccer League (2003)');
INSERT INTO League (LID, "year", season, title)
  VALUES (4, 2004, 'Spring', 'Soccer League (Spring ''04)');
INSERT INTO League (LID, "year", season, title)
  VALUES (5, 2004, 'Summer', 'The Summer of Soccer Love 2004');
INSERT INTO League (LID, "year", season, title)
  VALUES (6, 2004, 'Fall', 'Fall Soccer League (2004)');
  
  create table COFFEES(
	COF_NAME VARCHAR(32) NOT NULL PRIMARY KEY,
    SUP_ID INTEGER,
    PRICE NUMERIC(5, 2),
	SALES INTEGER,
    TOTAL NUMERIC(5, 2)
);

INSERT INTO COFFEES VALUES ('Columbian', 101, 7.99, 0, 0);
INSERT INTO COFFEES VALUES ('French_Roast', 49, 8.99, 0, 0);
INSERT INTO COFFEES VALUES ('Espresso', 150, 9.99, 0, 0);
INSERT INTO COFFEES VALUES ('Colombian_Decaf', 101, 8.99, 0, 0);
INSERT INTO COFFEES VALUES ('French_Roast_Decaf', 49, 9.99, 0, 0);
INSERT INTO COFFEES VALUES ('Turkish', 49, 10.99, 0, 0);
  
  