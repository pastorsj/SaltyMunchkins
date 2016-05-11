package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Hand;
import munchkin.api.ICard;
import munchkin.api.Player;
import munchkin.cards.doors.CurseBackpackEaten;
import munchkin.cards.doors.api.Door;
import munchkin.cards.treasures.Bagpipes;
import munchkin.cards.treasures.CultMembershipCard;
import munchkin.cards.treasures.api.Faction;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class CurseBackpackEatenTesting {

	private Door door;
	private Game game;
	private Treasure card;

    @Before
    public void setUp() {
    	game = new Game(2);
    	door = new CurseBackpackEaten(game);
    	card = new CultMembershipCard(game);
    	card.setOwner(this.game.getCurrentPlayer());
    	door.setOwner(game.getCurrentPlayer());
    	game.getCurrentPlayer().setHand(new Hand(game.getCurrentPlayer()));
    }

    @After
    public void takeDown() {
    	this.door = null;
    }

    @Test
    public void removeDisabled() {
    	card.getOwner().setFaction(Faction.Cultist);
    	game.getCurrentPlayer().getHand().insertCard(door);
    	game.getCurrentPlayer().getHand().insertCard(card);
    	door.cardInHand();
    	card.cardInHand();
    	game.getCardsInPlay().addCardsToPlay(card);
    	game.getCardsInPlay().addCardsToPlay(door);
    	card.cardInPlay();
    	
    	assertTrue(game.getCurrentPlayer().getHand().cardInHand(card));
    	assertTrue(game.getCurrentPlayer().getHand().cardInHand(door));
    	door.cardInPlay();
    	
    	assertTrue(door.checkDiscard());
    }
    
    @Test
    public void noDisabled(){
    	card.getOwner().setFaction(Faction.MonsterWhacker);
    	game.getCurrentPlayer().getHand().insertCard(door);
    	game.getCurrentPlayer().getHand().insertCard(card);
    	door.cardInHand();
    	card.cardInHand();
    	game.getCardsInPlay().addCardsToPlay(card);
    	game.getCardsInPlay().addCardsToPlay(door);
    	card.cardInPlay();
    	
    	assertTrue(game.getCurrentPlayer().getHand().cardInHand(card));
    	assertTrue(game.getCurrentPlayer().getHand().cardInHand(door));
    	door.cardInPlay();
    	
    	assertFalse(card.checkDiscard());
    	
    }
}
