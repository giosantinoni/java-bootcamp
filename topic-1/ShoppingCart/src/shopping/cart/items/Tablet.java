package shopping.cart.items;

import shopping.cart.interfaces.*;

public class Tablet implements ShoppingCartItem {

	private String name;
	private double price;

	public Tablet(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Tablet [name=" + name + ", price=" + price + "]";
	}

}
