package com.globant.exercise2.shoppingcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.exercise2.shoppingcart.dao.IUserDAO;
import com.globant.exercise2.shoppingcart.dao.UserDAO;
import com.globant.exercise2.shoppingcart.exception.ShoppingCartException;
import com.globant.exercise2.shoppingcart.model.User;

@Service
public class UserService implements IUserService {	
	private IUserDAO userDAO = UserDAO.getInstance();

	@Override
	public void addUser(User user) {
		userDAO.add(user);
	}

	@Override
	public User getUser(int id) throws ShoppingCartException {
		User user = null;
		
		user = userDAO.get(id);
		
		if (user == null)
			throw new ShoppingCartException("User not found.");
		
		return user;
	}

	@Override
	public void updateUser(User user) throws ShoppingCartException {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setName(user.getName());		
		userDAO.update(user);
	}

	@Override
	public void deleteUser(int id) throws ShoppingCartException {
		User user = getUser(id);
		userDAO.delete(user);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getAll();
	}
}
