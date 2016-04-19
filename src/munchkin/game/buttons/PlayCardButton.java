package munchkin.game.buttons;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import munchkin.api.ICard;
import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

public class PlayCardButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfLines;
	public ArrayList<Integer> mCards = new ArrayList<Integer>();
	
	private MainCardPanel mainCardPanel;
	private Game game;

	public PlayCardButton(String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);

		this.game = game;
		this.mainCardPanel = panel;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//TODO

		Map<String, JButton> buttonSet = this.mainCardPanel.getButtonSet();
		
		((PassCombatButton) buttonSet.get("Pass Combat")).setNowPass(false);
		ICard cardToMove = this.mainCardPanel.getSelectedCard();
		this.game.playACard(cardToMove);
//
//				if (myGame.monster) {
//					myGame.mframe.mainPanel.bCardPanel.etb.setVisible(false);
//					myGame.mframe.mainPanel.bCardPanel.pass.setVisible(true);
//				}
//
//				else if (myGame.otherPlayer.sentCurse) {
//					myGame.mframe.mainPanel.bCardPanel.etb.setVisible(false);
//
//				} else {
//					myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
//				}
//			}
//
//		}
//
		buttonSet.get("Resolve Conflict").setVisible(false);
		buttonSet.get("Discard Card").setVisible(false);
		this.mainCardPanel.repaintFrame();

	}

}
