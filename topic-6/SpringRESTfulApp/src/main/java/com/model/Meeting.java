package com.model;

import java.util.ArrayList;

public class Meeting {
	private int id;
	private String name;
	private String startTime;
	private String endTime;
	private ArrayList<Attendee> attendees;
	private Room room;

	public Meeting() {
		this.attendees = new ArrayList<Attendee>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ArrayList<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(ArrayList<Attendee> attendees) {
		this.attendees = attendees;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void addAttendee(Attendee attendee) {
		this.attendees.add(attendee);
	}

}
