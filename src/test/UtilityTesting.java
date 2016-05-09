package test;

import munchkin.game.Utility;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UtilityTesting {

	@Test
	public void testRollDice() {
		for(int i = 0; i < 100; i++){
			int num = Utility.rollDice();
			assertTrue(num <= 6 && num >=1);
		}
	}

}
