package munchkin.game.buttons;

import munchkin.game.CardFunc;
import munchkin.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayCardButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public ArrayList<Integer> mCards = new ArrayList<Integer>();

	public PlayCardButton(
			Game game) {
		

		String buttonText = "PlayCard";

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);
		mCards.add(2);
		mCards.add(4);
		mCards.add(5);
		mCards.add(7);
		mCards.add(8);
		mCards.add(27);
		mCards.add(30);

		this.myGame = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToMovePos = myGame.mframe.mainPanel.bCardPanel.largeCardPos;
		int cardToMove = myGame.currentPlayer.pHand.get(cardToMovePos);
		myGame.currentPlayer.pHand.remove(cardToMovePos);
		myGame.currentPlayer.pPlay.add(cardToMove);
		int curHandLevel=0;
		int curFootLevel = 0;
		int curHeadLevel = 0;
		int curArmorLevel = 0;
		for(int i =0; i<myGame.currentPlayer.pPlay.size();i++){
			curHandLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numHands;
			curFootLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numFoot;
			curHeadLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numHead;
			curArmorLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).numArmor;
		}
		if(curHandLevel>2 || curFootLevel>1 || curHeadLevel>1 || curArmorLevel> 1){
			CardFunc cf = new CardFunc(myGame);
			cf.cantPlay();
		}
		else{
			//at this point, have checked all hands/armor/etc.
			//System.out.println("pPlay is: "+myGame.currentPlayer.pPlay);
			System.out.println("playing card: "+cardToMove);
		
			if(myGame.currentPlayer.playCard && mCards.contains(cardToMove)){
				CardFunc cf = new CardFunc(myGame);
				cf.cantPlay();
			}
			else{
				myGame.currentPlayer.playCard=true;
				myGame.playACard(cardToMove);
				if(myGame.currentPlayer.pPlay.contains(84)){
					myGame.playACard(84);
				}
				
				
				myGame.mframe.mainPanel.bCardPanel.pass.lastPass=
						myGame.mframe.mainPanel.bCardPanel.pass.nowPass;
				myGame.mframe.mainPanel.bCardPanel.pass.nowPass=false;
				
				if(myGame.monster){
					myGame.mframe.mainPanel.bCardPanel.etb.setVisible(false);
					myGame.mframe.mainPanel.bCardPanel.pass.setVisible(true);
				}
			
				else if(myGame.otherPlayer.sentCurse){
					myGame.mframe.mainPanel.bCardPanel.etb.setVisible(false);
					
				}
				else{
					myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
				}
			}
			
		}
		
		

		myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(false);
		myGame.mframe.mainPanel.bCardPanel.dcb.setVisible(false);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();
		

	}

}
