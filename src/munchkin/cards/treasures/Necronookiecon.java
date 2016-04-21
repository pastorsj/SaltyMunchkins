package munchkin.cards.treasures;

import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class Necronookiecon extends Treasure {

    public Necronookiecon(Game game) {
        super(game);
    }

    @Override
    public void cardInHand() {
        this.setGold(300);
    }

    @Override
    public void cardInPlay() {
        this.setArmor(Armor.OneHand);
        this.setBonus(3);
        //Check with the user, if they are fighting a single monster, and the card is played, they can discard this card
        //and the monster
    }
}