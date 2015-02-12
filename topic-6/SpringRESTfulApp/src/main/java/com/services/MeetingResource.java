package com.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.model.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Path("/meetings")
public class MeetingResource {

	private static Map<Integer, Meeting> dbMeetings = new HashMap<Integer, Meeting>();
	private AtomicInteger idCounter = new AtomicInteger();

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public StreamingOutput getMeeting(@PathParam("id") int id) {
		final Meeting meeting = dbMeetings.get(id);
		if (meeting == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return new StreamingOutput() {
			public void write(OutputStream outputStream) throws IOException, WebApplicationException {
				outputMeeting(outputStream, meeting);
			}
		};
	}

	@POST
	@Consumes("application/xml")
	public Response createMeeting(InputStream is) {
		Meeting meeting = readMeeting(is);
		meeting.setId(idCounter.incrementAndGet());
		dbMeetings.put(meeting.getId(), meeting);
		System.out.println("Created meeting " + meeting.getId());
		return Response.created(URI.create("/meetings/" + meeting.getId())).build();
	}

	@PUT
	@Path("update/{id}")
	@Consumes("application/xml")
	public void updateMeeting(@PathParam("id") int id, InputStream is) {
		Meeting update = readMeeting(is);
		Meeting current = dbMeetings.get(id);
		if (current == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		current.setName(update.getName());
		current.setStartTime(update.getStartTime());
		current.setEndTime(update.getEndTime());
	}

	@DELETE
	@Path("delete/{id}")
	public void deleteMeeting(@PathParam("id") int id) {
		Meeting toDelete = dbMeetings.get(id);
		try {
			if (toDelete == null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				dbMeetings.remove(id);
			}
		} catch (Exception e) {
			throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	protected void outputMeeting(OutputStream os, Meeting cust) throws IOException {
		PrintStream writer = new PrintStream(os);
		writer.println("<meeting id=\"" + cust.getId() + "\">");
		writer.println("<name>" + cust.getName() + "</name>");
		writer.println("<start-time>" + cust.getStartTime() + "</start-time>");
		writer.println("<end-time>" + cust.getEndTime() + "</end-time>");

	}

	// review later this method
	protected Meeting readMeeting(InputStream is) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();
			Meeting meeting = new Meeting();

			if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals("")) {
				meeting.setId(Integer.valueOf(root.getAttribute("id")));
			}

			NodeList nodes = root.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);
				if (element.getTagName().equals("name")) {
					meeting.setName(element.getTextContent());
				} else if (element.getTagName().equals("start-time")) {
					meeting.setStartTime(element.getTextContent());
				} else if (element.getTagName().equals("end-time")) {
					meeting.setEndTime(element.getTextContent());
				}

			}
			return meeting;
		} catch (Exception e) {
			throw new WebApplicationException(e, Response.Status.BAD_REQUEST);

		}
	}

}
