package payments;

import java.util.concurrent.atomic.AtomicInteger;

import interfaces.*;

public class CashPayment implements IPaymentStrategy{

	private static AtomicInteger generator = new AtomicInteger(0);
	private double amount;
	private int uuid = 0;

	public CashPayment(double amount) {
		this.amount = amount;
		this.uuid = generator.incrementAndGet();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void pay(double amount) {
		System.out.println(amount + "paid with cash");		
	}
	
	
}
