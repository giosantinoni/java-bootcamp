package implementations.visitors;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.IVisitor;

public class PriceVisitor implements IVisitor {

	private double totalPrice;

	public double getTotalPrice() {
		return this.totalPrice;
	}

	@Override
	public void visitComputer(Computer computer) {
		this.totalPrice +=  computer.getPrice();

	}

	@Override
	public void visitTablet(Tablet tablet) {
		this.totalPrice += tablet.getPrice();
		
	}

}
