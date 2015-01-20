package exercise3;

public class SmallHospitalBuilder implements HospitalBuilder{
	
	private Hospital smallHospital;
	
	public SmallHospitalBuilder(){
		smallHospital=new Hospital();
	}
	
	@Override
	public void buildEmergencyRoom(){
		smallHospital.setEmergencyRoom("Small Emergency Room");
	}
	@Override
	public void buildIntensiveCareWard(){
		smallHospital.setIntensiveCareWard("Small Intensive Care Ward");
	}
	@Override
	public void buildGuardWard(){
		smallHospital.setGuardWard("Small Guard Ward");
	}
	@Override
	public void buildMainHall(){
		smallHospital.setMainHall("Small Main Hall");
	}
	@Override
	public void buildPrivateRoom(){
		smallHospital.setPrivateRoom("Small private Rooms");
	}
	
	@Override
	public Hospital getHospital(){
		return smallHospital;
	}
}
