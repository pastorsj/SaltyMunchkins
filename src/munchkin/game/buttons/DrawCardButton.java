package munchkin.game.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.panels.MainCardPanel;


public class DrawCardButton extends JButton implements ActionListener{
	
	public ArrayList<String> arrayOfCardLines;
	public ArrayList<String> arrayOfLines;

	private Game game;
	private String buttonText;
	private MainCardPanel mainCardPanel;
	public DrawCardButton(String buttonText, Game game, MainCardPanel panel){
		
		this.arrayOfCardLines=arrayOfLines;
		this.setMaximumSize(new Dimension(100,50));
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("Draw");//Should be End Turn
		
		this.buttonText = buttonText;
		this.game=game;
		this.mainCardPanel = panel;
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
//		myGame.currentPlayer.drewCard = true;
//		System.out.println("DREW CARD");
//		
//		//check if there are enough doors to draw.
//		System.out.println("size of doors: "+myGame.doors.size());
//		if(myGame.doors.size()==0){
//			myGame.doors=myGame.shuffle(myGame.doorDiscards);
//			System.out.println("size of doors after replace: "+myGame.doors.size());
//
//			myGame.doorDiscards = new ArrayList<Integer>();
//		}
//		
//		int newCard =myGame.doors.get(myGame.doors.size()-1);
//		myGame.doors.remove(myGame.doors.size()-1);
//		myGame.currentPlayer.pHand.add(newCard);
//		myGame.mframe.mainPanel.bCardPanel.dcb.setVisible(false);
//		if(myGame.currentPlayer.pHand.size()>8){
//			myGame.mframe.mainPanel.bCardPanel.db.setVisible(true);
//		}
//		else{
//			myGame.mframe.mainPanel.bCardPanel.etb.setVisible(true);
//		}
//		myGame.mframe.revalidate();
//		myGame.mframe.repaint();
		
		
		
	}

}
