package payments;

import java.util.concurrent.atomic.AtomicInteger;

import interfaces.*;

public class CCPayment implements IPaymentStrategy {

	private static AtomicInteger generator = new AtomicInteger(0);
	private int uuid = 0;
	private String name;
	private String cardNumber;
	private String dateOfExpiry;

	public CCPayment(String name, String cardNumber, String dateOfExpiry) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.dateOfExpiry = dateOfExpiry;
		this.uuid = generator.incrementAndGet();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public void pay(double amount) {
		System.out.println(amount + " paid with credit card");
	}

}
