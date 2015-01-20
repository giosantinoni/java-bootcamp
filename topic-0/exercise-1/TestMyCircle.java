public class TestMyCircle {

	public static void main(String[] args) {
		MyPoint center = new MyPoint(3, 3);
		MyCircle aCircle = new MyCircle(center, 2);

		System.out.println(aCircle.toString());
		System.out.println(aCircle.getArea());

		center.setXY(4, 4);
		aCircle.setRadius(3);

		System.out.println(aCircle.toString());
		System.out.println(aCircle.getArea());

	}

}
