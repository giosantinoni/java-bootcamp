package topic1Point1;
import java.util.*;

public class Test {

	public static void main(String args[]){
		
		LedTV tv1 = new LedTV("LG",800);
		LedTV tv2 = new LedTV("Samsung",700);
		Smartphone phone1 = new Smartphone("HTC",650.2f,5);
		Smartphone phone2 = new Smartphone("Sony",400,4);
		
		ArrayList<Product> productsList = new ArrayList<Product>();
		productsList.add(tv1);
		productsList.add(tv2);
		productsList.add(phone1);
		productsList.add(phone2);
		
		ShoppingCartVisitor shoppingCart = new ShoppingCart();
		shoppingCart.visit(productsList);
	}
}
