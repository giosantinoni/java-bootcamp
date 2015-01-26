package shoppingcart.item;

public abstract class Item {
	protected String description;
	protected double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description + " .......... $" + price;
	}
}
