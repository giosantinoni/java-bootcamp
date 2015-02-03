package shoppingcart.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shoppingcart.factory.PaymentFactory;
import shoppingcart.item.Item;
import shoppingcart.model.payment.Payment;

/**
 * 
 * @author martin
 *
 */
public class ShoppingCart {
	private Set<Item> items;
	private User user;
	private Payment payment;

	/**
	 * Class constructor.
	 * 
	 * @param user
	 */
	public ShoppingCart(User user) {
		items = new HashSet<Item>();
		this.user = user;
	}

	/**
	 * Adds a new item into the items collection.
	 * 
	 * @param item
	 * @throws Exception
	 */
	public void addItem(Item item) throws Exception {
		items.add(item);
	}

	/**
	 * Generates a new payment transaction for the shoppingcart.
	 * 
	 * @param paymentType
	 * @param data1
	 * @param data2
	 */
	public void finishSale(String paymentType, String data1, String data2) {
		payment = PaymentFactory.getInstance().getPayment(paymentType, getTotal(getDiscount(paymentType)), data1, data2);
	}

	/**
	 * Returns the discount value for the specific payment type.
	 * 
	 * @param paymentType
	 * @return
	 */
	private double getDiscount(String paymentType) {
		double discount = 0;
		if ("CreditCard".equals(paymentType)) {
			for (Item i : items)
				discount += i.getPrice() * 0.1;
		} else if ("Paypal".equals(paymentType)) {
			for (Item i : items) {
				if (discount == 0)
					discount = i.getPrice();
				else if (discount > i.getPrice())
					discount = i.getPrice();
			}
		} else {
			for (Item i : items) {
				if (discount == 0)
					discount = i.getPrice();
				else if (discount < i.getPrice())
					discount = i.getPrice();
			}
			discount = discount * 0.9;
		}
		return discount;
	}

	/**
	 * Returns the total amount.
	 * 
	 * @param discount
	 * @return
	 */
	private double getTotal(double discount) {
		double total = 0;

		for (Item i : items) {
			total += i.getPrice();
		}

		return total - discount;
	}

	/**
	 * Returns the items collection.
	 * 
	 * @return
	 */
	public Set<Item> getItems() {
		return items;
	}

	/**
	 * Sets the items collection.
	 * 
	 * @param items
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}

	/**
	 * Returns the user associated to the shoppingcart.
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets a user to the shoppingcart.
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Returns the payment transaction.
	 * 
	 * @return
	 */
	public Payment getPayment() {
		return payment;
	}

	
	/**
	 * Sets the payment transaction.
	 * 
	 * @param payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + ", user=" + user + ", payment=" + payment + "]";
	}
}
