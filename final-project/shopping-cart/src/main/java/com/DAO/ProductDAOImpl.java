package com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	SessionFactory sessionFactory;
	
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public List<Product> listProduct() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product").list();
	}

}
