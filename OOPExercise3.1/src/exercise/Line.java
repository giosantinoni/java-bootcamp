package exercise;

public class Line {
	private Point begin;
	private Point end;

	public Line(Point begin, Point end) {
		this.begin = begin;
		this.end = end;
	}

	public Line(int beginX, int beginY, int endX, int endY) {
		this.begin = new Point(beginX, beginY);
		this.end = new Point(endX, endY);
	}

	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Line [begin=" + begin.toString() + ", end=" + end.toString()
				+ "]";
	}

	public int getBeginX() {
		return begin.getX();
	}

	public void setBeginX(int x) {
		begin.setX(x);
	}

	public int getBeginY() {
		return begin.getY();
	}

	public void setBeginY(int y) {
		begin.setY(y);
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
		begin.setXY(x, y);
	}

	public void setEndXY(int x, int y) {
		end.setXY(x, y);
	}

	public int getLength() {
		double xDiff = end.getX() - begin.getX();
		double yDiff = end.getY() - begin.getY();
		return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	public double getGradient() {
		double xDiff = end.getX() - begin.getX();
		double yDiff = end.getY() - begin.getY();
		return Math.atan2(yDiff, xDiff);
	}
}
