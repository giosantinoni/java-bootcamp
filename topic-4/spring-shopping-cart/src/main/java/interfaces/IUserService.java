package interfaces;

import bootcamp.User;

public interface IUserService {
	void addUser(User user);
	User getUser(String userName);
	void updateUser(User user);
	void deleteUser(User user);
	void setLike(String userName, String friendName, Integer photoId);
	void setFriend(String userName, String friendName);
}
