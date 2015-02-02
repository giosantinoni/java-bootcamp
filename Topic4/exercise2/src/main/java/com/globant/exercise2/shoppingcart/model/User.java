package com.globant.exercise2.shoppingcart.model;

/**
 * 
 * @author martin
 *
 */
public class User {
	private int id;
	private String name;

	/**
	 * Class constructor.
	 */
	public User() {
	}

	/**
	 * Class constructor.
	 * 
	 * @param name
	 */
	public User(String name) {
		this.name = name;
	}

	/**
	 * Class constructor.
	 * 
	 * @param id
	 * @param name
	 */
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	/**
	 * Returns the name of the user.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
