package products;

import notifications.Observer;
import shop.ShoppingCartVisitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import transactions.Transaction;

public class Offer implements Product {

	private String name;
	private double price;
	private ArrayList<Product> offerList;
	private Set<Observer> offerObservers;

	public Offer(String name, double price, ArrayList<Product> offerList) {
		offerList = new ArrayList<Product>();
		this.name = name;
		this.price = price;
		this.offerList = offerList;
	}

	public Offer(String name, double price, Product product) {
		offerList = new ArrayList<Product>();
		this.name = name;
		this.price = price;
		this.offerList.add(product);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		doNotify(this);
	}

	public ArrayList<Product> getOfferList() {
		return offerList;
	}

	public void setOfferList(ArrayList<Product> offerList) {
		this.offerList = offerList;
	}

	@Override
	public void accept(ShoppingCartVisitor visitor) {
		visitor.visit(this);
	}

	// Subject methods Override
	@Override
	public void doNotify(Product product) {
		Iterator<Observer> iterator = offerObservers.iterator();
		while (iterator.hasNext()) {
			Observer offerObserver = iterator.next();
			offerObserver.doUpdate("Price of " + product.getName() + " updated to: $" + product.getPrice());
		}
	}

	@Override
	public void addObserver(Observer observer) {
		offerObservers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		offerObservers.remove(observer);

	}

	@Override
	public void doNotify(Transaction transaction) {

	}

	@Override
	public void doNotify() {

	}

	@Override
	public String toString() {
		return "Offer [name=" + name + ", price=" + price + ", offerList=" + offerList + ", offerObservers=" + offerObservers + "]";
	}

}
