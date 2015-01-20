package exercise;

public interface IBuilder {
	void buildFloor();

	void buildWalls();

	void buildRoof();

	void putDoors();

	void putWindows();

	void paintBuilding();
	
	House getHouse();
}
