package exercise;

public class Builder implements IBuilder {
	private Room room;
	
	public Builder() {
		room = new Room();
	}
	
	@Override
	public void buildFloor() {
		System.out.println("Building floor.");
		room.setFloor(true);
	}

	@Override
	public void buildWalls() {
		System.out.println("Building walls.");
		room.setWalls(true);
	}

	@Override
	public void buildRoof() {
		System.out.println("Building roof.");
		room.setRoof(true);
	}

	@Override
	public void putDoors() {
		System.out.println("Putting doors.");
		room.setDoors(true);
	}

	@Override
	public void putWindows() {
		System.out.println("Putting windows.");
		room.setWindows(true);
	}

	@Override
	public void paint() {
		System.out.println("Painting house.");
		room.setPainted(true);
	}
	
	@Override
	public Room getRoom() {
		return room;
	}

}
