package rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testguard {
	
	private Guard guard0, guard1, guard2, guard3, guard4;

	@BeforeEach
	void setUp() throws Exception {
		this.guard0 = new Guard("","","");
		this.guard1 = new Guard("test","123","-");
		this.guard2 = new Guard("admin","123456","keine");
		this.guard3 = new Guard("admin","123456","-");
		this.guard4 = new Guard("test","123","keine");
	}

	@Test
	void test() {
		assertEquals(guard0.getName(), "");
		assertEquals(guard0.isPW(""), true);
		assertEquals(guard0.getEMail(), "");
		assertEquals(guard0, new Guard("","",""));
	}

}
