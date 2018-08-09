
Output destination of Alpha-Build.war specified in pom.xml.
Runing on apache-tomEE-plus-7.05
On MYSQL 8, database name: jpadb with Legacy authentication method

In tomee/conf/tomee.xml
	<Resource id="MySQL Database" type="DataSource">
    #  MySQL example
    #
    #  This connector will not work until you download the driver at:
    #  http://www.mysql.com/downloads/api-jdbc-stable.html
    JdbcDriver  com.mysql.jdbc.Driver
    JdbcUrl jdbc:mysql://localhost:3306/jpadb
    UserName    root
    Password TooMuchSwag69
	</Resource>