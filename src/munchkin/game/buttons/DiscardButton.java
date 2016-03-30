package munchkin.game.buttons;

import munchkin.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DiscardButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public int numDiscarded=0;
	private String buttonText;

	public DiscardButton(String buttonText, Game game) {

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		this.buttonText = buttonText;
		this.setText(this.buttonText);
		this.setPreferredSize(new Dimension(100,30));
		super.setVisible(true);

		
		

		
		this.myGame = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToMovePos = this.myGame.mframe.mainPanel.bCardPanel.largeCardPos;
		int cardToMove = myGame.currentPlayer.pHand.get(cardToMovePos);
		numDiscarded+=1;
		CardFunc cf = new CardFunc(myGame);
		cf.deleteWhenDiscard();
		
		
		//game.playACard(cardToMove);
		//game.updateMLevel(cardToMove);
			
//		if (cardToMove < 83) { //if the card is a door card being put in play: 
//			Card cardInPlay = ic.getCardHash().get(cardToMove);
//			if(game.mLevel==0){ //if a monster is in play, don't want to override
//									//with another door card.
//				//game.mInPlay=cardInPlay.num;
//				game.mLevel = ic.getCardHash().get(cardToMove).monsterLevel;
//						
//			}
//			if (game.mInPlay != 0) {
//				//game.mLevel = ic.getCardHash().get(cardToMove).monsterLevel+game.mLevel;
//					
//			}
//
//		}
		

		
		myGame.currentPlayer.pHand.remove(cardToMovePos);
		myGame.currentPlayer.pDiscard.add(cardToMove);
		if(cardToMove<83){
			myGame.doorDiscards.add(cardToMove);
		}
		else{
			myGame.treasDiscards.add(cardToMove);
		}

		

		//game.mframe.dispose();

		//game.mframe = new MFrame(game);
		
		myGame.mframe.revalidate();
		myGame.mframe.repaint();

	}

}
