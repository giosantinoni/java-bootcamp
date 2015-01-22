package shoppingcart;

import shoppingcart.factory.ItemFactory;
import shoppingcart.model.ShoppingCart;
import shoppingcart.model.User;

public class Test {

	public static void main(String[] args) {
		/*
		 *	Cash 
		 */		
		User user = new User("Martin Roldan");
		ShoppingCart shoppingCart = new ShoppingCart(user);
		
		ItemFactory itemFactory = ItemFactory.getInstance();
		
		try {
			shoppingCart.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCart.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		shoppingCart.finishSale("Cash", "", "");
		
		System.out.println(shoppingCart.toString());
		
		
		/*
		 * 	Paypal
		 */		
		User user2 = new User("Julieta Romero");
		ShoppingCart shoppingCart2 = new ShoppingCart(user);
		
		try {
			shoppingCart2.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCart2.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		shoppingCart2.finishSale("Paypal", "email@email.com", "123456");
		
		System.out.println(shoppingCart2.toString());
		
		
		
		/*
		 *	CreditCard
		 */		
		User user3 = new User("Julieta Romero");
		ShoppingCart shoppingCart3 = new ShoppingCart(user);
		
		try {
			shoppingCart3.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCart3.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		shoppingCart3.finishSale("CreditCard", user3.getName(), "1234567890");
		
		System.out.println(shoppingCart3.toString());
		
	}

}
