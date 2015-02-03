package com.globant.exercise2.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

public class Photo {
	private String filePath;
	private Set<User> likes;
	
	public Photo() {
		likes = new HashSet<User>();
	}
	
	public Photo(String filePath) {
		this.filePath = filePath;
		likes = new HashSet<User>();
	}
	
	public void addLike(User user) {
		likes.add(user);
	}	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}
}
