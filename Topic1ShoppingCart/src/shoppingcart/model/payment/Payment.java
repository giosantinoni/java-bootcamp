package shoppingcart.model.payment;

public abstract class Payment {
	protected int number;
	protected double total;
	
	public Payment(int number, double total) {
		this.number = number;
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Payment [number=" + number + ", total=" + total + "]";
	}

	public int getNumber() {
		return number;
	}
}
