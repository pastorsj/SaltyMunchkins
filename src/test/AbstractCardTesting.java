package test;

import munchkin.api.AbstractCard;
import munchkin.cards.doors.AughostDerwraith;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractCardTesting {

	@Test
	public void testGetName() {
		AbstractCard c = new AughostDerwraith();
		assertEquals("AughostDerwraith",c.getName());
	}

}
