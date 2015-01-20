package exercise3;

public class RoomDirector {
	
	private RoomBuilder roomBuilder = null;
	
	public RoomDirector(RoomBuilder roomBuilder){
		this.roomBuilder=roomBuilder;
	}
	
	public void constructRoom() {
		roomBuilder.buildFloor();
		roomBuilder.buildWall();
		roomBuilder.buildDoor();
		roomBuilder.buildWindow();
		roomBuilder.buildRoof();
		roomBuilder.AssingName();
	}
	
	public Room getRoom(){
		return roomBuilder.getRoom();
	}
}
