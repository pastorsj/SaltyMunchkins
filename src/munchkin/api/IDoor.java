package munchkin.api;

public interface IDoor extends ICard{
	public void beforeCombat();
	public void duringCombat();
	public void afterCombat(boolean win);
}
