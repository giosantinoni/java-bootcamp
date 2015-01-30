package transactions;

import shop.ShoppingCart;
import notifications.Observer;
import notifications.Subject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import products.Product;

public class TransactionFactory implements Subject {

	private static TransactionFactory transactionFactory;

	private Set<Observer> transactionFactoryObservers;

	private TransactionFactory() {
		transactionFactoryObservers = new HashSet<Observer>();

	}

	public static TransactionFactory getInstance() {
		if (transactionFactory == null) {
			transactionFactory = new TransactionFactory();
		}
		return transactionFactory;
	}

	public Transaction getTransaction(String transactionType, ShoppingCart shoppingCart) {

		switch (transactionType) {

		case "CREDIT_CARD":
			if (shoppingCart.getUser().getName() != null && shoppingCart.getUser().getCardNumber() != 0) {
				Transaction creditCard = new CreditCard(shoppingCart);
				doNotify(creditCard);
				return creditCard;
			} else {
				break;
			}

		case "PAYPAL":
			if (shoppingCart.getUser().getEmail() != null || shoppingCart.getUser().getPassword() != null) {
				Transaction paypal = new PayPal(shoppingCart);
				doNotify(paypal);
				return paypal;
			} else {
				break;
			}

		default:
			Transaction cash = new Cash(shoppingCart);
			doNotify(cash);
			return cash;
		}
		System.out.println("Can not complete transaction: missing information requierend");
		return null;

	}

	// Subject methods Override
	@Override
	public void addObserver(Observer observer) {
		transactionFactoryObservers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		transactionFactoryObservers.remove(observer);

	}

	@Override
	public void doNotify(Transaction transaction) {
		Iterator<Observer> iterator = transactionFactoryObservers.iterator();
		while (iterator.hasNext()) {
			Observer transactionFactoryObserver = iterator.next();
			transactionFactoryObserver.doUpdate("A Transaction with transaction number [" + transaction.getTransactionNumber()
					+ "] was completed");
		}
	}

	@Override
	public void doNotify(Product product) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doNotify() {
		// TODO Auto-generated method stub
	}

}
