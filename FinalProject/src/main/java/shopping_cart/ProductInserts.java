package shopping_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.ProductDAO;

@Component
public class ProductInserts {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	public void inserts() {
		if (productDAO.getProducts().isEmpty()) {


			productDAO.createProduct("Keyboard - Razer", 80, "Electronics");
			productDAO.createProduct("Notebook - Dell", 8000, "Electronics");
			productDAO.createProduct("Monitor - Apple", 500, "Electronics");
			productDAO.createProduct("i7 3770k microp.- Intel", 700, "Electronics");
			productDAO.createProduct("AMD R9 290 - AMD", 650, "Electronics");
			productDAO.createProduct("Table", 400, "Furniture");
			productDAO.createProduct("Chair", 100, "Furniture");
			productDAO.createProduct("Door", 60, "Furniture");
			productDAO.createProduct("Ferrari 458", 243.090, "Vehicles");
			productDAO.createProduct("Lamborghini Aventador", 400.995, "Vehicles");
		}
	}
}
