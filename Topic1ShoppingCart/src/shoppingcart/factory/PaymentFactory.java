package shoppingcart.factory;

import shoppingcart.model.payment.Cash;
import shoppingcart.model.payment.CreditCard;
import shoppingcart.model.payment.Payment;
import shoppingcart.model.payment.Paypal;

public class PaymentFactory {
	private static PaymentFactory instance = new PaymentFactory();
	private int counter;
	
	private PaymentFactory() {
		counter = 0;
	}

	public static PaymentFactory getInstance() {
		return instance;
	}

	public Payment getPayment(String type, double total, String data1, String data2) {		
		switch (type) {
		case "CreditCard":
			return new CreditCard(++counter, total, data1, data2);
		case "Paypal":
			return new Paypal(++counter, total, data1, data2);
		default:
			return new Cash(++counter, total);
		}
	}
}
