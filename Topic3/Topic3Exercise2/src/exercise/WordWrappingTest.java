package exercise;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class WordWrappingTest {

	@Test
	public void testOneWordWrap() {
		IWordWrapping wordWrapping = new WordWrapping();
		String text = "If the row-length is 60 and the input string is 30.";
		
		List<String> list = wordWrapping.wrapText(text, 60);
		
		assertEquals(text, list.get(0));
	}
	
	@Test
	public void testTwoWordWrap() {
		IWordWrapping wordWrapping = new WordWrapping();
		String text = "Hello World!";
		
		List<String> list = wordWrapping.wrapText(text, 7);
		
		assertEquals("Hello", list.get(0));
		assertEquals("World!", list.get(1));
	}
	
	@Test
	public void testThreeWordWrap() {
		IWordWrapping wordWrapping = new WordWrapping();
		String text = "a b c d e f";
		
		List<String> list = wordWrapping.wrapText(text, 3);
		
		assertEquals("a b", list.get(0));
		assertEquals("c d", list.get(1));
		assertEquals("e f", list.get(2));
	}
	
	@Test
	public void testFourWordWrap() {
		IWordWrapping wordWrapping = new WordWrapping();
		String text = "Excelent";
		
		List<String> list = wordWrapping.wrapText(text, 5);
		
		assertEquals("Excel", list.get(0));
		assertEquals("ent", list.get(1));
	}

}
