package com.phoenix.sql.orcl;
import java.io.FileNotFoundException;
import java.io.IOException;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.phoenix.dbconfig.OracleConnection;

public class AddProductDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = OracleConnection.getOracleConnection();
			String sql = "insert into products (id,name,brand,price) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 108);
			ps.setString(2, "Laptop");
			ps.setString(3, "Acer");
			ps.setFloat(4,50000.00f);
			int updateCount = ps.executeUpdate();
			if(updateCount>0)
				System.out.println("New Product added successfully");
			else
				System.out.println("Sorry! product could not be added");
			
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

