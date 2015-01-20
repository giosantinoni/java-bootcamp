package exercise;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// Non member
		Visit v1 = new Visit("Juan Perez", new Date());
		v1.setServiceExpense(100);
		v1.setProductExpense(100);
		System.out.println(v1.toString());

		// Premium Member
		Visit v2 = new Visit("Florencia Rodriguez", "Premium", new Date());
		v2.setServiceExpense(100);
		v2.setProductExpense(100);
		System.out.println(v2.toString());

		// Gold Member
		Visit v3 = new Visit("Maria Cuellar", "Gold", new Date());
		v3.setServiceExpense(100);
		v3.setProductExpense(100);
		System.out.println(v3.toString());

		// Silver Member
		Visit v4 = new Visit("Ignacio Fernandez", "Silver", new Date());
		v4.setServiceExpense(100);
		v4.setProductExpense(100);
		System.out.println(v4.toString());
	}

}
