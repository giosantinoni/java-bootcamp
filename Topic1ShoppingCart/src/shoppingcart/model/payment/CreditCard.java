package shoppingcart.model.payment;

public class CreditCard extends Payment {
	private String name;
	private String creditCardNumber;

	public CreditCard(int number, double total, String name, String creditCardNumber) {
		super(number, total);
		this.name = name;
		this.creditCardNumber = creditCardNumber;
	}

	public String getName() {
		return name;
	}

	public String getcreditCardNumber() {
		return creditCardNumber;
	}

	@Override
	public String toString() {
		return "CreditCard [name=" + name + ", number=" + creditCardNumber + ", " + super.toString() + "]";
	}
}
