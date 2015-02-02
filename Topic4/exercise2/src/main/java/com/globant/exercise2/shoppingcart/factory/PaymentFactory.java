package com.globant.exercise2.shoppingcart.factory;

import java.util.HashSet;
import java.util.Set;

import com.globant.exercise2.shoppingcart.model.interfaces.Observer;
import com.globant.exercise2.shoppingcart.model.interfaces.Subject;
import com.globant.exercise2.shoppingcart.model.payment.Cash;
import com.globant.exercise2.shoppingcart.model.payment.CreditCard;
import com.globant.exercise2.shoppingcart.model.payment.Payment;
import com.globant.exercise2.shoppingcart.model.payment.Paypal;

/**
 * 
 * @author martin
 *
 */
public class PaymentFactory implements Subject {
	private static PaymentFactory instance = new PaymentFactory();
	private int counter;
	private Set<Observer> observers;

	/**
	 * Class constructor.
	 */
	private PaymentFactory() {
		counter = 0;
		observers = new HashSet<Observer>();
	}

	/**
	 * Returns the unique instance of the class <code>PaymentFactory</code>.
	 * 
	 * @return
	 */
	public static PaymentFactory getInstance() {
		return instance;
	}

	/**
	 * Returns a new payment.
	 * 
	 * @param type
	 * @param total
	 * @param data1
	 * @param data2
	 * @return
	 */
	public Payment getPayment(String type, double total, String data1, String data2) {
		Payment payment = null;

		switch (type) {
		case "CreditCard":
			payment = new CreditCard(++counter, total, data1, data2);
			break;
		case "Paypal":
			payment = new Paypal(++counter, total, data1, data2);
			break;
		default:
			payment = new Cash(++counter, total);
			break;
		}

		doNotify("New payment: " + payment.toString());

		return payment;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void doNotify(String msg) {
		for (Observer observer : observers)
			observer.update(msg);
	}
}
