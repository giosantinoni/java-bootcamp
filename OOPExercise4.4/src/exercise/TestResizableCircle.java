package exercise;

public class TestResizableCircle {

	public static void main(String[] args) {
		ResizableCircle r1 = new ResizableCircle(10);
		System.out.println(r1.toString());
		System.out.println("Perimeter: " + r1.getPerimeter() + ", Area: " + r1.getArea());
		r1.resize(25);
		System.out.println(r1.toString());
		System.out.println("Perimeter: " + r1.getPerimeter() + ", Area: " + r1.getArea());
		System.out.println();

	}

}
