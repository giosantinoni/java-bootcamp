package exercise3;

public class Hospital {
	
	private String emergencyRoom;
	private String intensiveCareWard;
	private String guardWard;
	private String mainHall;
	private String privateRoom;
	
	public String getEmergencyRoom() {
		return emergencyRoom;
	}
	public void setEmergencyRoom(String emergencyRoom) {
		this.emergencyRoom = emergencyRoom;
	}
	public String getIntensiveCareWard() {
		return intensiveCareWard;
	}
	public void setIntensiveCareWard(String intensiveCareWard) {
		this.intensiveCareWard = intensiveCareWard;
	}
	public String getGuardWard() {
		return guardWard;
	}
	public void setGuardWard(String guardWard) {
		this.guardWard = guardWard;
	}
	public String getMainHall() {
		return mainHall;
	}
	public void setMainHall(String mainHall) {
		this.mainHall = mainHall;
	}
	public String getPrivateRoom() {
		return privateRoom;
	}
	public void setPrivateRoom(String privateRoom) {
		this.privateRoom = privateRoom;
	}
	
	@Override
	public String toString() {
		return "Hospital [emergencyRoom=" + "\n" + emergencyRoom + "\n" + ", intensiveCareWard=" + "\n" + intensiveCareWard + "\n" + ", guardWard=" + "\n" + guardWard
				+ "\n" + ", mainHall=" + "\n" + mainHall + "\n" + ", privateRoom=" + "\n" + privateRoom + "]";
	}
	
	
}
