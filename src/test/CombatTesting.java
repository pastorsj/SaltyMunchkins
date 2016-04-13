package test;

import org.junit.Before;
import org.junit.Test;

import munchkin.api.Player;
import munchkin.api.Combat;
import munchkin.cards.doors.AughostDerwraith;
import munchkin.cards.doors.api.AbstractMonster;
import munchkin.game.Game;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CombatTesting {
	
	private Combat combat;

	@Before
	public void setUp() {
		Game game = new Game(2);
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
		assertEquals(5,players.get(0).getCombatLevel());
	}

	
	@Test
	public void testSingleMonsterSingleFighter(){
		
	}



}
