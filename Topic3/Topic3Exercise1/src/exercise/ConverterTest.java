package exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void testAmountToText() {
		Converter converter = new Converter();
		String result = converter.amountToText(2523.04);
		assertEquals("two thousand five hundred twenty-three and 04/100 dollars", result);
	}

}
