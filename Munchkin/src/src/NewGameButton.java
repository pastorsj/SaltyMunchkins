package src;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class NewGameButton extends JButton implements ActionListener{
	
	public ArrayList<String> arrayOfCardLines;
	public Game myGame;
	public Player turnPlayer;
	public NewGameButton(Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
		}
		else{
			this.turnPlayer=game.p2;
		}
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("NewGame");
		
	
		
		this.myGame=game;
	
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		myGame.mframe.dispose();
		try {
			new Main().initMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		InitializeCards ic = new InitializeCards(arrayOfCardLines);
//		Game newGame = new Game(ic.doors,ic.treasure);
//		newGame.shuffle(newGame.doors);
//		newGame.shuffle(newGame.treasures);
//		newGame.p1.pHand=newGame.dealCards();
//		newGame.p2.pHand=newGame.dealCards();
//		
//		ArrayList<Integer> hand = newGame.dealCards();
//		this.turnPlayer.pHand=newGame.dealCards();
//		
//		ArrayList<Card> deal;
//		MFrame newFrame;
//		try {
//			
//			newFrame = new MFrame(newGame,arrayOfCardLines);
//			newFrame.setVisible(true);
//			newFrame.setTitle("Munchkin");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
	}

}
