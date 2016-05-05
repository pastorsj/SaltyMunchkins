package munchkin.cards.doors;

import munchkin.cards.doors.api.AbstractMonster;

public class TheKinginPink extends AbstractMonster {
	
	@Override
	public void cardInHand() {

	}

	@Override
	public void cardInPlay() {
		if(this.getOwner().getPlayerLevel()<=3){
			return;
		}else{
			if(this.getOwner().getGender().equals("Male")){
				this.setLevel(14);
			}else{
				this.setLevel(16);
			}
			this.setTreasures(4);
		}
	}

	@Override
	public void badStuff() {
		//lose one level for every card you have in hand
		int handSize = this.getOwner().getHand().getCards().size();
		if(handSize <= this.getOwner().getPlayerLevel()){
			this.getOwner().addToPlayerLevel(-handSize);
		}else{
			this.getOwner().addToPlayerLevel(-this.getOwner().getPlayerLevel());
		}
	}
}