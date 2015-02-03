package implementations.products;

import interfaces.IItem;
import interfaces.IVisitor;

public class Computer implements IItem {

	private String name;
	private double price;

	public Computer(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", price=" + price + "]";
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visitComputer(this);

	}

}
