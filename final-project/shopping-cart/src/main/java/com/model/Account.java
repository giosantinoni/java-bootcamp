package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private int id;

	@Column(name = "billing_addess")
	private String billing_addess;

	@Column(name = "open_date")
	private String open_date;

	@Column(name = "close_date")
	private String close_date;

	@Column(name = "is_closed")
	private Boolean is_closed;

	@ManyToOne
	@Column(name = "payment_id")
	private int payment_id;

	public Account() {
	}

	public Account(int id, String billing_addess, String open_date, 
			String close_date, Boolean is_closed, int payment_id) {
		this.id = id;
		this.billing_addess = billing_addess;
		this.open_date = open_date;
		this.close_date = close_date;
		this.is_closed = is_closed;
		this.payment_id = payment_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBilling_addess() {
		return billing_addess;
	}

	public void setBilling_addess(String billing_addess) {
		this.billing_addess = billing_addess;
	}

	public String getOpen_date() {
		return open_date;
	}

	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}

	public String getClose_date() {
		return close_date;
	}

	public void setClose_date(String close_date) {
		this.close_date = close_date;
	}

	public Boolean getIs_closed() {
		return is_closed;
	}

	public void setIs_closed(Boolean is_closed) {
		this.is_closed = is_closed;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

}
