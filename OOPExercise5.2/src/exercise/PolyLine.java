package exercise;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
	private List<Point> points;

	public PolyLine() {
		points = new ArrayList<Point>();
	}

	public PolyLine(List<Point> points) {
		this.points = points;
	}

	public void appendPoint(int x, int y) {
		Point point = new Point(x, y);
		points.add(point);
	}

	public void appendPoint(Point point) {
		points.add(point);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Point aPoint : points)
			sb.append(aPoint.toString());

		return sb.toString();
	}
}
