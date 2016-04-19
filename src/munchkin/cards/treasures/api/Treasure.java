package munchkin.cards.treasures.api;

import munchkin.api.AbstractCard;
import munchkin.api.CardType;
import munchkin.api.IPlayer;
import munchkin.game.Game;

import java.util.Queue;

public abstract class Treasure extends AbstractCard implements ITreasure{
	private int gold = 0;
	private int bonus = 0;
	private Armor armor;
	protected Game game;
	protected Queue<IPlayer> players;


	public Treasure() {
		this.game = null;
		this.players = null;
		this.setCardType(CardType.Treasure);
	}

	public Treasure(Game game) {
		this.game = game;
		this.players = game.getPlayers();
		this.setCardType(CardType.Treasure);
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

	@Override
	public void setCardType() {
		this.setCardType(CardType.Treasure);
	}
}
