package shoppingcart.model;

/**
 * 
 * @author martin
 *
 */
public class User {
	private String name;
	
	/**
	 * Class constructor.
	 * 
	 * @param name
	 */
	public User(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	/**
	 * Returns the name of the user.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
}
