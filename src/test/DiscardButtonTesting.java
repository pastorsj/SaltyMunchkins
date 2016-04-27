package test;

import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.buttons.DiscardButton;
import munchkin.game.panels.MainCardPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by SamPastoriza on 4/26/16.
 */
public class DiscardButtonTesting {

    private Game game;
    private MainCardPanel panel;
    private DiscardButton b;
    private Robot r;

    @Before
    public void setUp() throws AWTException {
        this.r = new Robot();
        this.game = new Game(2);
        this.panel = new MainCardPanel(this.game, new MFrame(this.game));
        this.b = new DiscardButton("Discard", this.game, this.panel);
    }

    @After
    public void takeDown() {
        this.game = null;
        this.panel = null;
        this.b = null;
    }

    @Test
    public void testButtonText() {
        assertEquals("Discard", this.b.getText());
    }
}
