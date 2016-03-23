package munchkin.game.buttons;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;

import munchkin.game.CardFunc;
import munchkin.game.Game;

public class DiscardGoldButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public int goldCount = 0;
	public int goldLeft =0;
	public int goldToDiscard = 0;

	public DiscardGoldButton(
			Game game) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText("Discard >="+goldToDiscard+ "Gold ");
		this.setPreferredSize(new Dimension(200,30));
		super.setVisible(false);

		
		this.myGame = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		super.setText("Discard >="+goldToDiscard+ "Gold");
		int cardToMovePos = this.myGame.mframe.mainPanel.bCardPanel.largeCardPos;
		int cardToMove = myGame.currentPlayer.pHand.get(cardToMovePos);
		
		myGame.currentPlayer.pHand.remove(cardToMovePos);
		myGame.currentPlayer.pDiscard.add(cardToMove);
		if(cardToMove<83){
			myGame.doorDiscards.add(cardToMove);
		}
		else{
			myGame.treasDiscards.add(cardToMove);
		}
		
		goldCount+=myGame.ic.getCardHash().get(cardToMove).numGold;
		CardFunc cf = new CardFunc(myGame);
		cf.discardGold();
		
		myGame.mframe.revalidate();
		myGame.mframe.repaint();

	}
	
	@Override
	public void setVisible(boolean bool){
		super.setText("Discard >="+goldToDiscard+ "Gold ");
		super.setVisible(bool);
	}

}
