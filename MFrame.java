import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MFrame extends JFrame {
	private MPanel mainPanel;

	public MFrame() throws IOException{
		super();
		
		//this.setSize(new Dimension(1300, 600));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		
		this.mainPanel = new MPanel(this);
		this.add(this.mainPanel);
		
		this.setVisible(true);
		
	}
	
	
}
