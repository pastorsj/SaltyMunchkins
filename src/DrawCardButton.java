import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class DrawCardButton extends JButton implements ActionListener{
	
	public ArrayList<String> arrayOfCardLines;
	public Game myGame;
	public ArrayList<String> arrayOfLines;
	public DrawCardButton(Game game){
		
		this.arrayOfCardLines=arrayOfLines;
		this.myGame=game;
		this.setMaximumSize(new Dimension(100,50));
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("Draw");//Should be End Turn
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		myGame.currentPlayer.drewCard = true;
		System.out.println("DREW CARD");
		int newCard =myGame.doors.get(myGame.doors.size()-1);
		myGame.doors.remove(myGame.doors.size()-1);
		myGame.currentPlayer.pHand.add(newCard);
		myGame.mframe.mainPanel.bCardPanel.dcb.setVisible(false);
		myGame.mframe.revalidate();
		myGame.mframe.repaint();
		
		
		
	}

}
