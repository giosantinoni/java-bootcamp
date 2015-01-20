package exercise;

public class Builder implements IBuilder {
	
	/**
	 * Returns a new instance of <code>House</code>.
	 * @return
	 */
	@Override
	public House buildHouse() {
		House house = new House();
		
		System.out.println("Beginning Construction.");
		
		System.out.println("Building floor.");
		house.setFloor(true);
		
		System.out.println("Building walls.");
		house.setWalls(true);
		
		System.out.println("Building roof.");
		house.setRoof(true);
		
		System.out.println("Putting doors.");
		house.setDoors(true);
		
		System.out.println("Putting windows.");
		house.setWindows(true);
		
		System.out.println("Painting house.");
		house.setPainted(true);
		
		System.out.println("House finished.");
		
		return house;
	}

}
