package com.globant.exercise2.shoppingcart.model.interfaces;

/**
 * 
 * @author martin
 *
 */
public interface Subject {

	/**
	 * Adds a new observer into the collection.
	 * 
	 * @param observer
	 */
	public void addObserver(Observer observer);

	/**
	 * Removes an observer from the collection.
	 * 
	 * @param observer
	 */
	public void removeObserver(Observer observer);

	/**
	 * Notifies to all the observers.
	 * 
	 * @param msg
	 */
	public void doNotify(String msg);
}
