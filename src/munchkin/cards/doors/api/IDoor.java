package munchkin.cards.doors.api;

import munchkin.api.ICard;

public interface IDoor extends ICard {
	public void beforeCombat();
	public void duringCombat();
	public void afterCombat(boolean win);
}
