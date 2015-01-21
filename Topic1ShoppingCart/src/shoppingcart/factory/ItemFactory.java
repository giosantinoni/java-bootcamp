package shoppingcart.factory;

import java.util.HashMap;
import java.util.Map;

import shoppingcart.model.Item;

public class ItemFactory {
	private static ItemFactory instance = new ItemFactory();
	private Map<String, Item> items;
	
	private ItemFactory() {
		items = new HashMap<String, Item>();
		
		items.put("Notebook Dell", new Item("Notebook Dell", 7000));
		items.put("Notebook ASUS", new Item("Notebook ASUS", 7000));
		items.put("TV LG 42", new Item("TV LG 42", 7000));
	}
	
	public static ItemFactory getInstance() {
		return instance;
	}
	
	public Item getItem(String itemName) throws Exception {
		if (items.containsKey(itemName))
			return items.get(itemName);
		else
			throw new Exception("The item " + itemName + " doesn't exist.");
	}
}
