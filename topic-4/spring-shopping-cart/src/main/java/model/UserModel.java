package model;

import java.util.HashMap;
import java.util.Map;

import bootcamp.*;

public class UserModel {
	private Map<String, User> users;

	public UserModel() {
		users = new HashMap<String, User>();
	}

	public void add(User user) {
		users.put(user.getUserName(), user);
	}
	
	public void update(User user) {
		users.put(user.getUserName(), user);
	}
	
	public void delete (User user) {
		users.remove(user.getUserName());
	}
	
	public User get(String userName) {
		return users.get(userName);
	}
}
