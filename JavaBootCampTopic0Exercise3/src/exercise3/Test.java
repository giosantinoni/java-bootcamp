package exercise3;

public class Test {
	
	public static void main(String[] args){
		
		BuildingFactory buildingFactory= new BuildingFactory();
		
		Building hospital = buildingFactory.getBuilding("Hospital", "Hospital Avellaneda");
		System.out.println(hospital);
	}

}
