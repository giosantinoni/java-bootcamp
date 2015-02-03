package com.globant.exercise2.shoppingcart.factory;

public class IdFactory {
	private static int userCounter = 0;
	private static int paymentCounter = 0;
	
	public static int getId(String entityName) {
		if ("User".equals(entityName))
			return ++userCounter;
		else
			return ++paymentCounter;
	}
}
