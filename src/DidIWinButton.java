import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class DidIWinButton extends JButton implements ActionListener{
	public MFrame frame;
	public ArrayList<String> arrayOfCardLines;
	public Player turnPlayer;
	public ArrayList<String> arrayOfLines;
	public Game myGame;
	public DidIWinButton(MFrame mframe,ArrayList<String> arrayOfLines,Game game){
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
		}
		else{
			this.turnPlayer=game.p2;
		}
		
		super.setFont(new Font("Arial",Font.PLAIN, 15));
		super.setText("WIN?");
		
		this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
		this.setMaximumSize(new Dimension(100,50));
		this.arrayOfLines=arrayOfLines;
		this.myGame=game;
		addActionListener(this);
	}
	
	public void didIWin(){
		if(turnPlayer.didIwin(myGame)){
			System.out.println("YOU WIN!");
			turnPlayer.consequence(myGame, 1);
		}
		
		else{
			int roll = myGame.rollDice(2);
			System.out.println("You rolled a " + roll);
			if (roll>4) {
				System.out.println("You ran away!");
				turnPlayer.consequence(myGame, 0);
			} else {
				System.out.println("You lose...");
				turnPlayer.consequence(myGame, -1);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		didIWin();
		
		
		
		frame.dispose();
		
		
		try {
			frame=new MFrame(myGame,this.arrayOfLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
