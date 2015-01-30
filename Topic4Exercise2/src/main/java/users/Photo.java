package users;

import java.util.ArrayList;

public class Photo {
	
	private String link;
	private ArrayList<String> likes;
	
	
	
	public Photo(String link) {
		this.link = link;
		likes = new ArrayList<String>();
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public ArrayList<String> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}
	
	/**
	 * Likes a given photo. If the method is called twice by the same user (userName)
	 * the photo is "un-liked"
	 * 
	 * @param userName
	 * 				: The user tha likes/unlikes the photo
	 */
	
	public void like(String userName) {
		if(!likes.contains(userName)){
			likes.add(userName);
		}
		else likes.remove(userName);
		
	}
	
	
	@Override
	public String toString() {
		return "Photo [link=" + link + ", likes=" + likes.size() + " from" + likes + "]";
	}
	
	
	
	

}
