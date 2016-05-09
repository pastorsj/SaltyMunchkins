package munchkin.cards.treasures;

import munchkin.api.CardsInPlay;
import munchkin.api.ICard;
import munchkin.api.SpecificCardType;
import munchkin.cards.treasures.api.Armor;
import munchkin.cards.treasures.api.Treasure;
import munchkin.game.Game;

public class KickerIchor extends Treasure {

//    private Game game;

    public KickerIchor(Game game) {
        super(game);
//        this.game = game;
    }

    @Override
    public void cardInHand() {
        this.setGold(200);
        this.setCardType(SpecificCardType.Ichor);
    }

    @Override
    public void cardInPlay() {
        tripleCombatBonusForFootgear();
    }

    @Override
    public void cardPlayed(boolean win) {
        this.setDiscard();
    }

    private void tripleCombatBonusForFootgear() {
        CardsInPlay cardsInPlay = this.game.getCardsInPlay();
        int addedBonus = 0;
        for(ICard card : cardsInPlay.getCardsInPlay()) {
            if(card instanceof Treasure && card.getOwner().equals(this.getOwner())) {
                Treasure tCard = (Treasure) card;
                if(tCard.getArmor().equals(Armor.FootGear)) {
                    addedBonus += tCard.getBonus() * 2;
                } else if(tCard.getArmor().equals(Armor.PseudoFootGear)) {
                    addedBonus += tCard.getBonus() * 2;
                }
            }
        }
        this.setBonus(addedBonus);
    }
}