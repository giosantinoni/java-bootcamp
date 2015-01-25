package topic1Point1;

public class Smartphone implements Product{
	
	private String tradeMark;
	private float price;
	private float screenSize;
	
	public Smartphone(String tradeMark, float price, float screenSize){
		setTradeMark(tradeMark);
		setPrice(price);
		setScreenSize(screenSize);
	}
	
	public void setTradeMark(String tradeMark){
		this.tradeMark=tradeMark;
	}
	
	public void setPrice(float price){
		this.price=price;
	}
	
	public void setScreenSize(float screenSize){
		this.screenSize=screenSize;
	}
	
	public String getTradeMark(){
		return tradeMark;
	}
	
	public float getPrice(){
		return price;
	}
	
	public float getScreenSize(){
		return screenSize;
	}
	
	@Override
	public void accept(ShoppingCartVisitor visitor){
		visitor.visit(this);
	}
	
	
	

}
