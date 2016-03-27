package munchkin.cards.treasures;

import munchkin.cards.treasures.api.AbstractTreasure;
import munchkin.cards.treasures.api.Armor;
import munchkin.game.Game;

public class Necronookiecon extends AbstractTreasure {

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