import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MFrame extends JFrame {
	//public MPanel mainPanel;
	public BottomCardPanel bCardPanel;

	public MFrame(Game game){
		super();
		
		//this.setSize(new Dimension(1300, 600));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		this.bCardPanel = new BottomCardPanel(game);
		//this.add(this.bCardPanel);
	
		
		this.add(bCardPanel, BorderLayout.CENTER);
			this.setVisible(true);
		//this.add(this.mainPanel);
		
		
		//this.setVisible(true);
		
		
	}
	
	
}
