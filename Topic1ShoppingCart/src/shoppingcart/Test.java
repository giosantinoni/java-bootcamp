package shoppingcart;

import shoppingcart.factory.ItemFactory;
import shoppingcart.factory.PaymentFactory;
import shoppingcart.item.Offer;
import shoppingcart.item.Product;
import shoppingcart.model.Manager;
import shoppingcart.model.User;
import shoppingcart.model.interfaces.Observer;
import shoppingcart.services.IShoppingCartServices;
import shoppingcart.services.ShoppingCartServices;

public class Test {

	public static void main(String[] args) {
		Observer manager = new Manager();
		
		/*
		 * Getting Factories
		 */
		ItemFactory itemFactory = ItemFactory.getInstance();
		
		/*
		 * Adding Observer
		 */
		PaymentFactory.getInstance().addObserver(manager);
		itemFactory.addObserver(manager);

		/*
		 * Displaying Products
		 */
		System.out.println("\n\t\t PRODUCTS");
		Object[] items = itemFactory.getItems();

		for (int i = 0; i < items.length; i++) {
			if (items[i] instanceof Product)
				System.out.println(items[i].toString());
		}

		/*
		 * Displaying Offers
		 */
		System.out.println("\n\t\t OFFERS");

		for (int i = 0; i < items.length; i++) {
			if (items[i] instanceof Offer)
				System.out.println(items[i].toString());
		}
		
		// Changing a price
		itemFactory.changeItemPrice("TV LG 42", 7500);
		
		/*
		 * Beginning Services
		 */

		IShoppingCartServices shoppingCartServices = new ShoppingCartServices();

		/*
		 * Cash
		 */
		User user = new User("Martin Roldan");
		shoppingCartServices.newShoppingCart(user);

		try {
			shoppingCartServices.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCartServices.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		shoppingCartServices.finishSale("Cash", "", "");

		System.out.println(shoppingCartServices.getCurrentShoppingCart());
		System.out.println();

		/*
		 * Paypal
		 */
		User user2 = new User("Julieta Romero");
		shoppingCartServices.newShoppingCart(user2);

		try {
			shoppingCartServices.addItem(itemFactory.getItem("DellLG"));
			shoppingCartServices.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		shoppingCartServices.finishSale("Paypal", "email@email.com", "123456");

		System.out.println(shoppingCartServices.getCurrentShoppingCart());
		System.out.println();

		/*
		 * CreditCard
		 */
		User user3 = new User("Julieta Romero");
		shoppingCartServices.newShoppingCart(user3);

		try {
			shoppingCartServices.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCartServices.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		shoppingCartServices.finishSale("CreditCard", user3.getName(), "1234567890");

		System.out.println(shoppingCartServices.getCurrentShoppingCart());
		System.out.println();
		
		/*
		 * CreditCard 2
		 */
		User user4 = new User("Julieta Romero");
		shoppingCartServices.newShoppingCart(user4);

		try {
			shoppingCartServices.addItem(itemFactory.getItem("DellLG"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		shoppingCartServices.finishSale("CreditCard", user4.getName(), "1234567890");

		System.out.println(shoppingCartServices.getCurrentShoppingCart());
		System.out.println();

	}

}
