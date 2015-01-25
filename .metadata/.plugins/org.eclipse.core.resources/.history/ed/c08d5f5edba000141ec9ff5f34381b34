package exercise3;

public class HospitalDirector {

	private HospitalBuilder hospitalBuilder = null;
	
	public HospitalDirector (HospitalBuilder hospitalBuilder){
		this.hospitalBuilder=hospitalBuilder;
	}
	
	public void constructHospital(){
		hospitalBuilder.buildEmergencyRoom();
		hospitalBuilder.buildGuardWard();
		hospitalBuilder.buildIntensiveCareWard();
		hospitalBuilder.buildMainHall();
		hospitalBuilder.buildPrivateRoom();
	}
	
	public Hospital getHospital(){
		return hospitalBuilder.getHospital();
	}
}
