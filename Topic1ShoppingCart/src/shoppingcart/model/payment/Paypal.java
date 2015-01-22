package shoppingcart.model.payment;

public class Paypal extends Payment {
	private String email;
	private String password;
	
	public Paypal(int number, double total, String email, String password) {
		super(number, total);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Paypal [email=" + email + ", password=" + password + ", " + super.toString() + "]";
	}
}
