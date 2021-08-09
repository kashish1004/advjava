package com.phoenix.db;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	public static Connection getConnection(String jdbcDriver,String jdbcUrl,String username,String password) throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
}
