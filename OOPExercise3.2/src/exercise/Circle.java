package exercise;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		radius = 1.0;
		color = "red";
	}
	
	public Circle(double radius) {
		this.radius = radius;
		color = "red";
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Circle: radius=" + radius + " color=" + color;
	}
}
