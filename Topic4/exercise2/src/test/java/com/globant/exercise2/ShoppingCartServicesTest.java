package com.globant.exercise2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.globant.exercise2.shoppingcart.factory.ItemFactory;
import com.globant.exercise2.shoppingcart.factory.PaymentFactory;
import com.globant.exercise2.shoppingcart.model.User;
import com.globant.exercise2.shoppingcart.model.item.Item;
import com.globant.exercise2.shoppingcart.model.item.Product;
import com.globant.exercise2.shoppingcart.model.payment.Cash;
import com.globant.exercise2.shoppingcart.model.payment.Payment;
import com.globant.exercise2.shoppingcart.services.IShoppingCartServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class ShoppingCartServicesTest {
	@Autowired
	private IShoppingCartServices shoppingCartServices;

	private ItemFactory itemFactory;

	private User user1;
	private Item item1;
	private Item item2;

	@Before
	public void setUp() throws Exception {
		itemFactory = mock(ItemFactory.class);

		user1 = new User(1, "Juan Perez");
		item1 = new Product("product1", 500);
		item2 = new Product("product2", 400);

		when(itemFactory.getItem("product1")).thenReturn(item1);
		when(itemFactory.getItem("product2")).thenReturn(item2);
	}

	@After
	public void tearDown() throws Exception {
		itemFactory = null;
		user1 = null;
		item1 = null;
		item2 = null;
	}

	@Test
	public void testNewShoppingCart() {
		shoppingCartServices.newShoppingCart(user1);

		User result = shoppingCartServices.getCurrentShoppingCart().getUser();

		assertEquals(user1, result);
	}

	@Test
	public void testAddItem() {
		shoppingCartServices.setItemFactory(itemFactory);

		shoppingCartServices.newShoppingCart(user1);
		try {
			shoppingCartServices.addItem("product1");
		} catch (Exception e) {
			e.printStackTrace();
		}

		int result1 = shoppingCartServices.getCurrentShoppingCart().getItems().size();
		Item result2 = shoppingCartServices.getCurrentShoppingCart().getItems().iterator().next();

		assertEquals(1, result1);
		assertEquals(item1, result2);
	}

	@Test
	public void testFinishSale1() {
		shoppingCartServices.setItemFactory(itemFactory);

		shoppingCartServices.newShoppingCart(user1);
		try {
			shoppingCartServices.addItem("product1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		shoppingCartServices.finishSale("Cash", "", "");

		Double expected = Double.valueOf(50);
		Double result = Double.valueOf(shoppingCartServices.getCurrentShoppingCart().getPayment().getTotal());

		assertEquals(expected, result);
	}

	@Test
	public void testFinishSale2() {
		shoppingCartServices.setItemFactory(itemFactory);

		shoppingCartServices.newShoppingCart(user1);
		try {
			shoppingCartServices.addItem("product1");
			shoppingCartServices.addItem("product2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		shoppingCartServices.finishSale("CreditCard", "Juan Perez", "123456789");

		Double expected = Double.valueOf(810);
		Double result = Double.valueOf(shoppingCartServices.getCurrentShoppingCart().getPayment().getTotal());

		assertEquals(expected, result);
	}
	
	@Test
	public void testFinishSale3() {
		shoppingCartServices.setItemFactory(itemFactory);

		shoppingCartServices.newShoppingCart(user1);
		try {
			shoppingCartServices.addItem("product1");
			shoppingCartServices.addItem("product2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		shoppingCartServices.finishSale("Paypal", "jperez@mail.com", "123456789");

		Double expected = Double.valueOf(500);
		Double result = Double.valueOf(shoppingCartServices.getCurrentShoppingCart().getPayment().getTotal());

		assertEquals(expected, result);
	}

}
