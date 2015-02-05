package factories;

import bootcamp.products.*;
import interfaces.*;

public class IProductFactory {
	private static IProductFactory thisFactory = new IProductFactory();

	private IProductFactory() {

	}

	public static IProductFactory getFactory() {
		return thisFactory;
	}

	public IProduct getProduct(String type, String name, double price) {
		IProduct product = null;

		if (type.equals("computer"))
			product = new Computer(name, price);
		else if (type.equals("computer"))
			product = new Tablet(name, price);

		return product;
	}
}
