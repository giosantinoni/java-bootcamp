package shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import shoppingcart.services.PaymentFactory;

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
		payment = PaymentFactory.getInstance().getPayment(paymentType, getTotal(), data1, data2);
	}
	
	private double getTotal() {
		double total = 0;
		
		for (Item i: items)
			total += i.getPrice();
		
		return total;
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
}
