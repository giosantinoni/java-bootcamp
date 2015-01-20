public class Main {

	public static void main(String[] args) {
		HouseBuilder builder = new ConcreteHouseBuilder();
		BuilderDirector houseBuilderDirector = new BuilderDirector();
		House house = houseBuilderDirector.build(builder);
		System.out.println(house);

	}

}
