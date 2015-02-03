package com.globant.exercise2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.globant.exercise2.shoppingcart.dao.IUserDAO;
import com.globant.exercise2.shoppingcart.exception.ShoppingCartException;
import com.globant.exercise2.shoppingcart.model.Photo;
import com.globant.exercise2.shoppingcart.model.User;
import com.globant.exercise2.shoppingcart.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class UserServiceTest {
	@Autowired
	private IUserService userService;

	private IUserDAO userDAOMock;

	private User user1;
	private User user2;
	private Photo photo1;

	@Before
	public void setUp() throws Exception {
		userDAOMock = mock(IUserDAO.class);

		user1 = new User(1, "Homer Simpson");
		user2 = new User(2, "Marge Simpson");
		photo1 = new Photo("path/photo1.png");

		when(userDAOMock.get(1)).thenReturn(user1);
		when(userDAOMock.get(2)).thenReturn(user2);
		when(userDAOMock.get(23)).thenReturn(null);
		when(userDAOMock.getAll()).thenReturn(Arrays.asList(user1, user2));
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
	}

	@Test
	public void testAddUser() {
		userService.setUserDAO(userDAOMock);

		userService.addUser(user1);

		verify(userDAOMock).add(user1);
	}

	@Test
	public void testGetUser1() {
		userService.setUserDAO(userDAOMock);

		User result = null;
		try {
			result = userService.getUser(1);
		} catch (ShoppingCartException e) {
			System.out.println(e.getMessage());
		}

		assertEquals(user1, result);
	}

	@Test
	public void testGetUser2() {
		userService.setUserDAO(userDAOMock);

		User result = null;
		try {
			result = userService.getUser(21);
		} catch (ShoppingCartException e) {
			System.out.println(e.getMessage());
		}

		assertEquals(null, result);
	}

	@Test
	public void testUpdateUser() {
		userService.setUserDAO(userDAOMock);

		user1.setId(1);
		user1.setName("Bart Simpson");
		try {
			userService.updateUser(user1);
		} catch (ShoppingCartException e) {
			e.printStackTrace();
		}

		verify(userDAOMock).update(user1);
	}

	@Test
	public void testDeleteUser() {
		userService.setUserDAO(userDAOMock);

		user1.setId(1);
		user1.setName("Bart Simpson");
		try {
			userService.updateUser(user1);
		} catch (ShoppingCartException e) {
			e.printStackTrace();
		}

		verify(userDAOMock).update(user1);
	}

	 @Test
	 public void testGetUsers() {
		 userService.setUserDAO(userDAOMock);
		 
		 List<User> result = userService.getUsers();
		 
		 assertEquals(Arrays.asList(user1, user2), result);
	 }
	 
	 @Test
	 public void testUploadPhoto() {
		 userService.setUserDAO(userDAOMock);		 
		 
		 try {
			userService.uploadPhoto(1, photo1);
		} catch (ShoppingCartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		 
		 verify(userDAOMock).update(user1);
	 }
	 
	 @Test
	 public void testAddFriend() {
		 userService.setUserDAO(userDAOMock);
		 
		 try {
			userService.addFriend(1, 2);
		} catch (ShoppingCartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 verify(userDAOMock).update(user1);
		 verify(userDAOMock).update(user2);
	 }
	
}
