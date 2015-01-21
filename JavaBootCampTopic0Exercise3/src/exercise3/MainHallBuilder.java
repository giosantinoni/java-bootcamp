package exercise3;

public class MainHallBuilder implements RoomBuilder {
	
	Room mainHall= new Room();
	
	@Override
	public void buildWall() {
		mainHall.setWall("Main Hall Walls");
	}
	@Override
	public void buildFloor() {
		mainHall.setFloor("Main Hall Floor");
	}
	@Override
	public void buildRoof() {
		mainHall.setRoof("Main Hall Roof");
	}
	@Override
	public void buildDoor() {
		mainHall.setDoor("Main Hall Doors");
	}
	@Override
	public void buildWindow() {
		mainHall.setWindow("Main Hall Windows");
	}
	@Override
	public void AssingName() {
		mainHall.setName("Main Hall");
	}
	
	@Override
	public Room getRoom(){
		return mainHall;
	}

}
