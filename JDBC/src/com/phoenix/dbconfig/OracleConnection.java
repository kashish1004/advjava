package com.phoenix.dbconfig;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection {
		public static Connection getOracleConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
			/*
			 * String jdbcDriver = "oracle.jdbc.driver.OracleDriver"; String jdbcUrl
			 * ="jdbc:oracle:thin:@localhost:1521:XE"; String username = "hr"; String
			 * password = "hr";
			 */
			Properties props = new Properties();
			props.load(new FileReader("dbConfig.properties"));
			String jdbcDriver = props.getProperty("driver");
			String jdbcUrl = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			return DatabaseConfig.getConnection(jdbcDriver, jdbcUrl, username, password);
		}
	}