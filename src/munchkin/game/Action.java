package munchkin.game;


/**
 * Created by SamPastoriza on 3/27/16.
 */
public class Action {

    //Will turn into an observer/observed pattern
    private static String action;
    private static Action instance;
    private LogWindow logger;

    private Action() {
        this.action = "";
        this.logger = logger.getInstance();
    }

    public static Action getInstance() {
        if (instance == null)
            instance = new Action();
        return instance;
    }

    public void setValue(String action) {
        this.action = action;
        logger.logMessage(action);
        System.out.println(this.action);
    }

    public String getAction() {
        return this.action;
    }
}
