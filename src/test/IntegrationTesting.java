package test;

import munchkin.api.ICard;
import munchkin.api.Player;
import munchkin.cards.doors.CurseHairStandsOnEnd;
import munchkin.cards.treasures.GoUpALevel;
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
        boolean check = true;
        try{
            this.card.cardInPlay();
        } catch(Exception e) {
            e.printStackTrace();
            check = false;
        }
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
        boolean check = true;
        int level = this.a.getPlayerLevel();
        ICard levelCard = new GoUpALevel();
        try {
            this.a.getHand().insertCard(levelCard);
            levelCard.cardInPlay();
        } catch (Exception e) {
            check = false;
        }
        assertTrue(check);
        assertEquals(level + 1, this.a.getPlayerLevel());
    }
}
