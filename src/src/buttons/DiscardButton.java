package src.buttons;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;

import src.CardFunc;
import src.Game;

public class DiscardButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public int numDiscarded=0;

	public DiscardButton(
			Game game) {
		

		String buttonText = "Discard";

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);
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
		
		
		//myGame.playACard(cardToMove);
		//myGame.updateMLevel(cardToMove);
			
//		if (cardToMove < 83) { //if the card is a door card being put in play: 
//			Card cardInPlay = ic.getCardHash().get(cardToMove);
//			if(myGame.mLevel==0){ //if a monster is in play, don't want to override
//									//with another door card.
//				//myGame.mInPlay=cardInPlay.num;
//				myGame.mLevel = ic.getCardHash().get(cardToMove).monsterLevel;
//						
//			}
//			if (myGame.mInPlay != 0) {
//				//myGame.mLevel = ic.getCardHash().get(cardToMove).monsterLevel+myGame.mLevel;
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

		

		//myGame.mframe.dispose();

		//myGame.mframe = new MFrame(myGame);
		
		myGame.mframe.revalidate();
		myGame.mframe.repaint();

	}

}
