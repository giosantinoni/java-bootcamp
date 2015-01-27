package topic1Point1;
import java.util.List;


public class ShoppingCart implements ShoppingCartVisitor{
	
	float totalCost;
	
	@Override 
	public void visit(LedTV ledTV){
		System.out.println(ledTV.getTradeMark() + " LedTV" + " $" + ledTV.getPrice() );
		totalCost += ledTV.getPrice();
	}
	
	@Override 
	public void visit(Smartphone smartphone){
		System.out.println(smartphone.getTradeMark() + " Smartphone" + " $" + smartphone.getPrice());
		totalCost += smartphone.getPrice();
	}
	
	@Override
	public void visit(List<Product> productsList){
		for(Product prod: productsList){
			prod.accept(this);
		}
		System.out.println("Total Cost: $" + totalCost);
	}


}
