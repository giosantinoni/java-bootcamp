package exercise;

public class Room {
	private boolean floor;
	private boolean walls;
	private boolean roof;
	private boolean doors;
	private boolean windows;
	private boolean painted;	
	
	public Room() {
		floor = false;
		walls = false;
		roof = false;
		doors = false;
		windows = false;
		painted = false;
	}

	public boolean isFloor() {
		return floor;
	}

	public void setFloor(boolean floor) {
		this.floor = floor;
	}

	public boolean isWalls() {
		return walls;
	}

	public void setWalls(boolean walls) {
		this.walls = walls;
	}

	public boolean isRoof() {
		return roof;
	}

	public void setRoof(boolean roof) {
		this.roof = roof;
	}

	public boolean isDoors() {
		return doors;
	}

	public void setDoors(boolean doors) {
		this.doors = doors;
	}

	public boolean isWindows() {
		return windows;
	}

	public void setWindows(boolean windows) {
		this.windows = windows;
	}

	public boolean isPainted() {
		return painted;
	}

	public void setPainted(boolean painted) {
		this.painted = painted;
	}

	@Override
	public String toString() {
		return "House [floor=" + floor + ", walls=" + walls + ", roof=" + roof + ", doors=" + doors + ", windows=" + windows + ", painted="
				+ painted + "]";
	}
}
