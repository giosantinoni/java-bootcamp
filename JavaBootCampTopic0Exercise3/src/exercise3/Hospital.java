package exercise3;
import java.util.ArrayList;

public class Hospital extends Building {
	
	
	private String hospitalName;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public Hospital(String hospitalName){
		this.hospitalName=hospitalName;
		
		rooms = new ArrayList<Room>();
		
		RoomBuilder ICWB = new IntensiveCareWardBuilder();
		RoomBuilder mainHall = new MainHallBuilder();
		
		//Creating an Intensive Care Ward
		RoomDirector roomDirector = new RoomDirector(ICWB);
		roomDirector.constructRoom();
		super.rooms.add(roomDirector.getRoom());
		
		//Creating a Main Hall
		roomDirector= new RoomDirector(mainHall);
		roomDirector.constructRoom();
		super.rooms.add(roomDirector.getRoom());
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", rooms=" + rooms + "]";
	}
	
	
}
