import implementations.visitors.*;

import interfaces.IItem;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<IItem> items;
	private PriceVisitor priceVisitor;
	private CashPaymentVisitor cashPaymentVisitor;
	private PayalPaymentVisitor ppPaymentVisitor;
	private CCPaymentVisitor ccPaymentVisitor;

	public ShoppingCart() {
		this.items 					= new ArrayList<IItem>();
		this.priceVisitor 			= new PriceVisitor();
		this.ccPaymentVisitor 		= new CCPaymentVisitor();
		this.ppPaymentVisitor 		= new PayalPaymentVisitor();
		this.cashPaymentVisitor 	= new CashPaymentVisitor();
	}

	public void addItem(IItem item) {
		this.items.add(item);
	}

	public double getTotalPrice() {
		for (IItem item : items) {
			item.accept(priceVisitor);
		}
		return priceVisitor.getTotalPrice();
	}
	
	public double getTotalPriceCC() {
		for (IItem item : items) {
			item.accept(ccPaymentVisitor);
		}
		return ccPaymentVisitor.getTotalPrice();
	}
	
	public double getTotalPricePaypal() {
		for (IItem item : items) {
			item.accept(ppPaymentVisitor);
		}
		return ppPaymentVisitor.getTotalPrice();
	}

	public double getTotalPriceCash() {
		for (IItem item : items) {
			item.accept(cashPaymentVisitor);
		}
		return cashPaymentVisitor.getTotalPrice();
	}
}
