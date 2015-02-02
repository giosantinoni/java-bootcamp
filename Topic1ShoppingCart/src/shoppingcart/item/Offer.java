package shoppingcart.item;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author martin
 *
 */
public class Offer extends Item {
	private Set<Item> items;

	/**
	 * Class constructor.
	 */
	public Offer() {
		items = new HashSet<Item>();
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param description
	 * @param price
	 */
	public Offer(String description, double price) {
		this.description = description;
		this.price = price;
		items = new HashSet<Item>();
	}

	/**
	 * Class constructor.
	 * 
	 * @param description
	 * @param items
	 * @param price
	 */
	public Offer(String description, Set<Item> items, double price) {
		this.description = description;
		this.price = price;
		this.items = items;
	}

	/**
	 * Adds an item into the items collection.
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public String toString() {
		String text = super.toString();
		
		for (Item i: items)
			text += "\n\t" + i.toString();
		
		return text + "\n";
	}

	public double getPrice() {
		return super.getPrice();
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
