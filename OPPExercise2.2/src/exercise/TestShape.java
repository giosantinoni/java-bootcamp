package exercise;

public class TestShape {

	public static void main(String[] args) {
		Circle circle = new Circle(10, "green", true);
		System.out.println(circle.toString());
		System.out.println( "Perimeter=" + circle.getPerimeter() + ", Area=" + circle.getArea() );
		System.out.println();
		
		Rectangle rectangle = new Rectangle(2, 3, "blue", true);
		System.out.println(rectangle.toString());
		System.out.println( "Perimeter=" + rectangle.getPerimeter() + ", Area=" + rectangle.getArea() );
		System.out.println();
		
		Square square = new Square(2, "yellow", false);
		System.out.println(square.toString());
		System.out.println( "Perimeter=" + square.getPerimeter() + ", Area=" + square.getArea() );
		System.out.println();
	}

}
