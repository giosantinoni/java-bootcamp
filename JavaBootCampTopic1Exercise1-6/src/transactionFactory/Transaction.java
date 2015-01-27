package transactionFactory;

import implementations.ShoppingCart;

public abstract class Transaction {
	
	protected double total;
	protected double totalWithDiscount;
	protected static int transactionNumber;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotalWithDiscount() {
		return totalWithDiscount;
	}
	public void setTotalWithDiscount(double totalWithDiscount) {
		this.totalWithDiscount = totalWithDiscount;
	}
	public static int getTransactionNumber() {
		return transactionNumber;
	}
	public static void setTransactionNumber(int transactionNumber) {
		Transaction.transactionNumber = transactionNumber;
	}
	
	public void calculateDiscount(){
		
	}
	
	public void calculateDiscount(ShoppingCart shoppingCart){
		
	}
	@Override
	public String toString() {
		return "Transaction [total=" + total + ", totalWithDiscount=" + totalWithDiscount + "]";
	}
	
	
	

}
