package topic1Point1;

public class LedTV implements Product {
	
	private String tradeMark;
	private float price;
	
	public LedTV(String tradeMark, float price){
		setTradeMark(tradeMark);
		setPrice(price);
	}
	
	public void setTradeMark(String tradeMark){
		this.tradeMark=tradeMark;
	}
	
	public void setPrice(float price){
		this.price=price;
	}
	
	public String getTradeMark(){
		return tradeMark;
	}
	
	public float getPrice(){
		return price;
	}
	
	@Override
	public void accept(ShoppingCartVisitor visitor){
		visitor.visit(this);
	}
	
	
}
