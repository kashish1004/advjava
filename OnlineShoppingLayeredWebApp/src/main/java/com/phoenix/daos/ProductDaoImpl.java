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
import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.db.OracleConnection;

public class ProductDaoImpl implements ProductDao {
	
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
	public Product getProductbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select name,brand,price from products where id =  ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			Product product = new Product();
			product.setName(rs.getString(1));
			product.setBrand(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			return product;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from products";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setBrand(rs.getString(3));
			product.setPrice(rs.getFloat(4));
			list.add(product);
		}
		return list;
	}
	
	@Override
	public void insert(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into products values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		stmt.setString(2, product.getName());
		stmt.setString(3, product.getBrand());
		stmt.setFloat(4, product.getPrice());
		int updatedRows = stmt.executeUpdate();
		if(updatedRows>0) {
			System.out.println("New Product inserted successfully");
		}
		else {
			System.out.println("Sorry! New product cannot be inserted");
		}
	}

	@Override
	public void update(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update products set name = ?,brand = ?,price = ? where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, product.getName());
		stmt.setString(2, product.getBrand());
		stmt.setFloat(3, product.getPrice());
		stmt.setInt(4, product.getId());
		int updatedRows = stmt.executeUpdate();
		if(updatedRows>0) {
			System.out.println("Product info updated successfully");
		}
		else {
			System.out.println("Sorry! product cannot be updated");
		}
	}

	@Override
	public void delete(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from products where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		int updatedRows = stmt.executeUpdate();
		if(updatedRows>0) {
			System.out.println("Product deleted successfully");
		}
		else {
			System.out.println("Product cannot be deleted");
		}
	}
}