package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int product_id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	public Product() {
	}

	public Product(int id, String name, Double price) {
		this.product_id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return product_id;
	}

	public void setId(int id) {
		this.product_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
