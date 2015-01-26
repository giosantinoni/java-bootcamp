package shoppingcart.services;

import java.util.Collection;

import shoppingcart.item.Product;
import shoppingcart.item.Item;
import shoppingcart.model.User;

public interface IShoppingCartServices {
	void newShoppingCart(User user);

	void addItem(Item item) throws Exception;

	void finishSale(String paymentType, String data1, String data2);

	String getCurrentShoppingCart();
}
