package munchkin.api;

public abstract class AbstractMonster implements IMonster {
	private int level = 0;
	private int treasures = 0;
	
	@Override
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public void setTreasures(int treasures) {
		this.treasures = treasures;
	}
	
	@Override
	public int getTreasures() {
		return this.treasures;
	}
	
	@Override
	public int getLevel() {
		return this.level;
	}
}
