package exercise;

public class Test {

	public static void main(String[] args) {
		IBuilder builder = new Builder();
		
		Architect architect = new Architect(builder);
		architect.buildHouse();
		
		House house = architect.getHouse();
		System.out.println(house);

	}

}
