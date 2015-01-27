package exercise6;

import java.util.ArrayList;

public class Blog {

	private ArrayList<Entry> entryList = new ArrayList<Entry>();
	RecentEntryList recentEntryList = new RecentEntryList();
	
	public void post(Entry entry) {
		entryList.add(entry);
		recentEntryList.Open(entry);
	}
	
	public void update(Entry entry){
		for(int i=0; i< entryList.size();i++){
			if(entryList.get(i).getTitle().equals(entry.getTitle())){
				entryList.get(i).setBody(entry.getBody());
				entryList.get(i).setTag(entry.getTag());
				recentEntryList.Open(entry);
			}
		}
	}
	
	public void delete(String title){
		
		for(int i=0; i< entryList.size();i++) {
			if(entryList.get(i).getTitle().equals(title)) {
				recentEntryList.deleteFromRecent(entryList.get(i));
				entryList.remove(i);
			}
		}
		
	}
	
	public void showAllTags(){
		
		System.out.println("Listing all Tags: ");
		for(int i=0; i< entryList.size();i++){
			System.out.println(entryList.get(i).getTag());
		}
	}
	
	public void entrySearch(String tag){
		
		int flag=0;
		System.out.println("Blog entrys with the tag " + '"' + tag + '"' + ":");
		
		for(int i=0; i< entryList.size();i++){
			if(entryList.get(i).getTag().equals(tag)){
				System.out.println(entryList.get(i).getTitle());
				flag=1;
			}
		}
		if(flag==0){
			System.out.println("No entrys with the tag  " + '"' + tag + '"' + " were found");
		}
	}
	
}
