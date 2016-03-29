package munchkin.game;

import java.util.Random;

/**
 * Created by SamPastoriza on 3/28/16.
 */
public class Utility {


    public static int rollDice() {
        Action action = Action.getInstance();
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        action.setValue("You rolled a " + roll);
        return roll;
    }
}
