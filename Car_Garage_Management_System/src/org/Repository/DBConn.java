package org.Repository;

import java.sql.*;
public class DBConn {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	public DBConn() {
	  try {
		  com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		  DriverManager.registerDriver(d);
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/car","root","Root");
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
		}
	}
}
