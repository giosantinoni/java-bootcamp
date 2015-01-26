package shoppingcart.item;

import java.util.HashSet;
import java.util.Set;

public class Offer extends Item {
	private Set<Item> items;

	public Offer() {
		items = new HashSet<Item>();
	}
	
	public Offer(String description, double price) {
		this.description = description;
		this.price = price;
		items = new HashSet<Item>();
	}

	public Offer(String description, Set<Item> items, double price) {
		this.description = description;
		this.price = price;
		this.items = items;
	}

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
