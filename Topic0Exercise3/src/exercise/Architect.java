package exercise;

public class Architect implements IArchitect {	
	private Hospital hospital;
	
	public Architect() {
		hospital = new Hospital();
	}
	
	/* (non-Javadoc)
	 * @see exercise.IArchitect#buildHospital()
	 */
	@Override
	public void buildHospital() {		
		System.out.println("Beginning Construction.");
		
		buildMainHall();
		buildEmergencyRoom();
		buildICU();
		buildBathRoom();
		
		System.out.println("Hospital finished.");
	}
	
	/* (non-Javadoc)
	 * @see exercise.IArchitect#buildMainHall()
	 */
	@Override
	public void buildMainHall() {
		System.out.println("BUILDING Main Hall.");
		IBuilder builder = new Builder();
		
		builder.buildFloor();
		builder.buildWalls();
		builder.buildRoof();
		builder.putDoors();
		builder.putWindows();
		builder.paint();
		
		hospital.setMainHall(builder.getRoom());
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see exercise.IArchitect#buildEmergencyRoom()
	 */
	@Override
	public void buildEmergencyRoom() {
		System.out.println("BUILDING Emergency Room.");
		IBuilder builder = new Builder();
		
		builder.buildFloor();
		builder.buildWalls();
		builder.buildRoof();
		builder.putDoors();
		builder.putWindows();
		builder.paint();
		
		hospital.setMainHall(builder.getRoom());
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see exercise.IArchitect#buildICU()
	 */
	@Override
	public void buildICU() {
		System.out.println("BUILDING ICU.");
		IBuilder builder = new Builder();
		
		builder.buildFloor();
		builder.buildWalls();
		builder.buildRoof();
		builder.putDoors();
		builder.putWindows();
		builder.paint();
		
		hospital.setMainHall(builder.getRoom());
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see exercise.IArchitect#buildBathRoom()
	 */
	@Override
	public void buildBathRoom() {
		System.out.println("BUILDING HALL.");
		IBuilder builder = new Builder();
		
		builder.buildFloor();
		builder.buildWalls();
		builder.buildRoof();
		builder.putDoors();
		builder.putWindows();
		builder.paint();
		
		hospital.setMainHall(builder.getRoom());
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see exercise.IArchitect#getHospital()
	 */
	@Override
	public Hospital getHospital() {
		return hospital;
	}
}
