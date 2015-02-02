package shoppingcart.model.payment;

/**
 * 
 * @author martin
 *
 */
public class Paypal extends Payment {
	private String email;
	private String password;
	
	/**
	 * Class constructor.
	 * 
	 * @param number
	 * @param total
	 * @param email
	 * @param password
	 */
	public Paypal(int number, double total, String email, String password) {
		super(number, total);
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Paypal [email=" + email + ", password=" + password + ", " + super.toString() + "]";
	}
}
