package com.service;
import java.util.HashMap;
import java.util.Map;

import com.model.*;

import javax.websocket.server.PathParam;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@ApplicationPath("meetings")
public class Meetings {
	
	private static Map<Integer, Meeting> dbMeetings = new HashMap<Integer, Meeting>();
	
	static {
		for (int i = 0; i < 10; i++) {
			Meeting meeting = new Meeting();
			int id = i + 1;
			meeting.setId(id);
			meeting.setName("my meeting name " + id);
			meeting.setStartTime("start time " + id);
			meeting.setEndTime("end time " + id);
			
			dbMeetings.put(id, meeting);
		}
	}
	
	@GET
	@Path("get_meeting_by_id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Meeting getMeetingById(@PathParam("id") int id) {
		return this.dbMeetings.get(id);
	}
	

}
