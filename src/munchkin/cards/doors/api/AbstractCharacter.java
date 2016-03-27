package munchkin.cards.doors.api;

import munchkin.cards.treasures.api.Faction;

public abstract class AbstractCharacter implements ICharacter {
	private Faction faction;
	
	public void setFaction(Faction faction) {
		this.faction = faction;
	}
	
	public Faction getFaction(){
		return this.faction;
	}
}
