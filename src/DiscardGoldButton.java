import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;

public class DiscardGoldButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;
	public Player turnPlayer;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public int goldCount = 0;
	public int goldLeft =0;
	public int goldToDiscard = 0;

	public DiscardGoldButton(
			Game game) {
		if (game.turnPlayer == 1) {
			this.turnPlayer = game.p1;
		} else {
			this.turnPlayer = game.p2;
		}

		String buttonText = "Discard >= 500 Gold ";

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);
		this.setPreferredSize(new Dimension(150,30));
		super.setVisible(false);

		
		
		

		
		this.myGame = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToMovePos = this.myGame.mframe.mainPanel.bCardPanel.largeCardPos;
		int cardToMove = myGame.currentPlayer.pHand.get(cardToMovePos);
		
		
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
		
		goldCount+=myGame.ic.getCardHash().get(cardToMove).numGold;
		CardFunc cf = new CardFunc(myGame);
		cf.discardGold();

		if (myGame.turnPlayer == 1) {
			myGame.p1 = turnPlayer;
		} else {
			myGame.p2 = turnPlayer;
		}

		//myGame.mframe.dispose();

		//myGame.mframe = new MFrame(myGame);
		
		myGame.mframe.revalidate();
		myGame.mframe.repaint();

	}

}
