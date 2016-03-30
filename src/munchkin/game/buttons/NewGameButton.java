package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class NewGameButton extends JButton implements ActionListener {

	public ArrayList<String> arrayOfCardLines;
	public Game myGame;
	public Player turnPlayer;

	public NewGameButton(String buttonText, Game game) {
		if (game.turnPlayer == 1) {
			this.turnPlayer = game.p1;
		} else {
			this.turnPlayer = game.p2;
		}

		super.setMinimumSize(new Dimension(130, 30));
		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText("Reset Game");

		this.myGame = game;

		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		myGame.mframe.dispose();
		try {
			Main.initMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// InitializeCards ic = new InitializeCards(arrayOfCardLines);
		// Game newGame = new Game(ic.doors,ic.treasure);
		// newGame.shuffle(newGame.doors);
		// newGame.shuffle(newGame.treasures);
		// newGame.p1.pHand=newGame.dealCards();
		// newGame.p2.pHand=newGame.dealCards();
		//
		// ArrayList<Integer> hand = newGame.dealCards();
		// this.turnPlayer.pHand=newGame.dealCards();
		//
		// ArrayList<Card> deal;
		// MFrame newFrame;
		// try {
		//
		// newFrame = new MFrame(newGame,arrayOfCardLines);
		// newFrame.setVisible(true);
		// newFrame.setTitle("Munchkin");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

}
