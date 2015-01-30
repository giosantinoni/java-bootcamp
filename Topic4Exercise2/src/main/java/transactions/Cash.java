package transactions;

import products.Product;
import shop.ShoppingCart;

public class Cash extends Transaction{
	
	public Cash(ShoppingCart shoppingCart){
		total=shoppingCart.getTotalCost();
		transactionNumber++;
		calculateDiscount(shoppingCart);
	}
	
	@Override
	public void calculateDiscount(ShoppingCart shoppingCart){
		
		Product p = null;
		double expensivePrice = 0;

		p = shoppingCart.getProductsList().get(0);
		expensivePrice = p.getPrice();

		for (Product prod : shoppingCart.getProductsList()) {
			if (prod.getPrice() > expensivePrice)
				expensivePrice = prod.getPrice();
		}

		expensivePrice = expensivePrice * (0.9);
		totalWithDiscount = total - expensivePrice;
		System.out.println("Cash Transaction of $" + totalWithDiscount + " completed");
		
	}
	

}
