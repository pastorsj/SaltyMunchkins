package test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.CampusCrusadeforCthulhu;
import munchkin.cards.treasures.api.Faction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CampusCrusadeForCthulhuTesting {
	private CampusCrusadeforCthulhu card;
	private IPlayer playerProf;
	private IPlayer playerCult;
	private IPlayer playerNorm;
	
	@Before
	public void setUp(){
		this.card = new CampusCrusadeforCthulhu();
		this.playerCult = new Player();
		this.playerCult.setFaction(Faction.Cultist);
		this.playerProf = new Player();
		this.playerProf.setFaction(Faction.Professor);
		this.playerNorm=new Player();
		this.playerNorm.setFaction(Faction.Investigator);
		this.card.setOwner(playerNorm);
	}
	
	@After
	public void takeDown(){
		this.card=null;
		this.playerCult=null;
		this.playerProf=null;
		this.playerNorm=null;
	}
	
	@Test
	public void testCardNotNull() {
		assertNotNull(this.card);
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(2, this.card.getTreasures());
		assertEquals(6, this.card.getLevel());
		
		this.card.setOwner(this.playerCult);
		this.card.cardInPlay();
		assertEquals(8, this.card.getLevel());
		
		this.card.setOwner(this.playerProf);
		this.card.cardInPlay();
		assertEquals(4, this.card.getLevel());
	}
	
	@Test
	public void testBadStuff(){
		this.card.cardInPlay();
		this.card.badStuff();
		assertEquals(Faction.Cultist, this.card.getOwner().getFaction());
	}
}
