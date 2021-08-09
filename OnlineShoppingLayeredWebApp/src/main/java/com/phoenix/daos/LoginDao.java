package com.phoenix.daos;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.SQLException;
import java.util.List;
import com.phoenix.data.User;

public interface LoginDao {
	User getUserbyId(String username) throws SQLException;
	List<User> getAllUsers() throws SQLException;
	void insert(User user) throws SQLException;
	void update(User user) throws SQLException;
	void delete(User user) throws SQLException;
}