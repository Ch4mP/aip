package rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testguardmanager {

	private GuardManager gm;
	
	@BeforeEach
	void setUp() throws Exception {
		this.gm = new GuardManager();
	}

	@Test
	void test() {
		assertEquals(this.gm.findGuard("test"), new Guard("test","123","-"));
	}

}
