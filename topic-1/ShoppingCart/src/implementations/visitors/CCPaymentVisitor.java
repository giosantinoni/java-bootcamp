package implementations.visitors;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.IVisitor;

public class CCPaymentVisitor implements IVisitor {
	private double totalPrice;

	public double getTotalPrice() {
		return this.totalPrice;
	}

	@Override
	public void visitComputer(Computer computer) {
		this.totalPrice += computer.getPrice() - (computer.getPrice() * 0.10);

	}

	@Override
	public void visitTablet(Tablet tablet) {
		this.totalPrice += tablet.getPrice() - (tablet.getPrice() * 0.10);

	}

}
