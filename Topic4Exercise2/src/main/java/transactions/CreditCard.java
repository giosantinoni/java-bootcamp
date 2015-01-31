package transactions;

import shop.ShoppingCart;

public class CreditCard extends Transaction{
	
	private String name;
	private int cardNumber;
	
	public CreditCard(ShoppingCart shoppingCart){
		total=shoppingCart.getTotalCost();
		transactionNumber++;
		this.name=shoppingCart.getUser().getUserName();
		this.cardNumber=shoppingCart.getUser().getCardNumber();
		calculateDiscount();
		System.out.println("User's" + name +" Credit Card Transaction of $" + totalWithDiscount + " with card Nº" + cardNumber + " completed");
	}
	
	@Override
	public void calculateDiscount(){
		totalWithDiscount = total * 0.9;
	}

}
