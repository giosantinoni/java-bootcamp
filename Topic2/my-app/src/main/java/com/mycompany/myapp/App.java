package com.mycompany.myapp;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(input);

	String name = "";

	System.out.println("Please, enter your name: ");

	try {
		name = br.readLine();
	} catch (IOException ex) {
		System.out.println(ex.getMessage());
	}

	if (name != "")
		System.out.println("Hello " + name);
    }
}
