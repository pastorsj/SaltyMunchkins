package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.cards.treasures.api.Faction;

public class Buggoth extends AbstractMonster {
	private Faction playerFaction;
	
	public Buggoth(){
		this.playerFaction=null;
	}
	@Override
	public void cardInHand() {
	}

	@Override
	public void cardInPlay() {
		this.setTreasures(1);
		this.setLevel(1);
		//no class abilities are allowed in the combat
		this.playerFaction=this.getOwner().getFaction();
		this.getOwner().setFaction(null);
	}

	@Override
	public void badStuff() {
		//Discard your armor
		this.getOwner().getArmorSet().removeArmor();
		//reset the player faction
		this.getOwner().setFaction(this.playerFaction);
	}
}