import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;


public class DidIWinButton extends JButton implements ActionListener{
	//public MFrame frame;
	public ArrayList<String> arrayOfCardLines;
	//public Player turnPlayer;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public DidIWinButton(Game game){
	//	if(game.turnPlayer==1){
	//		this.turnPlayer=game.p1;
	//	}
	//	else{
	//		this.turnPlayer=game.p2;
	//	}
		

		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("WIN?");//Should be End Turn
		
		//this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
		this.setMaximumSize(new Dimension(100,50));
		this.arrayOfLines=arrayOfLines;
		this.myGame=game;
		addActionListener(this);
	}
	
	public void didIWin(){
		boolean bool = myGame.currentPlayer.didIwin(myGame);
	//	myGame.mframe.repaint();
	}
	
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		didIWin();
		myGame.mLevel=0;
		myGame.currentPlayer.cLevel=myGame.currentPlayer.pLevel;
		
		
		myGame.mframe.dispose();
		
		
		myGame.mframe=new MFrame(myGame);
		
		
		
		
	}

}
