package shoppingcart.model;

import shoppingcart.model.interfaces.Observer;

public class Manager implements Observer {

	@Override
	public void update(String msg) {
		System.out.println(msg);		
	}

}
