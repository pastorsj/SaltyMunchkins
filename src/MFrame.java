import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MFrame extends JFrame {
	private MPanel mainPanel;

	public MFrame(ArrayList<Integer> hand,ArrayList<String> arrayOfLines) throws IOException{
		super();
		
		//this.setSize(new Dimension(1300, 600));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		
		this.mainPanel = new MPanel(this,hand,arrayOfLines);
		this.add(this.mainPanel);
		
		
		this.setVisible(true);
		
		
	}
	
	
}
