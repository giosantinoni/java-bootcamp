public class Room {
	private String color;
	private double m2; // meters square

	public Room(String color, double m2) {
		this.color = color;
		this.m2 = m2;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Room [color=" + this.color + ", m2=" + this.m2 + "]";
	}

}
