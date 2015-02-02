package com.globant.exercise2.shoppingcart.dao;

import java.util.List;

import com.globant.exercise2.shoppingcart.model.User;

public interface IUserDAO {

	void add(User user);

	User get(int id);

	void update(User user);

	void delete(User user);

	List<User> getAll();

}
