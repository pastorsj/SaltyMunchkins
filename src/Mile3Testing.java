import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class Mile3Testing {
	public ArrayList<Integer> p1cards;
	public ArrayList<Integer> p2cards;
	public Game myGame;
	public InitializeCards init = new InitializeCards(true);
	
	@Before
	public void setUp() {
		p1cards = new ArrayList<Integer>();
		p2cards= new ArrayList<Integer>();
		myGame=new Game(init.doors,init.treasure);
		
		p1cards.add(1);
		p1cards.add(2);
		p2cards.add(3);
		p2cards.add(4);
		p1cards.add(84);
		p1cards.add(85);
		p2cards.add(86);
		p2cards.add(87);
		
		 myGame.p1.pHand=p1cards;
		 myGame.p2.pHand=p2cards;
		init.cardHash.get(4).inPlay = true;
		
	}
	@Test
	public void CardsNotNull() {
		assertNotNull(p1cards);
		assertNotNull(p2cards);
		
	}
	
	@Test
	public void EightCardsAdded(){
		assertEquals(4,p1cards.size());
		assertEquals(4,p2cards.size());
	}
	
	@Test
	public void setPlayerHands(){
		 assertNotNull(myGame.p1.pHand);
		 assertNotNull(myGame.p2.pHand);
	}
	
	@Test
	public void setAddNumForC1(){
		assertEquals(5,init.cardHash.get(1).monsterLevelBonus);
	}
	
	@Test
	public void setValuesForC2(){
		assertEquals(2,init.cardHash.get(2).monsterLevel);
		assertEquals(3,init.cardHash.get(2).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(2).numTreas);
		assertEquals("Monster Whacker", init.cardHash.get(2).condForBonus);
	}

	@Test
	public void setValuesForC3(){
		assertEquals(3,init.cardHash.get(3).monsterLevelBonus);
	}
	
	@Test
	public void setValuesForC4(){
		assertEquals(1,init.cardHash.get(4).monsterLevel);
		assertEquals(1, init.cardHash.get(4).numTreas);
		//assertEquals(false,myGame.p1.classAbility);
	}
	
	@Test
	public void setValuesForC5(){
		assertEquals(6,init.cardHash.get(5).monsterLevel);
		assertEquals(-2,init.cardHash.get(5).monsterLevelBonus);
		assertEquals(2, init.cardHash.get(5).numTreas);
		assertEquals("Professors", init.cardHash.get(5).condForBonus);
	}
	
	@Test
	public void setValuesForC6(){
		//m6 is the card that allows players to cheat, so it is removed from the deck for this project
	}
	
	@Test
	public void setValuesForC7(){
		assertEquals(2,init.cardHash.get(7).monsterLevel);
		assertEquals(4,init.cardHash.get(7).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(7).numTreas);
		assertEquals("Females", init.cardHash.get(7).condForBonus);
	}
	
	@Test
	public void setValuesForC8(){
		assertEquals(8,init.cardHash.get(8).monsterLevel);
		assertEquals(3,init.cardHash.get(8).monsterLevelBonus);
		assertEquals(2, init.cardHash.get(8).numTreas);
		//TODO: if the player has an even number of cards in hand, monsterLevelBonus is +3
	}
	
	@Test
	public void setValuesForC9(){
		//TODO: Need to figure out later
	}
	
	@Test
	public void setValuesForC10(){
		//TODO: An extra hand worth of items
	}
	
	@Test
	public void setValuesForC11(){
		//cult meeting card. 
	}
	
	@Test
	public void setValuesForC12(){
		//cultist class card
	}
	
	@Test
	public void setValuesForC13(){
		//TODO: Lose your class
	}
	
	@Test
	public void setValuesForC14(){
		//Curse: discard all the items that you cannot legally use (an item with Cheat is fine, but are we using Cheat???)
	}
	
	@Test
	public void setValuesForC15(){
		// -5 to your next combat. After that, the damage is permanent but there is no further penalty
	}
	
	@Test
	public void setValuesForC16(){
		// cultist -> noncultist; noncultist -> cultist -- may be removed from the deck
	}
	
	@Test
	public void setValuesForC17(){
		// If you have the Miner's Helmet or the Two-handed flashlight, discard them. -3 on your current combat. If not in combat, -3 in the next combat.
	}
	
	@Test
	public void setValuesForC18(){
		// Lose the armor you are wearing
	}
	
	@Test
	public void setValuesForC19(){
		// Lose the headgear you are wearing
	}
	
	@Test
	public void setValuesForC20(){
		// Discard all your Classes except cultist 
	}
	@Test
	public void setValuesForC21(){
		// Lose one item that you have in play. The player on your right chooses what you lose
	}
	
	@Test
	public void setValuesForC22(){
		// Lose a level 
	}
	
	@Test
	public void setValuesForC23(){
		// Discard an item or items with a printed value of at least 1000 gold pieces
	}
	
	@Test
	public void setValuesForC24(){
		// Lose the footgear you are wearing
	}
	
	@Test
	public void setValuesForC25(){
		// It is a complicated card
	}
	
	@Test
	public void setValuesForC26(){
		assertEquals(10,init.cardHash.get(26).monsterLevel);
		assertEquals(3, init.cardHash.get(26).numTreas);
	}
	
	@Test
	public void setValuesForC27(){
		assertEquals(1,init.cardHash.get(27).monsterLevel);
		assertEquals(2,init.cardHash.get(27).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(27).numTreas);
		assertEquals("Investigators", init.cardHash.get(27).condForBonus);
		assertEquals("gold",init.cardHash.get(27).badStuff);		
		assertEquals(-500,init.cardHash.get(27).badGold);
	}
	
	@Test
	public void setValuesForC28(){
		assertEquals(6,init.cardHash.get(28).monsterLevel);
		assertEquals(2, init.cardHash.get(28).numTreas);
	}
	
	@Test
	public void setValuesForC29(){
		assertEquals(10,init.cardHash.get(29).monsterLevelBonus);
		assertEquals(2, init.cardHash.get(29).bonusTreasure);
	}
	
	@Test
	public void setValuesForC30(){
		assertEquals(12,init.cardHash.get(30).monsterLevel);
		assertEquals(-2,init.cardHash.get(30).monsterLevelBonus);
		assertEquals(3, init.cardHash.get(30).numTreas);
		assertEquals("Monster Whacker", init.cardHash.get(30).condForBonus);
	}
	
	@Test
	public void setValuesForC31(){
		assertEquals(3,init.cardHash.get(31).monsterLevelBonus);
	}
	
	@Test
	public void setValuesForC32(){
		assertEquals(12,init.cardHash.get(32).monsterLevel);
		assertEquals(3, init.cardHash.get(32).numTreas);
	}
	@Test
	public void setValuesForC33(){
		assertEquals(4,init.cardHash.get(33).monsterLevel);
		assertEquals(-2,init.cardHash.get(33).monsterLevelBonus);
		assertEquals(2, init.cardHash.get(33).numTreas);
		assertEquals("Females", init.cardHash.get(33).condForBonus);
	}
	
	@Test
	public void setValuesForC34(){
		assertEquals(3,init.cardHash.get(34).monsterLevelBonus);
	}
	
	@Test
	public void setValuesForC35(){
		assertEquals(14,init.cardHash.get(35).monsterLevel);
		assertEquals(-2,init.cardHash.get(35).monsterLevelBonus);
		assertEquals(4, init.cardHash.get(35).numTreas);
		assertEquals("Professors", init.cardHash.get(35).condForBonus);
	}
	@Test
	public void setValuesForC36(){
		assertEquals(2,init.cardHash.get(36).monsterLevel);
		assertEquals(3,init.cardHash.get(36).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(36).numTreas);
		assertEquals("Males", init.cardHash.get(36).condForBonus);
		assertEquals("level", init.cardHash.get(36).badStuff);
		assertEquals(-1,init.cardHash.get(36).badLevel);
	}	

	@Test
	public void setValuesForC37(){
		assertEquals(12,init.cardHash.get(37).monsterLevel);
		assertEquals(-2,init.cardHash.get(37).monsterLevelBonus);
		assertEquals(3, init.cardHash.get(37).numTreas);
		assertEquals("Females", init.cardHash.get(37).condForBonus);
	}	
	
	@Test
	public void setValuesForC38(){
		assertEquals(24,init.cardHash.get(38).monsterLevel);
		assertEquals(5, init.cardHash.get(38).numTreas);
		//TWO LEVELS!!!!!!!!!
		//If the player fails to run away, the other player wins the game
	}	

	@Test
	public void setValuesForC39(){
		//the other player wins the game
	}
	
	@Test
	public void setValuesForC43(){
		assertEquals(10,init.cardHash.get(43).monsterLevelBonus);
		assertEquals(2, init.cardHash.get(43).bonusTreasure);
	}
	
	@Test
	public void setValuesForC42(){
		assertEquals(-5,init.cardHash.get(42).monsterLevelBonus);
		assertEquals("treas",init.cardHash.get(42).badStuff);		
		assertEquals(-1,init.cardHash.get(42).badTreas);
	}
	
	@Test
	public void setValuesForC44(){
		//Investigators class card
	}
	
	@Test
	public void setValuesForC45(){
		assertEquals(1,init.cardHash.get(45).monsterLevel);
		assertEquals(1, init.cardHash.get(45).numTreas);
		//player's footgear does not count during the fight and -2 to run away
	}
	
	@Test
	public void setValuesForC46(){
		assertEquals(8,init.cardHash.get(46).monsterLevel);
		assertEquals(2, init.cardHash.get(46).numTreas);
		assertEquals("level", init.cardHash.get(46).badStuff);
		assertEquals(-2,init.cardHash.get(46).badLevel);
	}	
	
	@Test
	public void setValuesForC47(){
		assertEquals(4,init.cardHash.get(47).monsterLevel);
		assertEquals(2, init.cardHash.get(47).numTreas);
		assertEquals("level", init.cardHash.get(47).badStuff);
		assertEquals(-1,init.cardHash.get(47).badLevel);
		assertEquals(1, init.cardHash.get(47).selfOrOther);
	}	
	@Test
	public void setValuesForC48(){
		assertEquals(5,init.cardHash.get(48).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(48).bonusTreasure);
	}
	
	@Test
	public void setValuesForC49(){
		//class card: monster whacker
	}
	
	@Test
	public void setValuesForC51(){
		assertEquals(14,init.cardHash.get(51).monsterLevel);
		assertEquals(4, init.cardHash.get(51).numTreas);
		assertEquals(3,init.cardHash.get(51).monsterLevelBonus);
		assertEquals("Males", init.cardHash.get(51).condForBonus);
		assertEquals("items", init.cardHash.get(51).badStuff);
		assertEquals(-3,init.cardHash.get(51).badItems);
	}	
	
	@Test
	public void setValuesForC52(){
		assertEquals(8,init.cardHash.get(52).monsterLevel);
		assertEquals(2, init.cardHash.get(52).numTreas);
	}	
	
	@Test
	public void setValuesForC54(){
		assertEquals(18,init.cardHash.get(54).monsterLevel);
		assertEquals(5, init.cardHash.get(54).numTreas);
		//will not fight players of level 4 or below
		//the player gets 2 levels if defeated
		//bad stuff : you are dead
		//automatically defeated by the Song of Madness card, but the player will become a cultist
	}	
	
	@Test
	public void setValuesForC55(){
		assertEquals(2,init.cardHash.get(55).monsterLevel);
		assertEquals(1, init.cardHash.get(55).numTreas);
		assertEquals(3,init.cardHash.get(55).monsterLevelBonus);
		assertEquals("Professors", init.cardHash.get(55).condForBonus);
		assertEquals("level", init.cardHash.get(55).badStuff);
		assertEquals(-1,init.cardHash.get(55).badLevel);
	}
	
	@Test
	public void setValuesForC57(){
	//Professor class card 
	}
	
	@Test
	public void setValuesForC59(){
		assertEquals(2,init.cardHash.get(59).monsterLevel);
		assertEquals(1, init.cardHash.get(59).numTreas);
		//bad stuff: the player becomes a cultist
	}
	
	@Test
	public void setValuesForC60(){
		assertEquals(5,init.cardHash.get(60).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(60).bonusTreasure);
	}
	
	@Test
	public void setValuesForC61(){
		assertEquals(8,init.cardHash.get(61).monsterLevel);
		assertEquals(2, init.cardHash.get(61).numTreas);
		assertEquals(2,init.cardHash.get(61).monsterLevelBonus);
		assertEquals("Professors", init.cardHash.get(61).condForBonus);
		//bad stuff: dead
	}
	
	@Test
	public void setValuesForC62(){
		assertEquals(1,init.cardHash.get(62).monsterLevel);
		assertEquals(1, init.cardHash.get(62).numTreas);
		assertEquals("level", init.cardHash.get(62).badStuff);
		assertEquals(-1,init.cardHash.get(62).badLevel);
	}

	@Test
	public void setValuesForC63(){
		assertEquals(16,init.cardHash.get(63).monsterLevel);
		assertEquals(4, init.cardHash.get(63).numTreas);
		assertEquals(2,init.cardHash.get(63).monsterLevelBonus);
		assertEquals("Investigators", init.cardHash.get(63).condForBonus);
		//bad stuff: become a cultist
		//gets 2 levels
		//does not pursue players of level 3 or below
	}
	
	@Test
	public void setValuesForC64(){
		assertEquals(16,init.cardHash.get(64).monsterLevel);
		assertEquals(4, init.cardHash.get(64).numTreas);
		assertEquals("level", init.cardHash.get(64).badStuff);
		assertEquals(-3,init.cardHash.get(64).badLevel);
		//gets 2 levels
		//does not pursue players of level 3 or below
	}
	
	@Test
	public void setValuesForC65(){
		assertEquals(14,init.cardHash.get(65).monsterLevel);
		assertEquals(4, init.cardHash.get(65).numTreas);
		assertEquals("level", init.cardHash.get(65).badStuff);
		assertEquals(-1,init.cardHash.get(65).badLevel);
		assertEquals(3,init.cardHash.get(65).monsterLevelBonus);
		assertEquals("Monster Whackers", init.cardHash.get(65).condForBonus);
		//gives a level to the player who has the lowest level; otherwise, just lose a level
	}
	@Test
	public void setValuesForC66(){
		assertEquals(5,init.cardHash.get(66).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(66).bonusTreasure);
	}
	@Test
	public void setValuesForC84(){
		assertEquals(500,init.cardHash.get(84).numGold);
		assertEquals(2, init.cardHash.get(84).numHands);
		assertEquals(4, init.cardHash.get(84).pLevelBonus);
	}
	
	@Test
	public void setValuesForC85(){
		assertEquals(600,init.cardHash.get(85).numGold);
	}
	
	@Test
	public void setValuesForC86(){
		assertEquals(200,init.cardHash.get(86).numGold);
		assertEquals(1, init.cardHash.get(86).numHands);
		assertEquals(2, init.cardHash.get(86).pLevelBonus);
	}
	
	@Test
	public void setValuesForC87(){
		assertEquals(200,init.cardHash.get(87).numGold);
		assertEquals(1, init.cardHash.get(87).pLevelBonus);
	}
	
	@Test
	public void setValuesForC88() {
		assertEquals(300, init.cardHash.get(88).numGold);
		assertEquals(1, init.cardHash.get(88).numHands);
		assertEquals(2, init.cardHash.get(88).pLevelBonus);
	}
	
	@Test
	public void setValuesForC89() {
		assertEquals(true, init.cardHash.get(89).goUpALevel);
	}
	
	@Test
	public void setValuesForC90() {
		assertEquals(100, init.cardHash.get(90).numGold);
		assertEquals(3, init.cardHash.get(90).pLevelBonus);
		assertEquals(3, init.cardHash.get(90).monsterLevelBonus);
		assertEquals(1, init.cardHash.get(90).numUse);
	}
	
	@Test
	public void setValuesForC94() {
		assertEquals(true, init.cardHash.get(94).goUpALevel);
	}
	
	@Test
	public void setValuesForC97() {
		assertEquals(700, init.cardHash.get(97).numGold);
		assertEquals(3, init.cardHash.get(97).pLevelBonus);
		assertEquals("Monster Whacker", init.cardHash.get(97).NotUsableBy);
		assertEquals(true,init.cardHash.get(97).headGear);
	}

	@Test
	public void setValuesForC98() {
		assertEquals(800, init.cardHash.get(98).numGold);
		assertEquals(4, init.cardHash.get(98).pLevelBonus);
		assertEquals(2, init.cardHash.get(98).numHands);
	}
	
	@Test
	public void setValuesForC99() {
		assertEquals(300, init.cardHash.get(99).numGold);
		assertEquals(1, init.cardHash.get(99).pLevelBonus);
		assertEquals(true, init.cardHash.get(99).footGear);
	}
	
	@Test
	public void setValuesForC102() {
		assertEquals(true, init.cardHash.get(102).goUpALevel);
	}
	
	@Test
	public void setValuesForC104() {
		assertEquals(true, init.cardHash.get(104).goUpALevel);
	}
	
	@Test
	public void setValuesForC107() {
		assertEquals(true, init.cardHash.get(107).goUpALevel);
	}
	
	@Test
	public void setValuesForC111() {
		assertEquals(400, init.cardHash.get(111).numGold);
		assertEquals(2, init.cardHash.get(111).pLevelBonus);
		assertEquals(true, init.cardHash.get(111).headGear);
	}
	
	@Test
	public void setValuesForC112() {
		assertEquals(100, init.cardHash.get(112).numGold);
		assertEquals(1, init.cardHash.get(112).pLevelBonus);
		assertEquals(true, init.cardHash.get(112).armor);
	}
	
	@Test
	public void setValuesForC113() {
		assertEquals(600, init.cardHash.get(113).numGold);
		assertEquals(3, init.cardHash.get(113).pLevelBonus);
		assertEquals(true, init.cardHash.get(113).footGear);
	}
	
	@Test
	public void setValuesForC114() {
		assertEquals(300, init.cardHash.get(114).numGold);
		assertEquals(2, init.cardHash.get(114).pLevelBonus);
		assertEquals(1, init.cardHash.get(114).numHands);
	}
	
	@Test
	public void setValuesForC116() {
		assertEquals(100, init.cardHash.get(116).numGold);
		assertEquals(1, init.cardHash.get(116).pLevelBonus);
		assertEquals(1, init.cardHash.get(116).numHands);
	}
	
	@Test
	public void setValuesForC117() {
		assertEquals(200, init.cardHash.get(117).numGold);
		assertEquals(2, init.cardHash.get(117).pLevelBonus);
		assertEquals(1, init.cardHash.get(117).numHands);
	}
	
	@Test
	public void setValuesForC118() {
		assertEquals(800, init.cardHash.get(118).numGold);
		assertEquals(5, init.cardHash.get(118).pLevelBonus);
		assertEquals(2, init.cardHash.get(118).numHands);
	}
	
	@Test
	public void setValuesForC119() {
		assertEquals(300, init.cardHash.get(119).numGold);
		assertEquals(3, init.cardHash.get(119).pLevelBonus);
		assertEquals(1, init.cardHash.get(119).numHands);
	}
	
	@Test
	public void setValuesForC120() {
		assertEquals(300, init.cardHash.get(120).numGold);
		assertEquals(1, init.cardHash.get(120).pLevelBonus);
		assertEquals(true, init.cardHash.get(120).headGear);
	}
	
	@Test
	public void setValuesForC125() {
		assertEquals(500, init.cardHash.get(125).numGold);
		assertEquals(1, init.cardHash.get(125).numHands);
	}
	
	@Test
	public void setValuesForC126() {
		assertEquals(900, init.cardHash.get(126).numGold);
		assertEquals(4, init.cardHash.get(126).pLevelBonus);
		assertEquals(true, init.cardHash.get(126).armor);
	}
	
	@Test
	public void setValuesForC128() {
		assertEquals(400, init.cardHash.get(128).numGold);
		assertEquals(3, init.cardHash.get(128).pLevelBonus);
		assertEquals(1, init.cardHash.get(128).numHands);
	}
	
	@Test
	public void setValuesForC131() {
		assertEquals(600, init.cardHash.get(131).numGold);
		assertEquals(2, init.cardHash.get(131).numHands);
	}
	
	@Test
	public void setValuesForC133() {
		assertEquals(400, init.cardHash.get(133).numGold);
		assertEquals(2, init.cardHash.get(133).pLevelBonus);
		assertEquals(true, init.cardHash.get(133).armor);
	}
	
	@Test
	public void setValuesForC138() {
		assertEquals(300, init.cardHash.get(138).numGold);
		assertEquals(2, init.cardHash.get(138).pLevelBonus);
		assertEquals(1, init.cardHash.get(138).numHands);
	}
	
	@Test
	public void setValuesForC143() {
		assertEquals(600, init.cardHash.get(143).numGold);
		assertEquals(4, init.cardHash.get(143).pLevelBonus);
		assertEquals(2, init.cardHash.get(143).numHands);
	}
	
	@Test
	public void setValuesForC144() {
		assertEquals(700, init.cardHash.get(144).numGold);
		assertEquals(4, init.cardHash.get(144).pLevelBonus);
		assertEquals(2, init.cardHash.get(144).numHands);
	}
}
