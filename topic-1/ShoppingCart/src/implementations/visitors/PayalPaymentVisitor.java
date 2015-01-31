package implementations.visitors;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.*;

public class PayalPaymentVisitor implements IVisitor {
	private double totalPrice;
	private double cheapestPrice = Double.MAX_VALUE;

	public double getTotalPrice() {
		return this.totalPrice - this.cheapestPrice;
	}

	@Override
	public void visitComputer(Computer computer) {
		if (computer.getPrice() < this.cheapestPrice) {
			this.cheapestPrice = computer.getPrice();
		}
		this.totalPrice += computer.getPrice();
	}

	@Override
	public void visitTablet(Tablet tablet) {
		if (tablet.getPrice() < this.cheapestPrice) {
			this.cheapestPrice = tablet.getPrice();
		}
		this.totalPrice += tablet.getPrice();
	}

}
