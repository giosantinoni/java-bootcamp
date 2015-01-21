package shopping.cart.interfaces;

import shopping.cart.items.*;

public interface ShoppingCartVisitor {
	double visit(Computer computer);

	double visit(Tablet tablet);
}
