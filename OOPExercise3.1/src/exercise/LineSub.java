package exercise;

public class LineSub extends Point {
	private Point end;

	public LineSub(int beginX, int beginY, int endX, int endY) {
		super(beginX, beginY);
		this.end = new Point(endX, endY);
	}
	
	public LineSub(Point begin, Point end) {
		super(begin.getX(), begin.getY());
		this.end = end;
	}

	public Point getBegin() {
//		return new Point(super.getX(), super.getY());
		return this;
	}

	public void setBegin(Point begin) {
		super.setXY(begin.getX(), begin.getY());
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Line [begin=" + super.toString() + ", end=" + end.toString()
				+ "]";
	}

	public int getBeginX() {
		return super.getX();
	}

	public void setBeginX(int x) {
		super.setX(x);
	}

	public int getBeginY() {
		return super.getY();
	}

	public void setBeginY(int y) {
		super.setY(y);
	}

	public int getEndX() {
		return end.getX();
	}

	public void setEndX(int x) {
		end.setX(x);
	}

	public int getEndY() {
		return end.getY();
	}

	public void setEndY(int y) {
		end.setY(y);
	}

	public void setBeginXY(int x, int y) {
		super.setXY(x, y);
	}

	public void setEndXY(int x, int y) {
		end.setXY(x, y);
	}

	public int getLength() {
		double xDiff = end.getX() - super.getX();
		double yDiff = end.getY() - super.getY();
		return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	public double getGradient() {
		double xDiff = end.getX() - super.getX();
		double yDiff = end.getY() - super.getY();
		return Math.atan2(yDiff, xDiff);
	}
}
