package com.phoenix.db;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.SQLException;

public class OracleConnection {
		public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
			String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
			String jdbcUrl ="jdbc:oracle:thin:@localhost:1521:XE";
			String username = "hr";
			String password = "hr";
			return DBConfig.getConnection(jdbcDriver, jdbcUrl, username, password);
		}
	}

