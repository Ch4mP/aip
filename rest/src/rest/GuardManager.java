package rest;

import java.util.ArrayList;

public class GuardManager {
	
	private ArrayList<Guard> guards;
	
	public GuardManager() {
		this.guards = new ArrayList<Guard>();
		this.generateGuards();
	}

	// Creates a guard
	public void createGuard(String name, String pw, String email) {
		Guard guard = new Guard(name,pw,email);
		this.guards.add(guard);
	}
	
	// Finds a guard if exist
	public Guard findGuard(String name) {
		Guard guard = null;
		for (Guard gs : this.guards) {
			if(gs.getName().equals(name)) {
				guard = gs;
			}
		}
		return guard;
	}
	
	// Deletes a guard if exist
	public void deleteGuard(String name) {
		Guard guard = this.findGuard(name);
		if(guard != null) {
			this.guards.remove(guard);
		}
	}
	
	
	
	// Basic guards
	private void generateGuards() {
		this.guards.add(new Guard("Florian","Schmitz","www.fs@email.de"));
		this.guards.add(new Guard("Moritz","Nordengruen","www.mn@email.de"));
		this.guards.add(new Guard("Meltem","Tasci","www.mt@email.tk"));
		this.guards.add(new Guard("Phillipp","Grages","www.pg@email.de"));
		this.guards.add(new Guard("admin","123456","keine"));
		this.guards.add(new Guard("test","123","-"));
	}
}
