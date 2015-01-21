package shoppingcart.model;

public class Item {
	private String description;
	private double price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String description, double price) {
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
