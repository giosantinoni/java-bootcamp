
public class BrickHouseBuilder implements HouseBuilder{
	
	private House brickHouse;
	
	public BrickHouseBuilder(){
		brickHouse = new House();
	}
	
	@Override
	public void buildWall(){
		brickHouse.setWall("Brick Wall");
	}
	
	@Override
	public void buildFloor(){
		brickHouse.setFloor("Brick Floor");
	}
	
	@Override
	public void buildRoof(){
		brickHouse.setRoof("Brick's House Roof");
	}
	
	@Override
	public void buildDoor(){
		brickHouse.setDoor("Brick's House Door");
	}
	
	@Override
	public void buildWindow(){
		brickHouse.setWindow("Brick's House Window");
	}
	
	@Override 
	public House getHouse(){
		return brickHouse;
	}
}
