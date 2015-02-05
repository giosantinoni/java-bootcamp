package payments;

import java.util.concurrent.atomic.AtomicInteger;

import interfaces.*;

public class PaypalPayment implements IPaymentStrategy {

	private static AtomicInteger generator = new AtomicInteger(0);
	private int uuid = 0;
	private String email;
	private String password;

	public PaypalPayment(String email, String password) {
		this.email = email;
		this.password = password;
		this.uuid = generator.incrementAndGet();
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void pay(double amount) {
		System.out.println(amount + " paid using Paypal.");

	}

}
