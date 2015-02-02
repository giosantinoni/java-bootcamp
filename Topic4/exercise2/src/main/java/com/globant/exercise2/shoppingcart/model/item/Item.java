package com.globant.exercise2.shoppingcart.model.item;

/**
 * Item is the abstract base class for all the things you can add to a
 * shoppingcart.
 * 
 * @author martin
 *
 */
public abstract class Item {
	protected String description;
	protected double price;

	/**
	 * Returns the price of the item.
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the item.
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns the description of the item.
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the item.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description + " .......... $" + price;
	}
}
