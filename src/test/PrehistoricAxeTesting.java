package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Combat;
import munchkin.cards.doors.Ruggoth;
import munchkin.cards.doors.ThtWhchHsNVwls;
import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.PrehistoricAxe;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class PrehistoricAxeTesting {
	private PrehistoricAxe card;
	private Game game;
	private Combat combat;

	@Before
	public void setUp() {
		this.game = new Game(2);
		this.card = new PrehistoricAxe(this.game);
		this.combat=new Combat(this.game);
		this.card.setOwner(this.game.getCurrentPlayer());
	}

	@After
	public void takeDown() {
		this.game = null;
		this.card = null;
	}

	@Test
	public void testInit() {
		assertNotNull(this.card);
		assertNotNull(this.game);
	}
	@Test
	public void testCardInHand() {
		this.card.cardInHand();
		assertEquals(500, this.card.getGold());
	}

	@Test
	public void testCardInPlayGreaterThan15() {
		AbstractMonster m = new ThtWhchHsNVwls();
		this.game.getCurrentPlayer().addToPlayerLevel(5);
		m.setOwner(this.game.getCurrentPlayer());
		m.cardInPlay();
		
		this.game.getCombat().addMonsterToFight(m);
		this.card.cardInHand();
		this.card.cardInPlay();
		
		assertEquals(Armor.OneHand, this.card.getArmor());
		assertEquals(6, this.card.getOwner().getPlayerLevel());
		assertEquals(18,this.game.getCombat().getMonsterLevel());
		assertEquals(5, this.card.getBonus());
	}
	@Test
	public void testCardInPlayLessThan15() {
		AbstractMonster m = new Ruggoth();
		m.setOwner(this.game.getCurrentPlayer());

		m.cardInPlay();
		this.combat.addMonsterToFight(m);

		this.card.cardInHand();
		this.card.cardInPlay();
		assertEquals(Armor.OneHand, this.card.getArmor());
		assertEquals(2, this.card.getBonus());
	}
}
