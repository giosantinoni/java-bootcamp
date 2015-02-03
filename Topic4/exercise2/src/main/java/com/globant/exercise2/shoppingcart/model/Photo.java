package com.globant.exercise2.shoppingcart.model;

public class Photo {
	private String filePath;
	
	public Photo() {
	}
	
	public Photo(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
