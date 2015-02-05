package model;

import java.util.HashSet;
import java.util.Set;

import bootcamp.*;

public class PhotoModel {
	private int id;
	private Set<User> likes;

	public PhotoModel(Set<User> likes) {
		this.likes = new HashSet<User>();
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}

	public void setLike(User user) {
		likes.add(user);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
