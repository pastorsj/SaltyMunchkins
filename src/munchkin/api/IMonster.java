package munchkin.api;

public interface IMonster extends IDoor {
	public void setLevel(int level);
	public void setTreasures(int treasures);
	public int getTreasures();
	public int getLevel();
}
