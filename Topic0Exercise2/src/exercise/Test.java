package exercise;

public class Test {

	public static void main(String[] args) {
		IBuilder builder = new Builder();
		House h1 = builder.buildHouse();
		System.out.println(h1 + "\n");
		
		House h2 = builder.buildHouse();
		System.out.println(h2);

	}

}
