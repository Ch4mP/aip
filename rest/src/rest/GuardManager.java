package rest;

import java.util.ArrayList;

public class GuardManager {
	
	private ArrayList<Guard> guards;
	
	public GuardManager() {
		this.guards = new ArrayList<Guard>();
	}

	// Creates a guard
	public void createGuard(String name, String pw, String email) {
		Guard guard = new Guard(name,pw,email);
		this.guards.add(guard);
	}
	
	// Finds a guard if exist
	public Guard findGuard(String name) {
		Guard guard = null;
		for (Guard gs : guards) {
			if(gs.getName() == name) {
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
}
