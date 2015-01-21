package FactoryPattern;

import java.util.ArrayList;

public class Hospital extends Building {

	public Hospital() {

		RoomBuilder roomBuilder1 = new EmergencyRoomBuilder();
		RoomDirector roomDirector1 = new RoomDirector(roomBuilder1);
		roomDirector1.buildRoom();
		Room room1 = roomDirector1.getRoom();

		RoomBuilder roomBuilder2 = new TherapyRoomBuilder();
		RoomDirector roomDirector2 = new RoomDirector(roomBuilder2);
		roomDirector2.buildRoom();
		Room room2 = roomDirector2.getRoom();

		super.rooms.add(room1);
		super.rooms.add(room2);

	}

	@Override
	public String toString() {
		return "Hospital";
	}

}
