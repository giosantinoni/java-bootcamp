package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WebUser")
public class WebUser {

	@Id
	@GeneratedValue
	@Column(name = "login_id")
	private int user_id;

	@Column(name = "")
	private String password;

	@Column(name = "state")
	private String state;

	public WebUser() {
	}

	public WebUser(int user_id, String password, String state) {
		this.user_id = user_id;
		this.password = password;
		this.state = state;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
