package exercise4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _RomanNumbers {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending");
	}
	
	@Test
	public void IntToRomanTest() {
		RomanNumbers toRoman = new RomanNumbers();
		int number= 1212;
		String string = toRoman.IntToRoman(number);
		System.out.println(string);
	}
}
