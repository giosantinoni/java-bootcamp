package FactoryPattern;

public class TherapyRoomBuilder extends RoomPartBuilder {
	Room therapy = new Room();

	@Override
	public void buildColor() {
		therapy.setColor("white");
	}

	@Override
	public void buildType() {
		therapy.setType("therapy");
	}

	@Override
	public void buildRoof() {
		therapy.setType("a roof");
	}

	@Override
	public void buildDoor() {
		therapy.setDoor("a door");
	}

	@Override
	public Room getRoom() {
		return therapy;
	}

}
