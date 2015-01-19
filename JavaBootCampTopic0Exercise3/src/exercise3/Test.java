package exercise3;


public class Test {
	public static void main(String[] args){
		
		HospitalBuilder hospitalBuilder = new SmallHospitalBuilder();
		HospitalDirector hospitalDirector = new HospitalDirector(hospitalBuilder);
		hospitalDirector.constructHospital();
		Hospital hospital = hospitalDirector.getHospital();
		System.out.println("Small Hospital: " + "\n" + hospital + "\n");
	}
}
