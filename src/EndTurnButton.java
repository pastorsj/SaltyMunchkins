import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class EndTurnButton extends JButton implements ActionListener{


	public Player turnPlayer;
	
	public Game myGame;
	public EndTurnButton(Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
			//need to set the current player to equal game.p1, then set turn player to be current player
		}
		else{
			this.turnPlayer=game.p2;
			//Same as above, except set current player to equal game.p2
		}
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("EndTurn");//Should be just Switch Sides
		//super.setVisible(false);
	
		
		this.setMaximumSize(new Dimension(100,50));
	
		this.myGame=game;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(myGame.turnPlayer==1){
			//myGame.turnPlayer=2;
			myGame.changePlayer();
		}
		else{
			//myGame.turnPlayer=1;
			myGame.changePlayer();
		}
		
		
		myGame.mframe.dispose();
		
		
		myGame.mframe=new MFrame(myGame);
		
		
		
	}

}
