This is a Template for a MAC OSX application written in Java using JDBC and Derby for a local Database.
=======================================================================================================
You must add to your project:
-------------------------------
	* derby.jar - java build path
	* -Dderby.stream.error.field=DerbyUtil.DEV_NULL - JVM command args to disable derby log file
	* Create a derby database under app name example 
		1. $ cd Barcharts.app/Contents/
		2. $ ij
		3. ij> connect 'jdbc:derby:db;create=true';
	 
