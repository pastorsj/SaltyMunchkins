package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import munchkin.game.Game;
import munchkin.game.panels.MainCardPanel;

public class DiscardGoldButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public int goldCount = 0;
	public int goldLeft =0;
	public int goldToDiscard = 0;
	private String buttonText;
	private Game game;
	private MainCardPanel mainCardPanel;

	public DiscardGoldButton(
			String buttonText, Game game, MainCardPanel panel) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		this.buttonText = buttonText;
		//Will be be replaced later
		this.setText(buttonText);
		this.setPreferredSize(new Dimension(200,30));
		super.setVisible(false);

		this.mainCardPanel = panel;
		this.game = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		super.setText("Discard >="+goldToDiscard+ "Gold");
		
		//Exactly the same issue as the discard button
		
//		int cardToMovePos = this.myGame.mframe.mainPanel.bCardPanel.largeCardPos;
//		int cardToMove = myGame.currentPlayer.pHand.get(cardToMovePos);
//		
//		myGame.currentPlayer.pHand.remove(cardToMovePos);
//		myGame.currentPlayer.pDiscard.add(cardToMove);
//		if(cardToMove<83){
//			myGame.doorDiscards.add(cardToMove);
//		}
//		else{
//			myGame.treasDiscards.add(cardToMove);
//		}
//		
//		goldCount+=myGame.ic.getCardHash().get(cardToMove).numGold;
//		CardFunc cf = new CardFunc(myGame);
//		cf.discardGold();
//		
//		myGame.mframe.revalidate();
//		myGame.mframe.repaint();

	}
	
	@Override
	public void setVisible(boolean bool){
		super.setText("Discard >="+goldToDiscard+ "Gold ");
		super.setVisible(bool);
	}

}
