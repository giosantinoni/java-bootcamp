package exercise;

public class TestCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println(c1.toString());
		System.out.println("Perimeter: " + c1.getPerimeter() + ", Area: " + c1.getArea());
		System.out.println();
		
		Circle c2 = new Circle(2);
		System.out.println(c2.toString());
		System.out.println("Perimeter: " + c2.getPerimeter() + ", Area: " + c2.getArea());
		System.out.println();

	}

}
