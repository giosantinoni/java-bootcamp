package shoppingcart.model;

public abstract class Payment {
	private double total;
	
	public Payment(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
}
