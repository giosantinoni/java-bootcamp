package products;

import notifications.Observer;
import notifications.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import transactions.Transaction;

public class ProductFactory implements Subject{
	
	private static ProductFactory productFactory = null;
	
	private static ArrayList<Product> productsList;
	
	private Set<Observer> productFactoryObservers;
	
	private ProductFactory() {
		productFactoryObservers =  new HashSet<Observer>(); 
	}
	
	public static ProductFactory getInstance(){
		if(productFactory == null) {
			productFactory = new ProductFactory();
			productsList = new ArrayList<Product>();
		}
		return productFactory;
	}
	
	public void setProducts(Product product) {
		productsList.add(product);
		doNotify(product);
	}
	
	
	
	public Product getProduct(String productName) throws Exception {
		for(Product prod : productsList){
			if(prod.getName().equals(productName)) {
				return prod;
			}
		}
		throw new Exception("The item " + productName + " do not exists");
	}

	// Subject methods Override
	@Override
	public void addObserver(Observer productFactoryObserver) {
		productFactoryObservers.add(productFactoryObserver);
	}

	@Override
	public void removeObserver(Observer productFactoryObserver) {
		productFactoryObservers.remove(productFactoryObserver);
	}

	

	@Override
	public void doNotify(Product product) {
		Iterator<Observer> iterator = productFactoryObservers.iterator();
		while(iterator.hasNext()){
			Observer productFactoryObserver = iterator.next();
			productFactoryObserver.doUpdate("Product: " + product.getName() + " created");
		}
	}

	@Override
	public void doNotify(Transaction transaction) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doNotify() {
		// TODO Auto-generated method stub
	}
	
	
	
	
		
}
