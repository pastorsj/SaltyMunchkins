package munchkin.game.panels;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by SamPastoriza on 3/27/16.
 */
public class ConsolePanel implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update to observed var: " + arg);
    }
}
