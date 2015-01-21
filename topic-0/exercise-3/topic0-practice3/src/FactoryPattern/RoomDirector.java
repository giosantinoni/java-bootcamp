package FactoryPattern;

public class RoomDirector {
	private RoomBuilder roomBuilder = null;

	public RoomDirector(RoomBuilder roomBuilder) {
		this.roomBuilder = roomBuilder;
	}

	public void buildRoom() {
		roomBuilder.buildColor();
		roomBuilder.buildType();
		roomBuilder.buildRoof();
		roomBuilder.buildDoor();
	}

	public Room getRoom() {
		return roomBuilder.getRoom();
	}
}
