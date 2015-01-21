public class Wall {
	private double width;
	private double high;
	private double depth;

	public Wall(double width, double high, double depth) {
		this.width = width;
		this.high = high;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "Wall [width:" + this.width + ",high:" + this.high + ",depth:" + this.depth + "]";
	}

}
