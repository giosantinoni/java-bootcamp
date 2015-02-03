package implementations.products;

import interfaces.IItem;
import interfaces.IVisitor;

public class Tablet implements IItem {

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
	public String toString() {
		return "Tablet [name=" + name + ", price=" + price + "]";
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visitTablet(this);

	}

}
