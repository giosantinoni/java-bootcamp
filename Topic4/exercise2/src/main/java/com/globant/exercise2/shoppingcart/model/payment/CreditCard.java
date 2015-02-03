package com.globant.exercise2.shoppingcart.model.payment;

/**
 * 
 * @author martin
 *
 */
public class CreditCard extends Payment {
	private String name;
	private String creditCardNumber;

	/**
	 * Class constructor.
	 * 
	 * @param number
	 * @param total
	 * @param name
	 * @param creditCardNumber
	 */
	public CreditCard(int number, double total, String name, String creditCardNumber) {
		super(number, total);
		this.name = name;
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getcreditCardNumber() {
		return creditCardNumber;
	}

	@Override
	public String toString() {
		return "CreditCard [name=" + name + ", number=" + creditCardNumber + ", " + super.toString() + "]";
	}
}
