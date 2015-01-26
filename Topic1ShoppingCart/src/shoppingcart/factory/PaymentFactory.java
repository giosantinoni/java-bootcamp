package shoppingcart.factory;

import java.util.HashSet;
import java.util.Set;

import shoppingcart.model.interfaces.Observer;
import shoppingcart.model.interfaces.Subject;
import shoppingcart.model.payment.Cash;
import shoppingcart.model.payment.CreditCard;
import shoppingcart.model.payment.Payment;
import shoppingcart.model.payment.Paypal;

public class PaymentFactory implements Subject {
	private static PaymentFactory instance = new PaymentFactory();
	private int counter;
	private Set<Observer> observers;
	
	private PaymentFactory() {
		counter = 0;
		observers = new HashSet<Observer>();
	}

	public static PaymentFactory getInstance() {
		return instance;
	}

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
		for (Observer observer: observers)
			observer.update(msg);
	}
}
