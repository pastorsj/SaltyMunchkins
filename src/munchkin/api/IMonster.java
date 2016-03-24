package munchkin.api;

public interface IMonster extends IDoor {
	public void setLevel(int level);
	public void setTreasures(int treasures);
	public int getTreasures();
	public int getLevel();
	public void addTreasures(int numTreasures);
	public void addLevels(int numLevels);
}
