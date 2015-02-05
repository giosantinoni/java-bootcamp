package bootcamp;

import java.util.ArrayList;

import interfaces.*;

public class Offer {
	private ArrayList<IProduct> products;
	private double price;

	public Offer(ArrayList<IProduct> products, double price) {
		this.products = products;
		this.price = price;
	}

	public ArrayList<IProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<IProduct> products) {
		this.products = products;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void add(IProduct item) {
		products.add(item);
	}
}
