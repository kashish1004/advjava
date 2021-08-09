package com.phoenix.services;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.sql.SQLException;
import java.util.List;
import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;
import com.phoenix.web.exceptions.ServiceException;
import com.phoenix.web.exceptions.UserAlreadyExistException;
import com.phoenix.web.exceptions.UserNotFoundException;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
		loginDao = new LoginDaoImpl();
	}
	
	@Override
	public List<User> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return loginDao.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public User findUserById(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			return loginDao.getUserbyId(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException(e.getMessage());
		}
	}

	@Override
	public void add(User user) throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			loginDao.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserAlreadyExistException(e.getMessage());
		}
	}

	@Override
	public void edit(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			loginDao .update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void remove(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			loginDao.delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public String changePassword(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			loginDao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Password is changed";
	}

}
