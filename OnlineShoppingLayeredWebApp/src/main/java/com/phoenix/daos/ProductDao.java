package com.phoenix.daos;

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.Product;

/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
public interface ProductDao {
	Product getProductbyId(int id) throws SQLException;
	List<Product> getAllProducts() throws SQLException;
	void insert(Product product) throws SQLException;
	void update(Product product) throws SQLException;
	void delete(Product product) throws SQLException;
}
