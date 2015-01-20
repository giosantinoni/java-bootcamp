public class ConcreteHouseBuilder implements HouseBuilder {
	private House house;

	public ConcreteHouseBuilder() {
		this.house = new House();
	}

	public void buildWall() {
		this.house.setWalls(new Wall(0.25, 0.25, 7));
	}

	public void buildCeiling() {
		this.house.setCeiling(new Ceiling("gabled"));
	}

	public void buildFoundation() {
		this.house.setFoundation(new Foundation(45));
	}

	public void buildRoom() {
		this.house.setRomm(new Room("white", 16));
	}

	public House getHouse() {
		return this.house;
	}

}
