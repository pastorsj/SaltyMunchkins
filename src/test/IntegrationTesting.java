package test;

import munchkin.api.ICard;
import munchkin.api.Player;
import munchkin.cards.doors.CurseHairStandsOnEnd;
import munchkin.cards.treasures.api.GoUpALevel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pastorsj on 4/18/2016.
 */
public class IntegrationTesting {

    private ICard card;
    private Player a;

    @Before
    public void setUp() {
        this.card = new CurseHairStandsOnEnd();
        this.a = new Player();
    }

    @After
    public void takeDown() {
        this.card = null;
        this.a = null;
    }

    @Test
    public void testOwnership() {
        this.a.getHand().insertCard(this.card);
        assertEquals(this.a, this.card.getOwner());
    }

    @Test
    public void testNoException() {
        this.a.getHand().insertCard(this.card);
        boolean check = this.checkInPlay(this.card);
        assertTrue(check);
    }

    @Test
    public void testOwnerNotNullWhenRemoved() {
        this.a.getHand().insertCard(this.card);
        this.a.getHand().removeCardFromHand(this.card);
        assertEquals(this.a, this.card.getOwner());
    }

    @Test
    public void testGoUpALevel() {
        boolean check;
        int level = this.a.getPlayerLevel();
        ICard levelCard = new GoUpALevel();
        this.a.getHand().insertCard(levelCard);
        check  = this.checkInPlay(levelCard);
        assertTrue(check);
        assertEquals(level + 1, this.a.getPlayerLevel());
    }

    public boolean checkInPlay(ICard c) {
        try{
            c.cardInPlay();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
