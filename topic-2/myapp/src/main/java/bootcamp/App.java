package bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(stdin);

		String name = null;

		System.out.println("Enter your name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		
		System.out.println("Hello " + name);
	}

}
