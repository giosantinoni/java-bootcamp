package shop;

import java.util.ArrayList;

import products.Item;
import products.Offer;
import products.Product;

public interface ShoppingCartVisitor {
	
	
	public void visit(Item item);
	
	public void visit(Offer offer);

	public void visit(ArrayList<Product> productsList);
	
	public void visit(Product product);

}
