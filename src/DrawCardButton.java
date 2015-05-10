import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class DrawCardButton extends Button implements ActionListener{
	
	public ArrayList<String> arrayOfCardLines;
	public Game myGame;
	public ArrayList<String> arrayOfLines;
	public DrawCardButton(Game game){
		
		this.arrayOfCardLines=arrayOfLines;
		this.myGame=game;
		this.setMaximumSize(new Dimension(100,50));
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		myGame.mframe.dispose();
		
		
		myGame.mframe=new MFrame(myGame);
		
		
		
	}

}
