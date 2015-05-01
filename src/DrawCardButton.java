import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class DrawCardButton extends Button implements ActionListener{
	public MFrame frame;
	public ArrayList<String> arrayOfCardLines;
	public Game myGame;
	public ArrayList<String> arrayOfLines;
	public DrawCardButton(MFrame mframe,ArrayList<String> arrayOfLines,Game game){
		this.frame=mframe;
		this.arrayOfCardLines=arrayOfLines;
		this.myGame=game;
		this.setMaximumSize(new Dimension(100,50));
		this.arrayOfLines=arrayOfLines;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		frame.dispose();
		
		
		frame=new MFrame(myGame,this.arrayOfLines);
		
		
		
	}

}
