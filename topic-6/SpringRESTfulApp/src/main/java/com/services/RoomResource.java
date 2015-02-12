package com.services;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;


import com.model.Room;

@Path("/rooms")
public class RoomResource {
	private static Map<Integer, Room> dbRooms = new HashMap<Integer, Room>();

	static {
		for (int i = 0; i < 10; i++) {
			Room room = new Room();
			int id = i + 1;
			room.setId(id);
			room.setName("Room " + id);

			dbRooms.put(id, room);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public StreamingOutput getRoom(@PathParam("id") int id) {
		final Room room = dbRooms.get(id);
		if (room == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);

		return new StreamingOutput() {
			public void write(OutputStream outputStream) throws IOException, WebApplicationException {
				outputRoom(outputStream, room);
			}
		};
	}

	protected void outputRoom(OutputStream outputStream, Room room) {
		PrintStream writer = new PrintStream(outputStream);
		writer.println("<room id=\"" + room.getId() + "\">");
		writer.println("<name>" + room.getName() + "</name>");
	}

}
