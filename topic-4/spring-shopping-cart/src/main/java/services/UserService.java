package services;

import interfaces.*;
import model.UserModel;
import bootcamp.User;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
	private UserModel userModel = new UserModel();

	public void addUser(User user) {
		this.userModel.add(user);
		
	}

	public User getUser(String userName) {
		User user = userModel.get(userName);
		return user;
		
	}

	public void updateUser(User user) {
		User userUpdated = this.getUser(user.getUserName());
		userUpdated.setName(user.getName());
		userModel.update(user);
	}

	public void deleteUser(User user) {
		userModel.delete(this.getUser(user.getUserName()));
	}

	public void setLike(String userName, String friendName, Integer photoId) {
		User user = this.getUser(userName);
		User friend = this.getUser(friendName);
		friend.likeToPhoto(user, photoId);
	}

	public void setFriend(String userName, String friendName) {
		User user = this.getUser(userName);
		User friend = getUser(friendName);
		user.addFriend(friend);
		friend.addFriend(user);
	}
	
	

	
}
