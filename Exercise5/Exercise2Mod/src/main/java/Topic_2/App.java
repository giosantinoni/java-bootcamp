package Topic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
	 * Exercise 1 Topic 2
	 *
	 */
	public static void main(String[] args) {

	    String name= "";
	 
	    System.out.println( "Please enter yourn name:" ); 
	    try { 
	      BufferedReader Buff= 
	        new BufferedReader(new InputStreamReader(System.in));   
	      name= Buff.readLine(); 
	    }
	    catch (IOException e) {}
	    System.out.println( "Hi! ," + name);
	}
}