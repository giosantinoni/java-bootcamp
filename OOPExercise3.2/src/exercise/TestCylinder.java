package exercise;

public class TestCylinder {

	public static void main(String[] args) {
		Cylinder c3 = new Cylinder(2.0, 10.0);
		System.out.println("Cylinder:" + " radius=" + c3.getRadius() + " height=" + c3.getHeight() + " base area=" + c3.getArea()
				+ " volume=" + c3.getVolume());
	}
}
