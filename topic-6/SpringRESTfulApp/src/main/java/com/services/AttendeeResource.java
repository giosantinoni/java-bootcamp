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

import com.model.Attendee;

@Path("/attendees")
public class AttendeeResource {

	private static Map<Integer, Attendee> dbAttendees = new HashMap<Integer, Attendee>();

	static {
		for (int i = 0; i < 10; i++) {
			Attendee attendee = new Attendee();
			int id = i + 1;
			attendee.setId(id);
			attendee.setFullName("Attendee " + id);

			dbAttendees.put(id, attendee);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public StreamingOutput getAttendee(@PathParam("id") int id) {
		final Attendee attendee = dbAttendees.get(id);
		if (attendee == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);

		return new StreamingOutput() {
			public void write(OutputStream outputStream) throws IOException, WebApplicationException {
				outputAttendee(outputStream, attendee);
			}
		};
	}

	protected void outputAttendee(OutputStream outputStream, Attendee attendee) {
		PrintStream writer = new PrintStream(outputStream);
		writer.println("<attendee id=\"" + attendee.getId() + "\">");
		writer.println("<full-name>" + attendee.getFullName() + "</full-name>");
	}

}
