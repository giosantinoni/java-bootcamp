package implementations.visitors;

import java.util.concurrent.atomic.AtomicInteger;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.*;

public class PayalPaymentVisitor implements IVisitor {

	private static AtomicInteger generator = new AtomicInteger(0);
	private int uuid = 0;
	private double totalPrice;
	private double cheapestPrice = Double.MAX_VALUE;

	public PayalPaymentVisitor() {
		this.uuid = generator.incrementAndGet();
	}

	public int getUUID() {
		return uuid;
	}

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
