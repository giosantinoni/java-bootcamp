/**
 * 
 */
package com.globant.exercise2.shoppingcart.services;

import java.util.List;

import com.globant.exercise2.shoppingcart.exception.ShoppingCartException;
import com.globant.exercise2.shoppingcart.model.User;

/**
 * @author martin
 *
 */
public interface IUserService {
	void addUser(User user);
	
	User getUser(int id) throws ShoppingCartException;
	
	void updateUser(User user) throws ShoppingCartException;
	
	void deleteUser(int id) throws ShoppingCartException;
	
	List<User> getUsers();
}
