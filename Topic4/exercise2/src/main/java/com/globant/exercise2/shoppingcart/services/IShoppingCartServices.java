package com.globant.exercise2.shoppingcart.services;

import com.globant.exercise2.shoppingcart.factory.ItemFactory;
import com.globant.exercise2.shoppingcart.model.ShoppingCart;
import com.globant.exercise2.shoppingcart.model.User;
import com.globant.exercise2.shoppingcart.model.item.Item;

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
	 * @param itemName
	 * @throws Exception
	 */
	void addItem(String itemName) throws Exception;

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
	String currentShoppingCartToString();
	
	/**
	 * Returns the current shoppingcart instance.
	 * 
	 * @return
	 */
	ShoppingCart getCurrentShoppingCart();
	
	void setItemFactory(ItemFactory itemFactory);
}
