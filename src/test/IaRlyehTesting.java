package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.ICard;
import munchkin.api.Player;
import munchkin.cards.doors.Buggoth;
import munchkin.cards.doors.IaRlyeh;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class IaRlyehTesting {
	
	private Door door;
	private Game game;

    @Before
    public void setUp() {
    	game = new Game(2);
    	door = new IaRlyeh(game);
    
    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void testUse() {
    	Player p = new Player();
    	p.setFaction(Faction.MonsterWhacker);
    	Door card = new Buggoth();
    	card.setOwner(p);
    	door.setOwner(p);
    	card.cardInHand();
    	door.cardInHand();
    	card.cardInPlay();
    	assertEquals(0, game.getDiscardedCards().getAllCards().size());
    	
    	game.getDiscardedCards().addToDiscardedCards(card);
    	door.cardInPlay();
    	
    	assertTrue(p.getHand().getCards().contains(card));
    	
    }
}
