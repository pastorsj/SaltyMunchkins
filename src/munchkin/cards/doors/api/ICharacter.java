package munchkin.cards.doors.api;

import munchkin.cards.treasures.api.Faction;

public interface ICharacter extends IDoor {
	public void setFaction(Faction faction);
	public Faction getFaction();
}
