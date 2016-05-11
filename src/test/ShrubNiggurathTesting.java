package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.IPlayer;
import munchkin.api.Player;
import munchkin.cards.doors.ShrubNiggurath;
import munchkin.cards.treasures.MonsterStompers;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class ShrubNiggurathTesting {
	private ShrubNiggurath card;
	private IPlayer player;
	private Game game;

	@Before
	public void setUp() {
		this.player = new Player();
		this.game=new Game(2);
		this.player.addToPlayerLevel(3);
		this.card = new ShrubNiggurath();
		this.card.setOwner(this.player);
	}

	@After
	public void takeDown() {
		this.player = null;
		this.card = null;
		this.game=null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.player);
		assertNotNull(this.card);
		assertNotNull(this.game);
	}

	@Test
	public void testCardInPlay() {
		this.card.cardInPlay();
		assertEquals(4, this.card.getTreasures());
		assertEquals(16, this.card.getLevel());
		assertEquals(10000,this.card.getOwner().getRunAwayLevel());
	}
	
	@Test
	public void testCardPlayedWin(){
		this.card.cardPlayed(true);
		assertEquals(4, this.card.getOwner().getNumTreasures());
		assertEquals(5, this.card.getOwner().getPlayerLevel());
	}
	
	@Test
	public void testCardPlayedLose(){
		MonsterStompers m = new MonsterStompers(this.game);
		m.cardInPlay();
		this.player.getArmorSet().addFootGear(m);
		this.card.cardPlayed(false);
		assertEquals(0, this.card.getOwner().getArmorSet().getFootgear().size());
		assertEquals(0, this.card.getOwner().getPlayerLevel());
	}
}
