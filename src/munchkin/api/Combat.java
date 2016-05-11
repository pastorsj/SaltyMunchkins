package munchkin.api;

import munchkin.cards.doors.api.AbstractMonster;
import munchkin.game.Action;
import munchkin.game.Game;
import munchkin.game.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamPastoriza on 3/28/16.
 */
public class Combat implements ICombat{

    private List<AbstractMonster> monsters;
    private List<IPlayer> fighters;
    private Game game;
    private List<Integer> monsterLevels;
    private Action action;


    public Combat(Game game) {
        this.game = game;
        this.action = Action.getInstance();
        this.initializeFields();
    }

    private void initializeFields() {
    	if(this.monsters == null && this.fighters == null && this.monsterLevels == null){
	        this.monsters = new ArrayList<>();
	        this.fighters = new ArrayList<>();
            this.monsterLevels = new ArrayList<>();
    	}else {
    		this.resetCombat();
    	}
    }

    @Override
    public void addMonsterToFight(AbstractMonster monster) {
        if(!this.monsters.contains(monster)) {
            this.monsterLevels.add(monster.getLevel());
            this.monsters.add(monster);
            this.addPlayerToFight(this.game.getCurrentPlayer());
        }
    }

    @Override
    public void addPlayerToFight(IPlayer player) {
        if(!this.fighters.contains(player)) {
            this.fighters.add(player);
            player.addToCombatLevel(player.getPlayerLevel());
        }
    }

    @Override
    public boolean resolveFight() {
        if(this.monsters.size()==1 && this.fighters.size() == 1) {
            resolveSingleMonsterSingleFighter();
            this.action.setValue("Resolved a fight between a single monster and a single player.");
            return true;
        } else if(this.monsters.size()==0 && this.fighters.size()==0) {
            this.action.setValue("There were no fighters or monsters in combat. Turn can be ended successfully.");
            return true;
        } else {
            System.err.println("Error in Combat: " + this.monsters.size() + " monsters and " + this.fighters.size() + " fighters");
            return false;
        }
    }

    private void resolveSingleMonsterSingleFighter() {
        IPlayer singlePlayer = fighters.get(0);
        AbstractMonster singleMonster = this.monsters.get(0);
        if(singlePlayer.getCombatLevel() > singleMonster.getLevel()) {
            //Win Condition: Fighters draw treasure cards and turn is ended
            try {
                for (int i = 0; i < singleMonster.getTreasures(); i++) {
                    this.game.dealNewTreasureCard(singlePlayer);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            this.action.setValue("You have won! You have received the appropriate number of treasures for your victory. Discard the excess cards.");
        } else {
            //Lose Condition: Must roll to attempt to run away
            this.action.setValue("Attempting to run away");
            if(Utility.rollDice() + singlePlayer.getRunAwayLevel() > 3) {
                runAway();
            } else {
                this.action.setValue("Oh no, you could not run away");
                singleMonster.badStuff();
            }
        }
    }

    @Override
    public void runAway() {
        this.action.setValue("You have run away!");
    }

    @Override
    public void finish() {
    	this.resetCombat();
    }

    @Override
    public boolean containsMonster() {
        return this.monsters.size() > 0;
    }

    @Override
    public void resetCombat() {
        this.monsters.clear();
        this.fighters.clear();
        this.monsterLevels.clear();
    }

    public void addToMonsterLevel(int level) {
        this.monsterLevels.set(0, this.monsterLevels.get(0) + level);
    }

    public int getMonsterLevel() {
        //Assuming there is only one monster
    	if(this.monsters.size() < 1) {
    		return 0;
    	}
        return this.monsterLevels.get(0);
    }
}
