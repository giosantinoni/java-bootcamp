package interfaces;

import productFactory.Product;
import transactionFactory.Transaction;


public interface Subject{
	
	public void addObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	 
	public void doNotify(Product product);
	
	public void doNotify(Transaction transaction);
	
	public void doNotify();

}
