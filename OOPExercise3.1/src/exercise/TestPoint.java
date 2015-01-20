package exercise;

public class TestPoint {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		System.out.println(p1);
		
		p1.setX(100);
		p1.setY(20);
		System.out.println(p1);
		
		p1.setXY(50, 15);
		System.out.println(p1);

	}

}
