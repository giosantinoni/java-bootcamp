package exercise1;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _AmountToText {

	@Before
	public void setUp() throws Exception {
		System.out.println("Start Test...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finish Test.");
	}

	@Test
	public void AmountToTextTest() {
		double amount = 9919.11;
		AmountToText amountToText = new AmountToText();
		String text = amountToText.convertToText(amount);
		System.out.println(text);
	}
	
	@Test
	public void convertionTableTest(){
		AmountToText amountToText = new AmountToText();
		int number= 1;
		int position=5;
		System.out.println(amountToText.convertionTable(number,position));
	}

}
