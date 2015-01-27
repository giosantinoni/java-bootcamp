package implementations;

public class User {

	private String userName;
	private String password;
	private String email;
	private int cardNumber;

	
	public User(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email=email;
	}
	
	public User(String userName, int cardNumber) {
		this.userName = userName;
		this.cardNumber = cardNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUser(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
