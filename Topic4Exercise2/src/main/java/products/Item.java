package products;

import notifications.Observer;
import shop.ShoppingCartVisitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import transactions.Transaction;

public class Item implements Product {



	private double price;
	private String name;
	private Set<Observer> itemObservers;

	public Item(String name, double price) {
		itemObservers = new HashSet<Observer>();
		this.name = name;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
		doNotify(this);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void accept(ShoppingCartVisitor visitor) {
		visitor.visit(this);
	}


	// subject methods Override
	
	
	
	@Override
	public void doNotify(Product product) {
		Iterator<Observer> iterator = itemObservers.iterator();
		while(iterator.hasNext()){
			Observer itemObserver = iterator.next();
			itemObserver.doUpdate("Price of " + product.getName() + " updated to: $" + product.getPrice());
		}
	}

	@Override
	public void addObserver(Observer observer) {
		itemObservers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		itemObservers.remove(observer);
		
	}

	@Override
	public void doNotify(Transaction transaction) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doNotify() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return "Item [price=" + price + ", name=" + name + ", itemObservers=" + itemObservers + "]";
	}
	

}
