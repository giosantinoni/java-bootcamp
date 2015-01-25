package interfaces;

import productFactory.Product;


public interface Observer {
	
	/*
	public void doUpdate(Product product);
	
	public void doUpdate(int transactionNumber);
	
	public void doUpdate(double price);
	*/
	public void doUpdate(String messege);

}
