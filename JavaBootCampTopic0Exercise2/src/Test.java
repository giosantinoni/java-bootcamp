
public class Test {
	
	public static void main(String[] args){
	
		HouseBuilder houseBuilder = new BrickHouseBuilder();
		HouseDirector houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House house = houseDirector.getHouse();
		System.out.println("Brick House: " + house + "\n");
	}
	
}
