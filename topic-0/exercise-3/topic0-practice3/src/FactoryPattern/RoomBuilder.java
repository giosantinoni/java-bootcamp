package FactoryPattern;

public class RoomBuilder implements RoomPartBuilder {
	private Room room;

	public RoomBuilder() {
		room = new Room();
	}

	@Override
	public void buildColor() {
		room.setColor("white");
	}

	@Override
	public void buildType() {
		room.setType("Single");
		;
	}

	@Override
	public void buildRoof() {
		room.setType("a roof");
		;
	}

	@Override
	public void buildDoor() {
		room.setDoor("a door");
		;
	}

	@Override
	public Room getRoom() {
		return room;
	}

}
