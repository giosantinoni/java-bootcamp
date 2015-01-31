package interfaces;

import implementations.products.*;

public interface IVisitor {
	void visitComputer(Computer computer);
	void visitTablet(Tablet tablet);
}
