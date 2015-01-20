package exercise;

public class Circle implements GeometricObject {
	protected double radius;
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {		
		return 2 * Math.PI * radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

}
