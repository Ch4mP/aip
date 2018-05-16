package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// http://localhost:8080/rest/rest/guard
// name:port/project/root/path...
@Path("/guard")
public class LogInMask {
	
	private Guard guard = null;
	private boolean authentificated = false;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Das ist ein Test";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/profile")
	public String profile() {
		if(this.authentificated) {
			return this.guard.getName();
		}else {
			return "Login please.";
		}
	}
	
	@Path("/login")
	public String login() {
		// TODO
		return "";
	}
	
	@Path("/logout")
	public String logout() {
		// TODO
		return "";
	}
	
	@Path("/register")
	public String register() {
		// TODO
		return "";
	}
}
