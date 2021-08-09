package com.phoenix.sql;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.SQLException;
import com.phoenix.dbconfig.DatabaseConfig;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl ="jdbc:oracle:thin:@localhost:1521:XE";
		String username = "hr";
		String password = "hr";
		try {
			DatabaseConfig.getConnection(jdbcDriver, jdbcUrl, username, password);
			System.out.println("Connection established");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
