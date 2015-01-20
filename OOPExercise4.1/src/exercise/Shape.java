package exercise;

public abstract class Shape {
	protected String color;
	protected boolean filled;
	
	public Shape() {
		color = "red";
		filled = true;
	}
	
	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public abstract double getPerimeter();
	public abstract double getArea();

	@Override
	public String toString() {
		String msg = "filled";
		
		if (!filled)
			msg = "Not filled";
		
		return "A Shape with color of " + color + " and " + msg;
	}
}
