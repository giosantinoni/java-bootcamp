

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.services.AttendeeResource;
import com.services.MeetingResource;
import com.services.RoomResource;

@ApplicationPath("/services")
public class ApplicationConfig extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public ApplicationConfig() {
		singletons.add(new MeetingResource());
		singletons.add(new AttendeeResource());
		singletons.add(new RoomResource());
	}
	
	public Set<Class<?>> getClasses() {
		return empty;
	}
	
	public Set<Object> getSingletons() {
		return singletons;
	}

}
