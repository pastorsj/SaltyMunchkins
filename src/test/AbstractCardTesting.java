package test;

import static org.junit.Assert.*;

import org.junit.Test;

import munchkin.api.AbstractCard;
import munchkin.cards.doors.AndItsSpawn;
import munchkin.cards.doors.AughostDerwraith;

public class AbstractCardTesting {

	@Test
	public void testGetName() {
		AbstractCard c = new AughostDerwraith();
		assertEquals("AughostDerwraith",c.getName());
	}

}
