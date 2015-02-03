package shoppingcart.model.payment;

/**
 * Payment is the abstract base class for all payment transactions.
 * 
 * @author martin
 *
 */
public abstract class Payment {
	protected int number;
	protected double total;

	/**
	 * Class constructor.
	 * 
	 * @param number
	 * @param total
	 */
	public Payment(int number, double total) {
		this.number = number;
		this.total = total;
	}

	/**
	 * Returns the total amount.
	 * 
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Payment [number=" + number + ", total=" + total + "]";
	}

	/**
	 * Returns the payment transaction id number.
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}
}
