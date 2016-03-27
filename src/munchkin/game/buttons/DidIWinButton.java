package munchkin.game.buttons;

import munchkin.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
		this.setVisible(false);
		addActionListener(this);
	}
	
	public void didIWin(){
		boolean bool = myGame.currentPlayer.didIwin(myGame);
	//	myGame.mframe.repaint();
	}
	
		
	

	@Override
	public void actionPerformed(ActionEvent arg0) {

		myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
		myGame.mframe.mainPanel.bCardPanel.pcb.setVisible(false);
		myGame.mframe.mainPanel.bCardPanel.sgb.setVisible(false);
		myGame.mframe.mainPanel.bCardPanel.diwb.setVisible(false);
		
		didIWin();
		myGame.mLevel=0;
		myGame.currentPlayer.monster=false;
		if(!myGame.otherPlayer.monster){
			myGame.monster=false;
		}
		myGame.currentPlayer.cLevel=myGame.currentPlayer.pLevel;
		myGame.mframe.mainPanel.bCardPanel.playerLevel.setText("player level: " +myGame.currentPlayer.pLevel);
		myGame.mframe.mainPanel.bCardPanel.playerCLevel.setText("combat level: " +myGame.currentPlayer.cLevel);
		myGame.mframe.mainPanel.bCardPanel.monsterLevel.setText("monster level: " +myGame.mLevel);
		
		myGame.currentPlayer.cLevel=myGame.currentPlayer.pLevel;
		for (int i=0; i<myGame.currentPlayer.pPlay.size();i++){
			
			myGame.currentPlayer.cLevel+=myGame.ic.getCardHash().get(myGame.currentPlayer.pPlay.get(i)).pLevelBonus;
			myGame.mframe.mainPanel.bCardPanel.playerCLevel.setText("combat level: " +myGame.currentPlayer.cLevel);
		}
		System.out.println("new clevel: "+myGame.currentPlayer.cLevel);
		
		if(myGame.currentPlayer.pLevel>=10){
			myGame.currentPlayer.winStatus=1;
		}
		//myGame.mframe.dispose();
		//myGame.mframe=new MFrame(myGame);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();
			
	}
	

}
