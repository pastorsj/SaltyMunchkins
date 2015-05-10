import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class LetOtherPlayerPlayCardButton extends JButton implements ActionListener{
	
	public ArrayList<String> arrayOfCardLines;
	public Player turnPlayer;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public LetOtherPlayerPlayCardButton(MFrame mframe,Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
		}
		else{
			this.turnPlayer=game.p2;
		}
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("EndTurn");
		
		
		this.arrayOfCardLines=arrayOfLines;
		this.setMaximumSize(new Dimension(100,50));
		
		this.myGame=game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(myGame.turnPlayer==1){
			myGame.turnPlayer=2;
		}
		else{
			myGame.turnPlayer=1;
		}
		
		
		myGame.mframe.dispose();
		
		
		myGame.mframe=new MFrame(myGame);
		
		
		
	}

}
