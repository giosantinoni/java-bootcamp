package bootcamp;

import java.util.ArrayList;

import interfaces.*;

public class ItemLine {
	private ArrayList<IProduct> items;
	private Offer offer;
	private double totalAmount;

	public ArrayList<IProduct> getItems() {
		return items;
	}
	
	public void calculateTotal() {
		for (IProduct product : items) {
			this.totalAmount += product.getPrice();
		}
		this.totalAmount += offer.getPrice();
	}

	public void setItems(ArrayList<IProduct> items) {
		this.items = items;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void add(IProduct item) {
		this.totalAmount += item.getPrice();
		items.add(item);
	}

}
