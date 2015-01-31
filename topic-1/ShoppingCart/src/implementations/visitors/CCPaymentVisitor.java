package implementations.visitors;

import java.util.concurrent.atomic.AtomicInteger;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.IVisitor;

public class CCPaymentVisitor implements IVisitor {

	private static AtomicInteger generator = new AtomicInteger(0);
	private int uuid = 0;
	private double totalPrice;

	public CCPaymentVisitor() {
		this.uuid = generator.incrementAndGet();
	}

	public int getUUID() {
		return uuid;
	}

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
