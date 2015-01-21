package FactoryPattern;

public class Factory {
	public Building getBuilding(String type) {

		if (type.equals("hospital")) {
			return new Hospital();
		}

	}

}
