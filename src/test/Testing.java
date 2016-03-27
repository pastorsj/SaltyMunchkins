package test;

import munchkin.game.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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
