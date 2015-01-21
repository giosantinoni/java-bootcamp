package shoppingcart.services;

import shoppingcart.model.CreditCard;
import shoppingcart.model.Payment;
import shoppingcart.model.Paypal;

public class PaymentFactory {
	private static PaymentFactory instance = new PaymentFactory();

	private PaymentFactory() {
	}

	public static PaymentFactory getInstance() {
		return instance;
	}

	public Payment getPayment(String type, double total, String data1, String data2) {
		switch (type) {
		case "CreditCard":
			return new CreditCard(total, data1, data2);
		case "Paypal":
			return new Paypal(total, data1, data2);
		default:
			return null;
		}
	}
}
