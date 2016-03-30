package munchkin.game.buttons;

import munchkin.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SellGoldButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;

	public ArrayList<String> arrayOfLines;
	public Game myGame;
	

	public SellGoldButton(
			String buttonText, Game game) {
		

		String buttonText = "Sell";

		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText(buttonText);
		this.setPreferredSize(new Dimension(100,30));
		super.setVisible(true);

		
		

		
		this.myGame = game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cardToSellPos = this.myGame.mframe.mainPanel.bCardPanel.largeCardPos;
		int cardToSell = myGame.currentPlayer.pHand.get(cardToSellPos);

		myGame.currentPlayer.goldSold+=myGame.ic.getCardHash().get(cardToSell).numGold;
		myGame.currentPlayer.pHand.remove(cardToSellPos);
		myGame.currentPlayer.pDiscard.add(cardToSell);
		
		int levelBonus = myGame.currentPlayer.goldSold;
		int divis = (int) levelBonus/1000;
		myGame.currentPlayer.pLevel+=(int) levelBonus/1000;
		System.out.println("level bonus is: " +divis);
		myGame.mframe.mainPanel.bCardPanel.playerLevel.setText("player level: " +myGame.currentPlayer.pLevel);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();

	}

}
