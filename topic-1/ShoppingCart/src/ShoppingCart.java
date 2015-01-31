import implementations.visitors.*;
import interfaces.IItem;

import java.util.ArrayList;

import services.Offer;

public class ShoppingCart {
	private ArrayList<IItem> items;
	private Offer offer;
	private PriceVisitor priceVisitor;
	private CashPaymentVisitor cashPaymentVisitor;
	private PayalPaymentVisitor ppPaymentVisitor;
	private CCPaymentVisitor ccPaymentVisitor;
	private DisplayItemVisitor infoItemVisitor;

	public ShoppingCart() {
		this.items = new ArrayList<IItem>();
		this.offer = new Offer("My offer", 60000.00);
		this.priceVisitor = new PriceVisitor();
		this.ccPaymentVisitor = new CCPaymentVisitor();
		this.ppPaymentVisitor = new PayalPaymentVisitor();
		this.cashPaymentVisitor = new CashPaymentVisitor();
		this.infoItemVisitor = new DisplayItemVisitor();
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

	public void displayInfoOfItems() {
		for (IItem item : items) {
			item.accept(infoItemVisitor);
		}
	}

	public void displayInformationOfOffers() {
		offer.displayInformationAboutOffer();
	}

	public void addItemToOffer(IItem item) {
		this.offer.addItem(item);
	}

	public void addOfferToOffer(Offer anotherOffer) {
		this.offer.addOffer(anotherOffer);
	}
}
