package shoppingcart;

import shoppingcart.factory.ItemFactory;
import shoppingcart.model.ShoppingCart;
import shoppingcart.model.User;

public class Test {

	public static void main(String[] args) {
		User user = new User("Martin Roldan");
		ShoppingCart shoppingCart = new ShoppingCart(user);
		
		ItemFactory itemFactory = ItemFactory.getInstance();
		
		try {
			shoppingCart.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCart.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		shoppingCart.finishSale("Paypal", "email@email.com", "123456");
		
	}

}
