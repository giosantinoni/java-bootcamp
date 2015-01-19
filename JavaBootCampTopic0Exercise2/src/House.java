
public class House {
	
	private String wall;
	private String door;
	private String floor;
	private String roof;
	private String window;
	public String getWall() {
		return wall;
	}
	public void setWall(String wall) {
		this.wall = wall;
	}
	public String getDoor() {
		return door;
	}
	public void setDoor(String door) {
		this.door = door;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoof() {
		return roof;
	}
	public void setRoof(String roof) {
		this.roof = roof;
	}
	public String getWindow() {
		return window;
	}
	public void setWindow(String window) {
		this.window = window;
	}
	
	public String toString(){
		return "Walls" + wall + "\n" + "Floor" + floor + "\n" + "Roof" + "\n" +
				"Doors" + door + "\n" + "Windows" + window;
	}
}
