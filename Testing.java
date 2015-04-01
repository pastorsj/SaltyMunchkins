import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Testing {
	
	@Test
	public void testPlayerNotNull() {
		Player player1 = new Player("");
		assertNotNull(player1);
	}
	
	@Test
	public void testUsername(){
		Player player1 = new Player ("MyName");
		assertEquals(player1.username, "MyName");
	}
	
	
	
	
}
