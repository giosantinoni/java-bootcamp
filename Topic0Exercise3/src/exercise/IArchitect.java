package exercise;

public interface IArchitect {

	public abstract void buildHospital();

	public abstract void buildMainHall();

	public abstract void buildEmergencyRoom();

	public abstract void buildICU();

	public abstract void buildBathRoom();

	public abstract Hospital getHospital();

}