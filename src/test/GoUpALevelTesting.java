package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.cards.treasures.*;
import munchkin.cards.treasures.api.Treasure;

/**
 * Created by SamPastoriza on 5/8/16.
 */
public class GoUpALevelTesting {

    private CallTheArmy cta;
    private DiscoverFamilyHistory dfh;
    //InformLocalAuthorities
    //InterviewedforEveningNews
    //LearnThingsManWasNotMeantToKnow
    //MysticVisions
    //ReportCreaturesToFBI
    //TargetPractice

	
    @Before
    public void setUp() {
    	cta = new CallTheArmy();
    	cta.setOwner(new Player());
    	
    	dfh = new DiscoverFamilyHistory();
    	dfh.setOwner(new Player());
    }

    @After
    public void takeDown() {
    	this.cta = null;
    	this.dfh = null;
    }


    @Test
    public void CallTheArmy() {
    	this.cta.cardInHand();
    	this.cta.cardInPlay();
    	this.cta.cardPlayed(true);
    	assertTrue(this.cta.checkDiscard());
    }

    @Test
    public void DiscoverFamilyHistory() {
    	this.dfh.cardInHand();
    	this.dfh.cardInPlay();
    	this.dfh.cardPlayed(true);
    	assertTrue(this.dfh.checkDiscard());
        
    }

    @Test
    public void InformLocalAuthorities() {

    }

    @Test
    public void InterviewforEveningNews() {

    }

    @Test
    public void LearnThingsManWasNotMeantToKnow() {

    }

    @Test
    public void MysticVisions() {

    }

    @Test
    public void ReportCreaturesToFBI() {

    }

    @Test
    public void TargetPractice() {

    }

    @Test
    public void TellThePresident() {

    }
}
