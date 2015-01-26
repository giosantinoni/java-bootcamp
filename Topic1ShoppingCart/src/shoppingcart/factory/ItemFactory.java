package shoppingcart.factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import shoppingcart.item.Product;
import shoppingcart.item.Offer;
import shoppingcart.item.Item;

public class ItemFactory {
	private static ItemFactory instance = new ItemFactory();
	private Map<String, Item> items;

	private ItemFactory() {
		items = new HashMap<String, Item>();

		/*
		 * Creating Products
		 */
		items.put("Notebook Dell", new Product("Notebook Dell", 7200));
		items.put("Notebook ASUS", new Product("Notebook ASUS", 7000));
		items.put("TV LG 42", new Product("TV LG 42", 6500));

		/*
		 * Creating Offers
		 */
		Offer offer = new Offer("DellLG", 8000);
		try {
			offer.addItem(getItem("Notebook ASUS"));
			offer.addItem(getItem("TV LG 42"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		items.put(offer.getDescription(), offer);
	}

	public static ItemFactory getInstance() {
		return instance;
	}

	public Object[] getItems() {
		return items.values().toArray();
	}

	public Item getItem(String itemName) throws Exception {
		if (items.containsKey(itemName))
			return items.get(itemName);
		else
			throw new Exception("The item " + itemName + " doesn't exist.");
	}
}
