package munchkin.api;

public abstract class AbstractCharacter implements ICharacter {
	private Faction faction;
	
	public void setFaction(Faction faction) {
		this.faction = faction;
	}
	
	public Faction getFaction(){
		return this.faction;
	}
}
