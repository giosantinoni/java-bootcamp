package Exercise2;

import notifications.Manager;
import products.Item;
import products.Offer;
import products.ProductFactory;
import services.UserService;
import shop.ShoppingCart;
import transactions.TransactionFactory;
import users.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	/*
    	ProductFactory productFactory = ProductFactory.getInstance(); 
		Manager m1 = new Manager("Marco","marco@email.com" );
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
    */
    	
    	
    	ProductFactory productFactory = ProductFactory.getInstance(); 
		
		
		// create items and add observers to some of them
		Item tv1 = new Item("LG LED TV", 800);
		Item tv2 = new Item("Samsung LED", 700);
		Item phone1 = new Item("HTC Smartphone", 650.2);
		Item phone2 = new Item("Sony Smartphone", 400);
		Offer off1 = new Offer("Ciber Monday",350,tv1);
		
		
    	
    	UserService us = new UserService();
    	UserService us1 = new UserService();
    	
    	us.createUser("Marcoc", null, null, null, 0);
    	us1.createUser("Martin", null, null, null, 0);
    	
    	us.createShoppingCart();
    	
    	us.updateShoppingCart(tv1, "Insert");
    	us.updateShoppingCart(tv2, "Insert");
    	us.updateShoppingCart(phone1, "Insert");
    	us.updateShoppingCart(phone2, "Insert");
    	us.updateShoppingCart(off1, "Insert");
    	
    	System.out.println(us.readShoppingCart().getProductsList());
    	
    	us.createTransaction("CASH");
    	
    	us.addFriend(us1.readUser());
    	us.readUser().addPhoto("LINK");
    	us.readUser().likePhoto("LINK", "Martin");
    	
    	System.out.println(us.readUser());
    	
    	
    	
    	
    
    }
    
}
