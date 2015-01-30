package shop;


import java.util.ArrayList;

import products.Item;
import products.Offer;
import products.Product;
import users.User;

public class ShoppingCart implements ShoppingCartVisitor {

	private User user;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	private ArrayList<Product> productsList;

	private double totalCost;
	
	/**
	 * 
	 */
	public ShoppingCart() {
		productsList = new ArrayList<Product>();
		totalCost=0;
	}
	
	
	public ArrayList<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(ArrayList<Product> productsList) {
		this.productsList = productsList;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public void removeProduct(Product product) {
		
		productsList.remove(product);
		
	}

	
	//ShoppingCartVisitor methods override
	@Override
	public void visit(Item item) {
		productsList.add(item);
		System.out.println("Item name: " + item.getName() + " $" + item.getPrice() + " Added to the cart");
		totalCost += item.getPrice();
	}

	@Override
	public void visit(ArrayList<Product> productsList) {
		for (Product prod : productsList) {
			prod.accept(this);
		}
		System.out.println("Total Cost: $" + totalCost);
	}
	
	@Override
	public void visit(Offer offer) {
		productsList.add(offer);
		System.out.println("Offer name: " + offer.getName() + " $" + offer.getPrice()+ " Added to the cart");
		totalCost += offer.getPrice();
	}
	
	@Override
	public void visit(Product product) {
		productsList.add(product);
		System.out.println("Product name: " + product.getName() + " $" + product.getPrice() + " Added to the cart");
		totalCost += product.getPrice();
	}
	


}
