package implementations.visitors;

import implementations.products.Computer;
import implementations.products.Tablet;
import interfaces.IVisitor;

public class DisplayItemVisitor implements IVisitor{

	@Override
	public void visitComputer(Computer computer) {
		System.out.println(computer.getName() + "....... $" + computer.getPrice());
		
	}

	@Override
	public void visitTablet(Tablet tablet) {
		System.out.println(tablet.getName() + "....... $" + tablet.getPrice());
		
	}

	
}
