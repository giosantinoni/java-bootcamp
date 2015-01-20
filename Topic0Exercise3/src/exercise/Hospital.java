package exercise;

public class Hospital {
	private Room mainHall;
	private Room emergencyRoom;
	private Room bathRoom;
	private Room ICU;

	public Room getEmergencyRoom() {
		return emergencyRoom;
	}

	public void setEmergencyRoom(Room emergencyRoom) {
		this.emergencyRoom = emergencyRoom;
	}

	public Room getBathRoom() {
		return bathRoom;
	}

	public void setBathRoom(Room bathRoom) {
		this.bathRoom = bathRoom;
	}

	public Room getICU() {
		return ICU;
	}

	public void setICU(Room iCU) {
		ICU = iCU;
	}

	public Room getMainHall() {
		return mainHall;
	}

	public void setMainHall(Room mainHall) {
		this.mainHall = mainHall;
	}
}
