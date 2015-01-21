public class BuilderDirector {

	public House build(HouseBuilder builder) {
		builder.buildWall();
		builder.buildCeiling();
		builder.buildRoom();
		builder.buildFoundation();

		return builder.getHouse();
	}
}
