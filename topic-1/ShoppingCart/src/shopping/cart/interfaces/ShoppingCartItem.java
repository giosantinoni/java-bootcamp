package shopping.cart.interfaces;

public interface ShoppingCartItem {
	double accept(ShoppingCartVisitor visitor);
}
