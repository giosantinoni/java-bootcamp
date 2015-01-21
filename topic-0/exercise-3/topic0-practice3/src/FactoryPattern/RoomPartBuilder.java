package FactoryPattern;

public interface RoomPartBuilder {
	public void buildColor();

	public void buildType();

	public void buildRoof();

	public void buildDoor();

	public Room getRoom();

}
