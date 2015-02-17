package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@OneToOne
	@Column(name = "user_login_id")
	private int user_login_id;

	@OneToOne
	@Column(name = "account_id")
	private int account_id;

	public Customer() {
	}

	public Customer(int id, String address, String phone, String email, 
			int user_login_id, int account_id) {
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.user_login_id = user_login_id;
		this.account_id = account_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_login_id() {
		return user_login_id;
	}

	public void setUser_login_id(int user_login_id) {
		this.user_login_id = user_login_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

}
