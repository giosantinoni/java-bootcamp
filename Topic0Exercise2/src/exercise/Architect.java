package exercise;

public class Architect {
	private IBuilder builder;
	
	public Architect(IBuilder builder) {
		this.builder = builder;
	}
	
	public void buildHouse() {		
		System.out.println("Beginning Construction.");
		
		builder.buildFloor();
		builder.buildWalls();
		builder.buildRoof();
		builder.putDoors();
		builder.putWindows();
		builder.paintBuilding();
		
		System.out.println("House finished.");
	}
	
	public House getHouse() {
		return builder.getHouse();
	}
}
