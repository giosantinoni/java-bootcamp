package bootcamp;

import implementations.products.Computer;
import implementations.products.Tablet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.Offer;

public class App 
{
    private static ApplicationContext cntx;

	public static void main( String[] args )
    {
    	cntx = new ClassPathXmlApplicationContext("/src/application-context.xml");
		
		Client john = (Client) cntx.getBean("my-client");
		ShoppingCart cart = (ShoppingCart) cntx.getBean("my-shopping-cart");
		
		john.setName("John Doe");
		john.setEmail("jdoe@mail.com");
		john.setCc("1234-4321-1234-4321");
		john.setEmailPass("AaBb12");
		john.setPaypalPass("ZzXx21");

		cart.addItem(new Computer("Toshiba", 1000.00));
		cart.addItem(new Computer("Lenovo", 2000.00));
		cart.addItem(new Tablet("Asus", 3000.00));
		cart.addItem(new Tablet("Motorola", 4000.00));

		System.out.println("Total to pay: " + cart.getTotalPrice());

		// credit card payment.
		System.out.println("Credit Card Payment:");
		System.out.println("\tClient name: " + john.getName());
		System.out.println("\tCC number: " + john.getCc());
		System.out.println("\tTotal to pay with cc : " + cart.getTotalPriceCC());

		// paypal payment
		System.out.println("Paypal Payment:");
		System.out.println("\tClient email: " + john.getEmail());
		System.out.println("\tEmail password: " + john.getEmailPass());
		System.out.println("\tTotal to pay with paypal: " + cart.getTotalPricePaypal());

		// cash payment;
		System.out.println("Credit Card Payment:");
		System.out.println("\tNo information required");
		System.out.println("\tTotal to pay with cash: " + cart.getTotalPriceCash());

		// displaying information
		cart.displayInfoOfItems();
		
		// Offers
		System.out.println("");
		cart.addItemToOffer(new Computer("Dell",15000.00));
		cart.addItemToOffer(new Tablet("Xoom", 5000.00));
		
		Offer anotherOffer = new Offer("0002", 40000.00);
		anotherOffer.addItem(new Computer("iMac", 25000.00));
		anotherOffer.addItem(new Tablet("iPad", 20000.00));
		
		cart.addOfferToOffer(anotherOffer);
		
		cart.displayInformationOfOffers();

    }
}
