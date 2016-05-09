package test;

import munchkin.api.Player;
import munchkin.cards.doors.AughostDerwraith;
import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractMonsterTesting {

	@Test
	public void testCardPlayed() {
		Player p = new Player();
		
		AbstractMonster m = new AughostDerwraith();
		p.addCardToHand(m);
		p.setFaction(Faction.Investigator);
		m.cardInPlay();
		m.cardPlayed(false);
		assertEquals(Faction.UNAFFILIATED,p.getFaction());
		
		int orig = p.getNumTreasures();
		m.cardPlayed(true);
		assertEquals(orig+1, p.getNumTreasures());
	}

}
