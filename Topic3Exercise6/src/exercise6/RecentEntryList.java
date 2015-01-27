package exercise6;

import java.util.ArrayList;

public class RecentEntryList {
	
ArrayList<Entry> list = new ArrayList<Entry>();
	
	public void Open(Entry entry){
		int flag=0;
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTitle().equals(entry.getTitle())){
				list.remove(i);
				list.add(entry);
				flag=1;
			}
		}
		if(flag==0){
			if(list.size()<10){
				list.add(entry);
			}
			else{
				list.remove(0);
				list.add(entry);
			}
		}
		}
	
	public void Show(){
		System.out.println(list + "      cantidad de objetos:"  + list.size());
	}
	
	public void deleteFromRecent(Entry entry){
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTitle().equals(entry.getTitle())){
				list.remove(i);
			}
		}	
	}
}
