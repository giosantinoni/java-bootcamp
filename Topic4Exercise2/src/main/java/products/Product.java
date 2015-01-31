package products;

import shop.ShoppingCartVisitor;
import notifications.Subject;

public interface Product extends Subject{
		
	public void setName(String name);
	
	public void setPrice(double price);
	
	public double getPrice();
	
	public String getName();
	
	public void accept(ShoppingCartVisitor visitor);
	
	
}
