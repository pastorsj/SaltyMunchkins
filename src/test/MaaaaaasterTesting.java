package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.Maaaaaaster;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Faction;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class MaaaaaasterTesting {
	private Maaaaaaster card;
	private Player player;
    @Before
    public void setUp() {
    	this.card=new Maaaaaaster();
    	this.player=new Player();
    	this.card.setOwner(this.player);
    }

	@After
	public void takeDown() {
		this.player = null;
		this.card = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.player);
	}
	
	@Test
	public void testCardInHandWithCultist(){
		this.player.setFaction(Faction.Cultist);
		this.card.cardInHand();
		
		assertEquals(0, this.card.getGold());
		assertEquals(Armor.HeadGear, this.card.getArmor());
		assertFalse(this.card.isDisabled());
	}
	
	@Test
	public void testCardInHandWithoutCultist(){
		this.card.cardInHand();
		
		assertEquals(0, this.card.getGold());
		assertEquals(Armor.HeadGear, this.card.getArmor());
		assertTrue(this.card.isDisabled());
	}
	
	@Test
	public void testCardInPlay(){
		this.card.cardInPlay();
		assertEquals(4, this.card.getBonus());
	}
}
