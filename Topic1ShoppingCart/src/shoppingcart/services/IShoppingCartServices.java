package shoppingcart.services;

import shoppingcart.item.Item;
import shoppingcart.model.User;

/**
 * 
 * @author martin
 *
 */
public interface IShoppingCartServices {

	/**
	 * Creates a new instance of <code>ShoppingCart</code>.
	 * 
	 * @param user
	 */
	void newShoppingCart(User user);

	/**
	 * Adds an item into the current shoppingcart.
	 * 
	 * @param item
	 * @throws Exception
	 */
	void addItem(Item item) throws Exception;

	/**
	 * Generates a payment transaction for the current <code>ShoppingCart</code>
	 * instance and then creates a new one.
	 * 
	 * @param paymentType
	 * @param data1
	 * @param data2
	 */
	void finishSale(String paymentType, String data1, String data2);

	/**
	 * Returns a <code>String</code> with all the information about the current
	 * <code>ShoppingCart</code> instance.
	 * 
	 * @return
	 */
	String getCurrentShoppingCart();
}
