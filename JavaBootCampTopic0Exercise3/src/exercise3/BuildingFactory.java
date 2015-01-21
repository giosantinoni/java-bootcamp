package exercise3;

public class BuildingFactory {
	
	public Building getBuilding(String type, String buildingName){
		Building building = null;
		switch(type) {
			case "Hospital" :
				return new Hospital(buildingName);
		}
		
		return building;
		
	}

}
