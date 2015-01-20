package exercise;

public class Builder implements IBuilder {
	private House house;
	
	public Builder() {
		house = new House();
	}
	
	@Override
	public void buildFloor() {
		System.out.println("Building floor.");
		house.setFloor(true);
	}

	@Override
	public void buildWalls() {
		System.out.println("Building walls.");
		house.setWalls(true);
	}

	@Override
	public void buildRoof() {
		System.out.println("Building roof.");
		house.setRoof(true);
	}

	@Override
	public void putDoors() {
		System.out.println("Putting doors.");
		house.setDoors(true);
	}

	@Override
	public void putWindows() {
		System.out.println("Putting windows.");
		house.setWindows(true);
	}

	@Override
	public void paintBuilding() {
		System.out.println("Painting house.");
		house.setPainted(true);
	}
	
	@Override
	public House getHouse() {
		return house;
	}

}
