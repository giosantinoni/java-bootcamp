package implementations.visitors;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.*;

public class CashPaymentVisitor implements IVisitor {
	private double totalPrice;
	private double expensiveItem = Double.MIN_VALUE;

	public double getTotalPrice() {
		return totalPrice - (this.expensiveItem * 0.90);
	}

	@Override
	public void visitComputer(Computer computer) {
		if (computer.getPrice() > this.expensiveItem) {
			this.expensiveItem = computer.getPrice();
		}
		this.totalPrice += computer.getPrice();

	}

	@Override
	public void visitTablet(Tablet tablet) {
		if (tablet.getPrice() > this.expensiveItem) {
			this.expensiveItem = tablet.getPrice();
		}
		this.totalPrice += tablet.getPrice();

	}

}
