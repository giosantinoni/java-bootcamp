package services;

import notifications.Manager;
import products.Product;
import shop.ShoppingCart;
import transactions.Transaction;
import transactions.TransactionFactory;
import users.User;

public class UserService implements Services{
	
	private ShoppingCart shoppingCart;
	private User user;
	private Transaction transaction;
	private TransactionFactory transactionFactory;
	private Manager marketManager;
	
	
	
	
	public UserService() {
		
		marketManager = new Manager("Marco","marco@email.com");
	}

	@Override
	public void createShoppingCart() {
		
		shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		
	}

	@Override
	public void deleteShoppingCart() {
		
		shoppingCart = null;
		
	}

	@Override
	public void updateShoppingCart(Product product, String operation) {
		if(operation.equals("Insert")) {
			shoppingCart.visit(product);
			System.out.println("Insert operation completed");
		}
		else {
			if(operation.equals("Delete")){
				shoppingCart.removeProduct(product);
				System.out.println("Delete operation completed");
			}
			else System.out.println("Operation not recognized");
		}
		
	}

	@Override
	public ShoppingCart readShoppingCart() {
		
		return shoppingCart;
	}

	@Override
	public void createUser(String userName, String name, String email, String password, int cardNumber) {
		user = new User(userName, name, email, password, cardNumber);
		
	}

	@Override
	public void updateUser(String name, String email, String password, int cardNumber) {
		if(!name.equals(null)) {
			user.setName(email);
		}
		
		if(!email.equals(null)) {
			user.setEmail(email);
		}
		
		if(!password.equals(null)){
			user.setPassword(password);
		}
		
		if(cardNumber != 0) {
			user.setCardNumber(cardNumber);
		}
	}

	@Override
	public void deleteUser() {
		user = null;
		
	}

	@Override
	public User readUser() {
		
		return user;
	}

	@Override
	public void createTransaction(String transactionType) {
		
		transactionFactory = transactionFactory.getInstance();
		transactionFactory.addObserver(marketManager);
		transactionFactory.getTransaction(transactionType, shoppingCart);
	
	}

	@Override
	public Transaction readTransaction() {
		
		return transaction;
	}

	@Override
	public void createManager(String name, String email) {
		System.out.println("You do not have the required permissions to do this");
		
	}

	@Override
	public void updateManager(String email) {
		System.out.println("You do not have the required permissions to do this");
		
	}

	@Override
	public void deleteManager() {
		System.out.println("You do not have the required permissions to do this");
		
	}

	@Override
	public Manager readManager() {
		System.out.println("You do not have the required permissions to do this");
		return null;
	}

	@Override
	public void createProduct(String name, double price, String productType) {
		System.out.println("You do not have the required permissions to do this");
		
	}

	@Override
	public void updateProduct(String name, double price, String offerName) {
		System.out.println("You do not have the required permissions to do this");
		
	}

	@Override
	public void deleteProduct(String name) {
		System.out.println("You do not have the required permissions to do this");
		
	}

	@Override
	public Product readProduct() {
		System.out.println("You do not have the required permissions to do this");
		return null;
	}
	
	@Override 
	public void uploadPhoto(String link){
		user.addPhoto(link);
	}

	@Override
	public void addFriend(User friend) {
		user.addFriend(friend);
		
	}

	@Override
	public void likePhotos(String link, String friendName) {
		user.likePhoto(link,friendName);
		
	}
	
	
	

}
