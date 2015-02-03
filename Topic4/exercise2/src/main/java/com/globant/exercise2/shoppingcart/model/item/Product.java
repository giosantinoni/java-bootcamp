package com.globant.exercise2.shoppingcart.model.item;

/**
 * 
 * @author martin
 *
 */
public class Product extends Item {

	/**
	 * Class constructor.
	 */
	public Product() {
	}

	/**
	 * Class constructor.
	 * 
	 * @param description
	 * @param price
	 */
	public Product(String description, double price) {
		this.description = description;
		this.price = price;
	}
}
