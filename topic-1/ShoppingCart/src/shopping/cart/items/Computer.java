package shopping.cart.items;

import shopping.cart.interfaces.*;

public class Computer implements ShoppingCartItem {

	private String name;
	private double price;

	public Computer(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", price=" + price + "]";
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
