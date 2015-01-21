package demo;

public class Main {

	public static void main(String[] args) {
		
		Factory factory = new Factory();
		Building hospital = Factory.getBuilding();
		System.out.println(hospital); //output: Hospital

	}

}
