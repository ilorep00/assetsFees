package es.unileon.ulebank.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChangeMethodTests {
	private ChangeMethod method;
	
	@Before
    public void setUp() throws Exception {
		this.method = new ChangeMethod();
	}
	
	@Test
	public void testSetTypeGetType() {
		int type = 2;
		
		assertEquals(this.method.getType(), 0);
		
		this.method.setType(type);
		
		assertEquals(type, this.method.getType());
	}

}
