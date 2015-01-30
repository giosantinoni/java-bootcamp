package services;

import notifications.Manager;
import products.Product;
import shop.ShoppingCart;
import transactions.Transaction;
import users.Photo;
import users.User;

public interface Services {
	
	 

	/**
	 * Creates a new Shopping cart with the user's data
	 * 
	 */

	public void createShoppingCart();

	/**
	 * 
	 * Deletes the shopping cart (and all the items it contains) from the shop
	 * 
	 */

	public void deleteShoppingCart();

	/**
	 * Updates the shopping Cart adding or removing products from it
	 * 
	 * @param product
	 *            : Element to be added/removed from the cart
	 * @param operation
	 *            : either add or remove from the cart. If operation = [Delete]
	 *            then the item is removed from the cart; if operation =
	 *            [Insert] the item is added to the cart
	 */

	public void updateShoppingCart(Product product, String operation);

	/**
	 * Lists the elements on the shopping cart
	 * 
	 * @return Returns a shopping Cart with the current elements on it
	 */

	public ShoppingCart readShoppingCart();

	/**
	 * Creates an User with the provided parameters
	 * 
	 * @param userName
	 * 				: The User's name for the site
	 * @param name
	 * 				: The User's name
	 * @param email
	 * 				: The User's email
	 * @param password
	 * 				: The User's password
	 * @param cardNumber
	 *            	: The User's credit card number            
	 */
	
	public void createUser(String userName, String name, String email, String password, int cardNumber);
	
	/**
	 * Updates the email, password or credit card number of an existing
	 * user. The user's name (userName)can not be modified once created.
	 * 
	 * @param name
	 * 			: The user's new name
	 * @param email
	 * 			: The new email
	 * @param password
	 * 			: The new password
	 * @param cardNumber
	 * 			: The new Credit Card Number
	 * 
	 */
	
	public void updateUser(String name, String email ,String password, int cardNumber);
	
	/**
	 *Deletes an existing User 
	 * 
	 */
	
	public void deleteUser();

	/**
	 * Reads all the information about an existing user
	 * 
	 */
	
	public User readUser();

	/**
	 * Generates the appropriate transaction according to the input parameter
	 * 
	 *  @param transactionType
	 * 					: can be = [CREDIT_CARD] [PAYPAL] [CASH]
	 */
	
	public void createTransaction(String transactionType);

	/**
	 * Returns a transaction
	 * @return
	 */
	public Transaction readTransaction();

	
	/**
	 * Creates a manager 
	 * 
	 * @param name
	 * 			: Manager's name
	 * @param email
	 * 			: Manager's email
	 */
	
	public void createManager(String name, String email);

	/**
	 * Updates the manager's email. The manager's name can not be modified once created
	 * @param email
	 * 			: New manager's email
	 */
	
	public void updateManager(String email);

	/**
	 * Deletes an existing manager
	 * 
	 */
	public void deleteManager();

	/**
	 *  Reads the information of an existing manager
	 *  
	 * @return
	 * 		Returns an existing manager
	 */
	public Manager readManager();
	
	/**
	 * Creates the appropriate product according to the type provided
	 * 
	 * @param name
	 * 			: The product's name
	 * @param price
	 * 			: The product's price. When the product to create is an offer, the price is null
	 * @param productType
	 * 			: The type of product. Possible values are : [Item] or [Offer]
	 */
	
	public void createProduct(String name, double price, String productType);
	
	/**
	 * Updates an existing product. In the case of updating an item the offerName
	 * field should be NULL.
	 * 
	 * @param name
	 * 			: The product's name
	 * @param price
	 * 			: The product's new price
	 * @param offerName
	 * 			: The name of the offer in which the new item will be inserted
	 */
	
	public void updateProduct(String name, double price, String offerName);

	
	/**
	 * Deletes the product matching the input parameter
	 * @param name
	 * 			: the product's name to be deleted
	 */
	public void deleteProduct(String name);

	/**
	 * Read the data of a given product
	 * 
	 * @return
	 * 		Product
	 */
	
	public Product readProduct();
	
	/**
	 * Uploads an user photo form the provided link
	 * 
	 * @param link
	 * 			: URL to the user's photo
	 */
	
	public void uploadPhoto(String link);
	
	/**
	 * Adds the select user as friend
	 * 
	 * @param friend
	 * 			: user to be added as friend			
	 */
	
	public void addFriend(User friend);
	
	
			
	public void likePhotos(String link, String friendName);
	

}
