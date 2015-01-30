package transactions;

import products.Product;
import shop.ShoppingCart;

public class PayPal extends Transaction {

	
	private String userName;
	private String password;
	private String email;
	
	public PayPal(ShoppingCart shoppingCart){
		total=shoppingCart.getTotalCost();
		transactionNumber++;
		userName = shoppingCart.getUser().getUserName();
		password = shoppingCart.getUser().getPassword();
		email = shoppingCart.getUser().getEmail();
		calculateDiscount(shoppingCart);
		System.out.println("User's " + userName + " PayPal Transaction of $" + totalWithDiscount + " with mail account " + email + " completed");
	}
	
	@Override
	public void calculateDiscount(ShoppingCart shoppingCart){
		Product p = null;
		double cheapestPrice = 0;

		p =  shoppingCart.getProductsList().get(0);
		cheapestPrice = p.getPrice();

		for (Product prod : shoppingCart.getProductsList()) {
			if (cheapestPrice >= prod.getPrice()) {
				cheapestPrice = prod.getPrice();
			}
		}
		totalWithDiscount = total - cheapestPrice;

	}
}
