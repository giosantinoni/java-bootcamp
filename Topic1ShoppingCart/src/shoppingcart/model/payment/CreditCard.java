package shoppingcart.model.payment;

public class CreditCard extends Payment {
	private String name;
	private String number;
	
	public CreditCard(double total, String name, String number) {
		super(total);
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
}
