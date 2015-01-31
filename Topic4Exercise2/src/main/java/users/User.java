package users;

import java.util.ArrayList;

public class User {

	private String userName;
	private String name;	//Credit Card User's name
	private String password;
	private String email;
	private int cardNumber;
	private ArrayList<Photo> photoGallery;
	private ArrayList<User> friends;

	
	
	/**
	 * Generates a general purpose user
	 * 
	 * @param userName
	 * 			: User's name 
	 * @param name
	 * 			: Credit card user's name
	 * @param password
	 * 			: PayPal user's password
	 * @param email
	 * 			: PayPal user's email
	 * @param cardNumber
	 * 			: Credit Card user's card number
	 */
	
	public User(String userName, String name, String password, String email, int cardNumber) {
		super();
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.email = email;
		this.cardNumber = cardNumber;
		photoGallery=new ArrayList<Photo>();
		friends = new ArrayList<User>();
	}

	/**
	 * Creates a regular (Cash) user with the provided parameters
	 * 
	 * @param userName
	 * 				: User's name
	 */
	
	public User(String userName) {
		
		this.userName = userName;
	}

	/**
	 * 
	 * Creates a PayPal User with the provided parameters
	 * 
	 * @param userName
	 *            : PayPal user name
	 * @param password
	 *            : PayPal password
	 * @param email
	 *            : User's email
	 * 
	 * 
	 * 
	 */

	public User(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	/**
	 * Creates a Credit card user
	 * 
	 * 
	 * @param userName
	 *            : User's name
	 * @param cardNumber
	 *            : User's Credit card number
	 */

	public User(String userName, int cardNumber) {
		this.userName = userName;
		this.cardNumber = cardNumber;
	}
	
	



	public ArrayList<Photo> getPhotoGalery() {
		return photoGallery;
	}

	public void setPhotoGalery(ArrayList<Photo> photoGalery) {
		this.photoGallery = photoGalery;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Adds a photo to the gallery
	 * @param link
	 * 			: URL to the photo to be added
	 */
	
	public void addPhoto(String link){
		Photo photo = new Photo(link);
		photoGallery.add(photo);
	}
	
	/**
	 * Adds a frien to the user's friend list
	 * 
	 * @param friend
	 * 			: friend to be added
	 */
	
	public void addFriend(User friend){
		if(!friends.contains(friend)){
			friends.add(friend);
		}
	}
	
	/**
	 * Removes an existing friend from the user's friend list
	 * 
	 * @param friend
	 * 			: friend to be removed
	 */
	
	public void removeFriend(User friend) {
		if(friends.contains(friend)){
			friends.remove(friend);
		}
	}
	
	public void likePhoto(String URL, String friendName){
		for(int i = 0; i< photoGallery.size();i++) {
			if (photoGallery.get(i).getLink().equals(URL)){
				photoGallery.get(i).like(friendName);
			}
		}
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", email=" + email + ", cardNumber=" + cardNumber + ", photoGalery="
				+ photoGallery + ", friends=" + friends + "(total friends):" + friends.size() +"]";
	}
	

	
	
	

}
