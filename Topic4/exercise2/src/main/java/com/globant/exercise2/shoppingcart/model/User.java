package com.globant.exercise2.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author martin
 *
 */
public class User {
	private int id;
	private String name;
	private Set<Photo> photos = new HashSet<Photo>();
	private Set<User> friends = new HashSet<User>();

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
	
	public void addPhoto(Photo photo) {
		photos.add(photo);
	}
	
	public void addFriend(User user) {
		friends.add(user);
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

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
}
