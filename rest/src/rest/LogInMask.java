package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

// http://localhost:8080/rest/rest/guard
// name:port/project/root/path...

// Aenderungen werden nicht im Betrieb uebernommen, authentificated = true...
// Nur mit @Singleton

@Singleton
@Path("/guard")
public class LogInMask {
	
	public GuardManager gm = new GuardManager();
	
	private Guard guard = null;
	private boolean authentificated = false;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome() {
		return "Welcome, please login. \n/login:name:pw\n/logout:name\n/profile:name\n/register:name:pw:email";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/profile:{name}")
	public String profile(@PathParam("name") String name) {
		if(this.authentificated && (this.guard != null)) {
			return this.guard.getName();
		}else {
			return "Login please.";
		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/login:{name}:{pw}")
	public String login(@PathParam("name") String name, @PathParam("pw") String pw) {
		this.guard = this.gm.findGuard(name);
		if(this.guard != null) {
			if(this.guard.isPW(pw)) {
				this.authentificated = true;
				return "Ok. Hello " + this.guard.getName() +", you are online now.";
			}else {
				this.authentificated = false;
				return "Sorry. Wrong password.";
			}
		}else {
			this.authentificated = false;
			return "Sorry. I didnt find you.";
		}
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/logout:{name}")
	public String logout(@PathParam("name") String name) {
		this.authentificated = false;
		this.guard = null;
		return "Bye.";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/register:{name}:{pw}:{email}")
	public String register(@PathParam("name") String name, @PathParam("pw") String pw, @PathParam("email") String email) {
		if(this.gm.findGuard(name) == null) {
			this.gm.createGuard(name, pw, email);
			return "Ok. Registration complete, you can login now.";
		}else {
			return "Sorry. Username is allready in use.";
		}
	}
}
