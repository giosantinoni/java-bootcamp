package FactoryPattern;

public class Room {
	private String color;
	private String type;
	private String roof;
	private String door;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	@Override
	public String toString() {
		return "Room [color=" + color + ", type=" + type + ", roof=" + roof + ", door=" + door + "]";
	}

}
