package com.globant.exercise2.shoppingcart.services;

import org.springframework.stereotype.Service;

import com.globant.exercise2.shoppingcart.factory.ItemFactory;
import com.globant.exercise2.shoppingcart.model.ShoppingCart;
import com.globant.exercise2.shoppingcart.model.User;
import com.globant.exercise2.shoppingcart.model.item.Item;

/**
 * 
 * @author martin
 *
 */
@Service
public class ShoppingCartServices implements IShoppingCartServices {
	private ItemFactory itemFactory;
	private ShoppingCart currentShoppingCart;

	@Override
	public void newShoppingCart(User user) {
		currentShoppingCart = new ShoppingCart(user);
	}

	@Override
	public void addItem(String itemName) throws Exception {
		Item item = itemFactory.getItem(itemName);
		currentShoppingCart.addItem(item);
	}

	@Override
	public void finishSale(String paymentType, String data1, String data2) {
		currentShoppingCart.finishSale(paymentType, data1, data2);
	}

	@Override
	public String currentShoppingCartToString() {		
		return currentShoppingCart.toString();
	}

	@Override
	public ShoppingCart getCurrentShoppingCart() {
		return currentShoppingCart;
	}

	@Override
	public void setItemFactory(ItemFactory itemFactory) {
		this.itemFactory = itemFactory;
	}

}
