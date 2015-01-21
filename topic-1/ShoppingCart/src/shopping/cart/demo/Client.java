package shopping.cart.demo;

import java.util.Scanner;
import shopping.cart.interfaces.*;
import shopping.cart.visitor.*;
import shopping.cart.items.*;

public class Client {

	public static void main(String[] args) {
		double total;
		ShoppingCartItem[] items = new ShoppingCartItem[] { new Computer("Toshiba", 10000), new Tablet("Nexus 10", 12000) };

		total = getTotal(items);

		Scanner keyboard = new Scanner(System.in);
		System.out.println("[1] - Credit Card");
		System.out.println("[2] - Paypal");
		System.out.println("[3] - Cash");
		System.out.println();
		System.out.println("how you want to pay?");
		int payOption = keyboard.nextInt();

		if (payOption == 1) {
			System.out.println("Client: John Doe and Credit Card: 987896576554541234");
		} else if (payOption == 2) {
			System.out.println("email: johndoe@mail.com and password: JonDow98$");
		} else {
			System.out.println("Cash payment");
		}

		System.out.println("Total: " + total);
		
		keyboard.close();

	}

	private static double getTotal(ShoppingCartItem[] items) {
		ShoppingCartVisitor visitor = new ShoppingCart();
		double sum = 0;

		for (ShoppingCartItem item : items) {
			sum += item.accept(visitor);
		}
		return sum;
	}

}
