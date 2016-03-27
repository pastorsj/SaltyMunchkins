package munchkin.cards.treasures.api;

import munchkin.api.AbstractCard;
import munchkin.game.Game;
import munchkin.game.Player;

public abstract class AbstractTreasure extends AbstractCard implements ITreasure{
	private int gold = 0;
	private int bonus = 0;
	private Armor armor;
	private boolean discard = false;
	protected Game game;
	protected Player p1;
	protected Player p2;


	public AbstractTreasure() {
		this.game = null;
		this.p1 = null;
		this.p2 = null;
	}

	public AbstractTreasure(Game game) {
		this.game = game;
		this.p1 = game.p1;
		this.p2 = game.p2;
	}


	public boolean discard() {
		return this.discard;
	}

	public void setDiscard(boolean discard) {
		this.discard = discard;
	}

	@Override
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	@Override
	public int getGold() {
		return this.gold;
	}
	
	@Override
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public int getBonus() {
		return this.bonus;
	}
	
	@Override
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	@Override
	public Armor getArmor() {
		return this.armor;
	}

	@Override
	public void cardInHand() {
	}

	@Override
	public void cardInPlay() {
	}

	@Override
	public void cardPlayed(boolean win) {
	}
}
