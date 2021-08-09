package com.phoenix.sql.orcl;
import java.io.FileNotFoundException;
import java.io.IOException;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.phoenix.dbconfig.OracleConnection;

public class UpdateProductPriceProcDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = OracleConnection.getOracleConnection();
			CallableStatement cs = con.prepareCall("{call update_price(?,?)}");
			cs.setInt(1, 104);
			cs.setFloat(2, 1000.00f);
			cs.execute();
			System.out.println("PL/SQL Stored Procedure Executed Successfully");
			
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