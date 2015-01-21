public class TestMyPoint {

	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(3, 0);
		MyPoint p2 = new MyPoint(0, 4);

		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(5, 6));

		p1.setX(4);
		p1.setY(1);
		p2.setXY(1, 5);

		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(5, 7));

		// 2
		MyPoint[] points = new MyPoint[10];
		for (int j = 0; j < points.length; j++) {
			points[j] = new MyPoint(j + 1, j + 1);
			System.out.println(points[j].toString());
		}
	}
}
