package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.TheCrullerOutOfSpace;
import munchkin.cards.treasures.MonsterStompers;
import munchkin.cards.treasures.Necrotelecom;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class TheCrullerOutOfSpaceTesting {
	private TheCrullerOutOfSpace card;
	private IPlayer player;
	private Game game;

	@Before
	public void setUp() {
		this.card = new TheCrullerOutOfSpace();
		this.player = new Player();
		this.game=new Game(2);
		this.player.addCardToHand(this.card);
		this.card.setOwner(this.player);
		this.player.setFaction(Faction.MonsterWhacker);
	}

	@After
	public void takeDown() {
		this.card=null;
		this.player=null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
	}
	
	@Test
	public void testCardInPlayWithMonsterWhacker(){
		this.card.cardInPlay();
		assertEquals(2, this.card.getTreasures());
		assertEquals(10, this.card.getLevel());
	}
	@Test
	public void testCardInPlayWithoutMonsterWhacker(){
		this.player.setFaction(Faction.Investigator);
		this.card.cardInPlay();
		assertEquals(2, this.card.getTreasures());
		assertEquals(4, this.card.getLevel());
	}
	@Test
	public void testBadStuff(){
		Necrotelecom n = new Necrotelecom(this.game);
		MonsterStompers m = new MonsterStompers(this.game);

		n.setOwner(this.player);
		m.setOwner(this.player);
		m.cardInHand();
		n.cardInHand();
		m.cardInPlay();
		n.cardInPlay();
		
		this.player.getArmorSet().addHeadGear(n);
		this.player.getArmorSet().addFootGear(m);
		
		this.card.badStuff();
		
		assertEquals(0, this.player.getArmorSet().getHeadgear().size());
		assertEquals(0, this.player.getArmorSet().getFootgear().size());
	}
}
