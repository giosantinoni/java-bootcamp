package implementations;

import java.util.ArrayList;

import productFactory.Item;
import productFactory.Offer;
import productFactory.Product;
import productFactory.ProductFactory;
import transactionFactory.Transaction;
import transactionFactory.TransactionFactory;

public class Test {

	public static void main(String args[]) {

		ProductFactory productFactory = ProductFactory.getInstance(); 
		Manager m1 = new Manager();
		User user = new User("Carola",1234);
		productFactory.addObserver(m1);
		
		
		// create items and add observers to some of them
		Item tv1 = new Item("LG LED TV", 800);
		tv1.addObserver(m1);
		Item tv2 = new Item("Samsung LED", 700);
		Item phone1 = new Item("HTC Smartphone", 650.2);
		Item phone2 = new Item("Sony Smartphone", 400);
		Offer off1 = new Offer("Ciber Monday",350,tv1);
		
		
		
		
		// Add the created items to the shopping List
		productFactory.setProducts(tv2);
		productFactory.setProducts(tv1);
		productFactory.setProducts(phone1);
		productFactory.setProducts(phone2);
		productFactory.setProducts(off1);
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		
		// changing the price of one item 
		tv1.setPrice(850);
		
		// Shopping some items in the list
		try {
			shoppingCart.visit(productFactory.getProduct("LG LED TV"));
			shoppingCart.visit(productFactory.getProduct("LG LED TV"));
			shoppingCart.visit(productFactory.getProduct("Samsung LED"));
			shoppingCart.visit(productFactory.getProduct("Ciber Monday"));
		} catch (Exception e) {
				
			e.printStackTrace();
		}
		
		
		// Paying for the items
		TransactionFactory transactionFactory = TransactionFactory.getInstance();
		transactionFactory.addObserver(m1);
		
		transactionFactory.getTransaction("Credit Card", shoppingCart);
		//transactionFactory.getTransaction("Cash", shoppingCart);
		//transactionFactory.getTransaction("Paypal", shoppingCart);
		
		
		
		
	}
}
