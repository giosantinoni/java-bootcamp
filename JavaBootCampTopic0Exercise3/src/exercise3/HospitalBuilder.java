package exercise3;

public interface HospitalBuilder {
	
	public void buildEmergencyRoom();
	public void buildIntensiveCareWard();
	public void buildGuardWard();
	public void buildMainHall();
	public void buildPrivateRoom();
	
	public Hospital getHospital();

}
