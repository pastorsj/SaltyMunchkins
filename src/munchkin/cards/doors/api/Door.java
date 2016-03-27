package munchkin.cards.doors.api;

import munchkin.api.AbstractCard;
import munchkin.api.IPlayer;
import munchkin.game.Game;

import java.util.Queue;

public abstract class Door extends AbstractCard implements IDoor {
    private int level = 0;
    private int treasures = 0;
    private Game game;
    private Queue<IPlayer> players;

    public Door() {
        this.game = null;
        this.players = null;
    }

    public Door(Game game) {
        this.game = game;
        this.players = game.getPlayers();
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    @Override
    public void addTreasures(int numTreasures) {
        this.treasures += numTreasures;
    }

    @Override
    public int getTreasures() {
        return this.treasures;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void cardInPlay() {

    }

    @Override
    public void cardInHand() {

    }

    @Override
    public void cardPlayed(boolean win) {

    }


}
