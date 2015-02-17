package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private int payment_id;

	@Column(name = "paid")
	private String paid;

	@Column(name = "total")
	private double total;

	@Column(name = "detail")
	private String detail;

	public Payment() {
	}

	public Payment(int payment_id, String paid, double total, String detail) {
		this.payment_id = payment_id;
		this.paid = paid;
		this.total = total;
		this.detail = detail;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
