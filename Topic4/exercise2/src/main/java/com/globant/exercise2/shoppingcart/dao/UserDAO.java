package com.globant.exercise2.shoppingcart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globant.exercise2.shoppingcart.exception.ShoppingCartException;
import com.globant.exercise2.shoppingcart.factory.IdFactory;
import com.globant.exercise2.shoppingcart.model.User;
import com.globant.exercise2.shoppingcart.services.IUserService;

public class UserDAO implements IUserDAO {
	private static final IUserDAO instance = new UserDAO();
	private Map<Integer, User> users;
	
	public static IUserDAO getInstance() {
		return instance;
	}
	
	private UserDAO() {
		users = new HashMap<Integer, User>();
	}

	@Override
	public void add(User user) {
		int id = IdFactory.getId("User");
		users.put(id, user);
	}

	@Override
	public User get(int id) {		
		return users.get(id);
	}

	@Override
	public void update(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public void delete(User user) {
		users.remove(user.getId());
	}

	@Override
	public List<User> getAll() {		
		return (List<User>) users.values();
	}
}
