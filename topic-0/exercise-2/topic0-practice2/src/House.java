public class House {

	private Wall walls;
	private Ceiling ceiling;
	private Foundation foundation;
	private Room room;

	public void setWalls(Wall walls) {
		this.walls = walls;
	}

	public void setCeiling(Ceiling ceiling) {
		this.ceiling = ceiling;
	}

	public void setFoundation(Foundation foundation) {
		this.foundation = foundation;
	}

	public void setRomm(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "House [" + this.walls + "," + this.ceiling + "," + this.foundation + "," + this.room + "]";
	}

}
