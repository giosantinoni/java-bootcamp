package exercise3;

public class IntensiveCareWardBuilder implements RoomBuilder {
Room intensiveCareWard= new Room();
	
	@Override
	public void buildWall() {
		intensiveCareWard.setWall("Intensive Care Ward Walls");
	}
	@Override
	public void buildFloor() {
		intensiveCareWard.setFloor("Intensive Care Ward Floor");
	}
	@Override
	public void buildRoof() {
		intensiveCareWard.setRoof("Intensive Care Ward Roof");
	}
	@Override
	public void buildDoor() {
		intensiveCareWard.setDoor("Intensive Care Ward Doors");
	}
	@Override
	public void buildWindow() {
		intensiveCareWard.setWindow("Intensive Care Ward Windows");
	}
	@Override
	public void AssingName() {
		intensiveCareWard.setName("Intensive Care Ward");
	}
	
	@Override
	public Room getRoom(){
		return intensiveCareWard;
	}


}
