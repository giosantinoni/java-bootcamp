package exercise5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _Soundex {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending");
	}

	@Test
	public void SoundexTest() {
	    String string = "Hello";
	    Soundex soundex = new Soundex();
        String sound = soundex.SoundexConverter(string);
        System.out.println("\""+ string + "\" in soundex codification is: " + sound);
	}
}
