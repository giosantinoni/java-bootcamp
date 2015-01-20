public class MyCircle {
	private MyPoint center;
	private int radius = 1;

	public MyCircle(int x, int y, int radius) {
		this.center.setXY(x, y);
		this.radius = radius;
	}

	public MyCircle(MyPoint center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return center;
	}

	public void setCenter(MyPoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getCenterX() {
		return this.center.getX();
	}

	public int getCenterY() {
		return this.center.getY();
	}

	public void setCenterXY(int x, int y) {
		this.center.setXY(x, y);
	}

	@Override
	public String toString() {
		return "Circle @" + this.center.toString() + " radius=" + this.getRadius();
	}

	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}

}
