package munchkin.cards.treasures.api;

import munchkin.api.ICard;

public interface ITreasure extends ICard {
	public void setGold(int gold);
	public int getGold();
	public void setBonus(int gold);
	public int getBonus();
	public void setArmor(Armor armor);
	public Armor getArmor();
}
