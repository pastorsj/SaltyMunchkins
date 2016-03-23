package munchkin.api;

public abstract class AbstractTreasure implements ITreasure{
	private int gold = 0;
	private int bonus = 0;
	private Armor armor;
	
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
}
