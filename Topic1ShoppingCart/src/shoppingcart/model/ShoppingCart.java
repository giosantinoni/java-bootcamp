package shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import shoppingcart.factory.PaymentFactory;
import shoppingcart.model.payment.Payment;

public class ShoppingCart {
	private List<Item> items;
	private User user;
	private Payment payment;

	public ShoppingCart(User user) {
		items = new ArrayList<Item>();
		this.user = user;
	}

	public void addItem(Item item) throws Exception {
		if (!items.contains(item))
			items.add(item);
		else
			throw new Exception("The selected item already exists in the current ShoppingCart.");
	}

	public void finishSale(String paymentType, String data1, String data2) {
		payment = PaymentFactory.getInstance().getPayment(paymentType, getTotal(getDiscount(paymentType)), data1, data2);
	}

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

	private double getTotal(double discount) {
		double total = 0;

		for (Item i : items) {
			total += i.getPrice();
		}

		return total - discount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + ", user=" + user + ", payment=" + payment + "]";
	}
}
