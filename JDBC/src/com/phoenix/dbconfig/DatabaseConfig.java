package com.phoenix.dbconfig;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	public static Connection getConnection(String jdbcDriver,String jdbcUrl,String username,String password) throws ClassNotFoundException, SQLException {
		//step 1 loading class 
		Class.forName(jdbcDriver);
		System.out.println("Class Loaded");
		//step 2 establishing connection
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
}