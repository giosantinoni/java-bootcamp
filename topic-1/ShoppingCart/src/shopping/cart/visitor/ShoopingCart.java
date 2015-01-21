package shopping.cart.visitor;

import shopping.cart.interfaces.ShoppingCartVisitor;
import shopping.cart.items.*;

public class ShoopingCart implements ShoppingCartVisitor {

	private double total = 0.0;

	public double getTotal() {
		return total;
	}

	@Override
	public double visit(Computer computer) {
		return this.total = computer.getPrice();
	}

	@Override
	public double visit(Tablet tablet) {
		return this.total = tablet.getPrice();
	}

}
