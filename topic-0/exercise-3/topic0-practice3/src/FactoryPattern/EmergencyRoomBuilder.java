package FactoryPattern;

public class EmergencyRoomBuilder implements RoomPartBuilder {
	Room emergency = new Room();

	@Override
	public void buildColor() {
		emergency.setColor("white");
	}

	@Override
	public void buildType() {
		emergency.setType("emergency");
	}

	@Override
	public void buildRoof() {
		emergency.setType("a roof");
	}

	@Override
	public void buildDoor() {
		emergency.setDoor("a door");
	}

	@Override
	public Room getRoom() {
		return emergency;
	}

}
