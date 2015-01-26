package shoppingcart;

import shoppingcart.factory.ItemFactory;
import shoppingcart.item.Offer;
import shoppingcart.item.Product;
import shoppingcart.model.User;
import shoppingcart.services.IShoppingCartServices;
import shoppingcart.services.ShoppingCartServices;

public class Test {

	public static void main(String[] args) {
		/*
		 * Getting Factories
		 */
		ItemFactory itemFactory = ItemFactory.getInstance();

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

		/*
		 * Paypal
		 */
		User user2 = new User("Julieta Romero");
		shoppingCartServices.newShoppingCart(user2);

		try {
			shoppingCartServices.addItem(itemFactory.getItem("TV LG 42"));
			shoppingCartServices.addItem(itemFactory.getItem("Notebook Dell"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		shoppingCartServices.finishSale("Paypal", "email@email.com", "123456");

		System.out.println(shoppingCartServices.getCurrentShoppingCart());

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

	}

}
