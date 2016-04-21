package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import munchkin.api.ICard;
import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

public class SellGoldButton extends JButton implements ActionListener {

    private Game game;
    private MainCardPanel mainCardPanel;
    private String buttonText;

    public SellGoldButton(String buttonText, Game game, MainCardPanel panel) {

        super.setFont(new Font("Arial", Font.PLAIN, 15));
        super.setText("Sell");
        this.setPreferredSize(new Dimension(100, 30));
        super.setVisible(true);

        this.game = game;
        this.mainCardPanel = panel;
        this.buttonText = buttonText;

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ICard card = this.mainCardPanel.getSelectedCard();
        this.game.getCurrentPlayer().sellGold(card);

        this.mainCardPanel.updateLabels();
        this.mainCardPanel.repaintFrame();

    }

}
