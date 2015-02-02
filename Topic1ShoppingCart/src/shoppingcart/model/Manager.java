package shoppingcart.model;

import shoppingcart.model.interfaces.Observer;

/**
 * 
 * @author martin
 *
 */
public class Manager implements Observer {

	@Override
	public void update(String msg) {
		System.out.println(msg);		
	}

}
