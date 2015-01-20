package exercise;

public class Circle extends Shape {
	protected double radius;
	
	public Circle() {
		radius = 1.0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
	}
}
