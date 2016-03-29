package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CardTest {
	Card target = new Card(10, "Test");
	@Test
	public void testCardNotNull() {
		assertNotNull(target);
	}
	
	@Test
	public void testGetName(){
		assertEquals("Test", target.getName());
	}
	
	@Test
	public void testGetNumber(){
		assertEquals(10, target.getNumber());
	}
	
}
