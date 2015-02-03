package com.globant.exercise2.shoppingcart.factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.globant.exercise2.shoppingcart.model.interfaces.Observer;
import com.globant.exercise2.shoppingcart.model.interfaces.Subject;
import com.globant.exercise2.shoppingcart.model.item.Item;
import com.globant.exercise2.shoppingcart.model.item.Offer;
import com.globant.exercise2.shoppingcart.model.item.Product;

/**
 * 
 * @author martin
 *
 */
public class ItemFactory implements Subject  {
	private static ItemFactory instance = new ItemFactory();
	private Map<String, Item> items;
	private Set<Observer> observers;

	/**
	 * Class constructor.
	 */
	private ItemFactory() {
		observers = new HashSet<Observer>();
		items = new HashMap<String, Item>();

		/*
		 * Creating Products
		 */
		addItem("Notebook Dell", new Product("Notebook Dell", 7200));
		addItem("Notebook ASUS", new Product("Notebook ASUS", 7000));
		addItem("TV LG 42", new Product("TV LG 42", 6500));

		/*
		 * Creating Offers
		 */
		Offer offer = new Offer("DellLG", 8000);
		try {
			offer.addItem(getItem("Notebook ASUS"));
			offer.addItem(getItem("TV LG 42"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		addItem(offer.getDescription(), offer);
	}

	/**
	 * Returns the unique instance of the class <code>ItemFactory</code>.
	 * 
	 * @return
	 */
	public static ItemFactory getInstance() {
		return instance;
	}

	/**
	 * Returns an array that contains all the available items.
	 * 
	 * @return
	 */
	public Object[] getItems() {
		return items.values().toArray();
	}

	/**
	 * Adds a new item into the items collection.
	 * 
	 * @param key
	 * @param item
	 */
	public void addItem(String key, Item item) {
		items.put(key, item);
		doNotify("New Item: " + item.toString());
	}

	/**
	 * Changes the price of a specific item.
	 * 
	 * @param key
	 * @param newPrice
	 */
	public void changeItemPrice(String key, double newPrice) {
		Item item = items.get(key);
		item.setPrice(newPrice);
		doNotify("Price changed for Item: " + item.toString());
	}

	/**
	 * Returns 
	 * 
	 * @param itemName
	 * @return
	 * @throws Exception
	 */
	public Item getItem(String itemName) throws Exception {
		if (items.containsKey(itemName))
			return items.get(itemName);
		else
			throw new Exception("The item " + itemName + " doesn't exist.");
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void doNotify(String msg) {
		for (Observer observer : observers)
			observer.update(msg);
	}
}
