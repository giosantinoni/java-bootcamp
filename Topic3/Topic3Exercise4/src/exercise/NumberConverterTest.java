package exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberConverterTest {

	@Test
	public void testRomanToInt() {
		INumberConverter converter = new NumberConverter();
		
		String roman = "MMXIV";
		int result = converter.romanToInt(roman);
		
		assertEquals(2014, result);
	}

}
