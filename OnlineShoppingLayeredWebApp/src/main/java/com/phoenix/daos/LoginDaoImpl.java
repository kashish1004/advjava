package com.phoenix.daos;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.util.List;

import com.phoenix.data.User;
import com.phoenix.db.OracleConnection;

public class LoginDaoImpl implements LoginDao {
	
	private static Connection con;
	static {
		try {
			con = OracleConnection.getOracleConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User getUserbyId(String username) throws SQLException {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select username,password from login where username =  ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() throws SQLException{
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		String sql = "select * from login";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			list.add(user);
		}
		return list;
	}

	@Override
	public void insert(User user) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "insert into login(username,password) values(?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		int updatedRows = stmt.executeUpdate();
		if(updatedRows>0) {
			System.out.println("New User inserted successfully");
		}
		else {
			System.out.println("Sorry! New user cannot be inserted");
		}
		
	}
	
	@Override
	public void update(User user) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "update login set password = ? where username = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getPassword());
		stmt.setString(2, user.getUsername());
		int updatedRows = stmt.executeUpdate();
		if(updatedRows>0) {
			System.out.println("User info updated successfully");
		}
		else {
			System.out.println("Sorry! user cannot be updated");
		}
	}


	@Override
	public void delete(User user) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "delete from login where username = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getUsername());
		int updatedRows = stmt.executeUpdate();
		if(updatedRows>0) {
			System.out.println("User info deleted successfully");
		}
		else {
			System.out.println("User cannot be deleted");
		}
	}
}

