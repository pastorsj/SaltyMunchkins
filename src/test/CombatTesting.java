package test;

import munchkin.api.Combat;
import munchkin.api.Player;
import munchkin.cards.doors.AughostDerwraith;
import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;
import munchkin.game.Game;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CombatTesting {
	
	private Combat combat;
	private Game game;

	@Before
	public void setUp() {
		game = new Game(2);
		combat = new Combat(game);
	}
	@Test
	public void testAddMonster() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		AbstractMonster m1 = new AughostDerwraith();
		combat.addMonsterToFight(m1);
		Field monsterList = combat.getClass().getDeclaredField("monsters");
		monsterList.setAccessible(true);
		List<AbstractMonster> mL = (List<AbstractMonster>) monsterList.get(combat);
		assertEquals(1,mL.size());	
	}
	
	@Test
	public void testCantAddMonsterTwice() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		AbstractMonster m1 = new AughostDerwraith();
		combat.addMonsterToFight(m1);
		combat.addMonsterToFight(m1);
		Field monsterList = combat.getClass().getDeclaredField("monsters");
		monsterList.setAccessible(true);
		List<AbstractMonster> mL = (List<AbstractMonster>) monsterList.get(combat);
		assertEquals(1,mL.size());	
	}
	
	@Test
	public void testAddPlayer() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Player p1 = new Player();
		combat.addPlayerToFight(p1);
		Field fighterList = combat.getClass().getDeclaredField("fighters");
		fighterList.setAccessible(true);
		List<Player> players = (List<Player>) fighterList.get(combat);
		assertEquals(1,players.size());	
	}
	
	@Test
	public void testCantAddPlayerTwice() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Player p1 = new Player();
		combat.addPlayerToFight(p1);
		combat.addPlayerToFight(p1);
		Field fighterList = combat.getClass().getDeclaredField("fighters");
		fighterList.setAccessible(true);
		List<Player> players = (List<Player>) fighterList.get(combat);
		assertEquals(1,players.size());	
	}
	
	@Test
	public void testPlayerCombatLevelSet() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Player p1 = new Player();
		p1.addLevel(5);
		combat.addPlayerToFight(p1);
		Field fighterList = combat.getClass().getDeclaredField("fighters");
		fighterList.setAccessible(true);
		List<Player> players = (List<Player>) fighterList.get(combat);
		assertEquals(6, players.get(0).getCombatLevel());
	}

	
	@Test
	public void testLoseCombatAndBadStuff(){
		Player p1 = new Player();
		p1.addLevel(-1);
		p1.setFaction(Faction.Professor);
		combat.addPlayerToFight(p1);
		
		AbstractMonster m1 = new AughostDerwraith();
		m1.setOwner(p1);
		combat.addMonsterToFight(m1);
		
		assertEquals(Faction.Professor,p1.getFaction());
		p1.addToRunAwayLevel(-10);
		combat.resolveFight();
		assertEquals(Faction.UNAFFILIATED, game.getCurrentPlayer().getFaction());
		
	}
	
	@Test
	public void testLoseCombatAndRun(){
		Player p1 = new Player();
		p1.addLevel(-1);
		p1.setFaction(Faction.Professor);
		combat.addPlayerToFight(p1);
		
		AbstractMonster m1 = new AughostDerwraith();
		m1.setOwner(p1);
		combat.addMonsterToFight(m1);
		
		assertEquals(p1.getFaction(), Faction.Professor);
		p1.addToRunAwayLevel(10);
		combat.resolveFight();
		assertEquals(p1.getFaction(), Faction.Professor);

	}
	
	@Test
	public void resetCombat() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field fighterList = combat.getClass().getDeclaredField("fighters");
		fighterList.setAccessible(true);
		List<Player> players = (List<Player>) fighterList.get(combat);
		
		Field monsterList = combat.getClass().getDeclaredField("monsters");
		monsterList.setAccessible(true);
		List<AbstractMonster> mL = (List<AbstractMonster>) monsterList.get(combat);
		
		Player p1 = new Player();
		p1.addLevel(-1);
		p1.setFaction(Faction.Professor);

		AbstractMonster m1 = new AughostDerwraith();
		m1.setOwner(p1);
		combat.addMonsterToFight(m1);
		
		assertEquals(1, players.size());
		assertEquals(1, mL.size());
		
		combat.resetCombat();
		
		assertEquals(0, players.size());
		assertEquals(0, mL.size());
		
	}



}
