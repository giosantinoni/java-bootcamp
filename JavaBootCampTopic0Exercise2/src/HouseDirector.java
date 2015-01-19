
public class HouseDirector {

	private HouseBuilder houseBuilder=null;
	
	public HouseDirector(HouseBuilder houseBuilder){
		this.houseBuilder=houseBuilder;
	}
	
	public void constructHouse(){
		houseBuilder.buildFloor();
		houseBuilder.buildWall();
		houseBuilder.buildDoor();
		houseBuilder.buildWindow();
		houseBuilder.buildRoof();
	}
	
	public House getHouse(){
		return houseBuilder.getHouse();
	}
}
