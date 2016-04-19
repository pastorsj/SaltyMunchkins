package munchkin.api;

import munchkin.cards.doors.api.AbstractMonster;
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


    public Combat(Game game) {
        this.game = game;
        this.initializeFields();
    }

    private void initializeFields() {
    	if(this.monsters == null && this.fighters == null){
	        this.monsters = new ArrayList<>();
	        this.fighters = new ArrayList<>();
    	}else {
    		this.resetCombat();
    	}
    }

    @Override
    public void addMonsterToFight(AbstractMonster monster) {
        if(!this.monsters.contains(monster)) {
            this.monsters.add(monster);
        }
    }

    @Override
    public void addPlayerToFight(IPlayer player) {
        if(!this.fighters.contains(player)) {
            this.fighters.add(player);
            player.setCombatLevel();
        }
    }

    @Override
    public void resolveFight() {
        if(this.monsters.size()==1 && this.fighters.size() == 1) {
            resolveSingleMonsterSingleFighter();
        } else {
            System.err.println("Error in Combat: " + this.monsters.size() + " monsters and " + this.fighters.size() + " fighters");
        }
    }

    private void resolveSingleMonsterSingleFighter() {
        IPlayer singlePlayer = fighters.get(0);
        AbstractMonster singleMonster = this.monsters.get(0);
        if(singlePlayer.getCombatLevel() > singleMonster.getLevel()) {
            //Win Condition: Fighters draw treasure cards and turn is ended
        } else {
            //Lose Condition: Must roll to attempt to run away
            if(Utility.rollDice() + singlePlayer.getRunAwayLevel() > 3) {
                runAway();
            } else {
                singleMonster.badStuff();
            }
        }
    }

    @Override
    public void runAway() {
        game.pass();
    }

    @Override
    public void finish() {
    	this.resetCombat();
    }

    @Override
    public void resetCombat() {
        this.monsters.clear();
        this.fighters.clear();
    }

    public int getMonsterLevel() {
        //Assuming there is only one monster
    	if(this.monsters.size() < 1) {
    		return 0;
    	}
        return this.monsterLevels.get(0);
    }
}
//
//
//    public void endCombat(Game myGame){
//        System.out.println("END COMBAT IS CALLED");
//        for(int i =0; i<this.pPlay.size();i++){
//
//            if(myGame.ic.getCardHash().get(this.pPlay.get(i)).discard){
//                System.out.println("delete pPlay in endCombat");
//                if(this.pPlay.get(i)<83){
//                    myGame.doorDiscards.add(this.pPlay.get(i));
//                }
//                else{
//                    myGame.treasDiscards.add(this.pPlay.get(i));
//                }
//
//                this.pPlay.remove(i);
//
//                i--;
//            }
//            else if(myGame.ic.getCardHash().get(this.pPlay.get(i)).armor ||
//                    myGame.ic.getCardHash().get(this.pPlay.get(i)).footGear ||
//                    myGame.ic.getCardHash().get(this.pPlay.get(i)).headGear ||
//                    myGame.ic.getCardHash().get(this.pPlay.get(i)).numHands>0 ||
//                    this.pPlay.get(i)==87){
//
//            }
//            else{
//                System.out.println("moving card to pHand in endCombat");
//                this.pHand.add(this.pPlay.get(i));
//                this.pPlay.remove(i);
//            }
//
//        }
//        this.handLevel = 0;
//        this.headLevel=0;
//        this.armorLevel=0;
//        myGame.mLevel = 0;
//        myGame.mframe.mainPanel.bCardPanel.dgb.goldToDiscard = 0;
//
//
//
//    }