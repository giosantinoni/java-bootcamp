package shoppingcart.services;

import shoppingcart.factory.ItemFactory;
import shoppingcart.item.Item;
import shoppingcart.model.ShoppingCart;
import shoppingcart.model.User;

public class ShoppingCartServices implements IShoppingCartServices {
	private ShoppingCart currentShoppingCart;

	@Override
	public void newShoppingCart(User user) {
		currentShoppingCart = new ShoppingCart(user);
	}

	@Override
	public void addItem(Item item) throws Exception {
		currentShoppingCart.addItem(item);
	}

	@Override
	public void finishSale(String paymentType, String data1, String data2) {
		currentShoppingCart.finishSale(paymentType, data1, data2);
	}

	@Override
	public String getCurrentShoppingCart() {		
		return currentShoppingCart.toString();
	}

}
