package com.globant.exercise2.shoppingcart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globant.exercise2.shoppingcart.factory.IdFactory;
import com.globant.exercise2.shoppingcart.model.User;

public class UserDAO implements IUserDAO {
	private static final UserDAO instance = new UserDAO();
	private Map<Integer, User> users;
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	private UserDAO() {
		users = new HashMap<Integer, User>();
	}

	public void add(User user) {
		int id = IdFactory.getId("User");
		users.put(id, user);
	}

	public User get(int id) {		
		return users.get(id);
	}

	public void update(User user) {
		users.put(user.getId(), user);
	}

	public void delete(User user) {
		users.remove(user.getId());
	}

	public List<User> getAll() {		
		return (List<User>) users.values();
	}
}
