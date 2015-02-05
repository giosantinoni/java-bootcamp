package bootcamp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.PhotoModel;

public class User {
	private String name;
	private String userName;
	private String password;
	private Map<Integer, PhotoModel> photos = new HashMap<Integer, PhotoModel>();
	private Set<User> friends = new HashSet<User>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addPhoto(PhotoModel photo) {
		photos.put(photo.getId(),photo);
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}
	
	public void likeToPhoto(User friend, Integer id) {
		PhotoModel photo = this.photos.get(id);
		this.photos.put(id, photo);
		photo.setLike(friend);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}

}
