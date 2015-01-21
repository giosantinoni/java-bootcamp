package shoppingcart.model;

public class Paypal extends Payment {
	private String email;
	private String password;
	
	public Paypal(double total, String email, String password) {
		super(total);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
