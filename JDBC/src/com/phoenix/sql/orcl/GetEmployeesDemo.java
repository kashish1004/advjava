package com.phoenix.sql.orcl;
import java.io.FileNotFoundException;
import java.io.IOException;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.phoenix.dbconfig.OracleConnection;

public class GetEmployeesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = OracleConnection.getOracleConnection();
			String sql = "select * from employees";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int empId = rs.getInt(1);
				String firstName = rs.getString(2);
				float salary = rs.getFloat(8);
				System.out.println("Employee Id: "+ empId+
									"\tName: "+ firstName+
									"\tSalary: "+salary);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
