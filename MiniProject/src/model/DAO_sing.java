package model;

import java.sql.DriverManager;

public class DAO_sing {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	String url = "jdbc:oracle:thin:@gjaischool-b.ddns.net:1525:xe";
	String user = "system";
	String password = "12345";
	
	conn = DriverManager.getConnection(url, user, password);   
	
	
	
}
