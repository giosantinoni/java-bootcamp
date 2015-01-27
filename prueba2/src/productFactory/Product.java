package topic1Point1;

public interface Product {
	//public float price=0;
	public void accept(ShoppingCartVisitor visitor);
}
