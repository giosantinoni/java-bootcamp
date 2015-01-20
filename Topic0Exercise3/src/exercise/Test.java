package exercise;

public class Test {

	public static void main(String[] args) {	
		
		IArchitect architect = new Architect();
		architect.buildHospital();
		
		Hospital hospital = architect.getHospital();
		System.out.println(hospital);

	}

}
