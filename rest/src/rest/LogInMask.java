package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// http://localhost:8080/rest/rest/test
// name:port/project/root/path...
@Path("/test")
public class LogInMask {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Das ist ein Test";
	}

}
