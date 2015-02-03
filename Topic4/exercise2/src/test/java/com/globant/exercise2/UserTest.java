package com.globant.exercise2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.globant.exercise2.shoppingcart.model.Photo;
import com.globant.exercise2.shoppingcart.model.User;

public class UserTest {
	private User user;
	private User friend;
	private Photo photo1;
	private Photo photo2;

	@Before
	public void setUp() throws Exception {
		user = new User("Homer Simpson");
		friend = new User("Lenny");
		photo1 = new Photo("/path/photo1");
		photo2 = new Photo("/path/photo2");
	}

	@After
	public void tearDown() throws Exception {
		user = null;
		friend = null;
		photo1 = null;
		photo2 = null;
	}

	@Test
	public void testAddPhoto() {
		user.addPhoto(photo1);
		user.addPhoto(photo2);
		
		int result = user.getPhotos().size();
		
		assertEquals(2, result);
	}

	@Test
	public void testAddFriend() {
		int result = user.getFriends().size();
		assertEquals(0, result);		
		
		user.addFriend(friend);
		result = user.getFriends().size();
		assertEquals(1, result);		
	}

	@Test
	public void testAddLikeToPhoto() {
		String filePath = photo1.getFilePath();
		
		user.addPhoto(photo1);
		user.addPhoto(photo2);
		
		user.addLikeToPhoto(friend, filePath);
		
		User result = user.getPhotos().get(filePath).getLikes().iterator().next();
		
		assertEquals(friend, result);
	}

}
