package implementations;

import interfaces.Observer;

public class Manager implements Observer{

	
	
	
	@Override
	public void doUpdate(String messege) {
		System.out.println(messege);
	}
	
	

}
