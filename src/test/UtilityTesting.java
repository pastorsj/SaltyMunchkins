package test;

import static org.junit.Assert.*;

import org.junit.Test;

import munchkin.game.Utility;

public class UtilityTesting {

	@Test
	public void testRollDice() {
		for(int i = 0; i < 100; i++){
			int num = Utility.rollDice();
			assertTrue(num <= 6 && num >=1);
		}
	}

}
