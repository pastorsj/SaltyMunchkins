import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;

public class MPanel extends JPanel {

	//ButtonPanel bPanel;
	MunchkinPanel munchPanel;
	//DirectionsPanel dPanel;
	CardPanel cardPanel;
	BottomCardPanel bCardPanel;

	public MPanel(MFrame frame, Player player,ArrayList<String> arrayOfLines) throws IOException {

		super();
		//this.setPreferredSize(new Dimension(1250, 600));
		
		//this.setPreferredSize(new Dimension (1900, 700));
		this.setPreferredSize(new Dimension (2000, 990));

		this.setLayout(new BorderLayout(5,5));
		

		//this.dPanel = new DirectionsPanel(bPanel);
	
		this.cardPanel = new CardPanel(frame,arrayOfLines);
		//this.cardPanel.setMaximumSize(new Dimension(200,200));

		this.munchPanel = new MunchkinPanel();
		this.bCardPanel = new BottomCardPanel(player,frame,arrayOfLines);
		//this.bPanel = new ButtonPanel(mPanel, dPanel, pPanel,cities,US);
	
		//this.add(bPanel, BorderLayout.NORTH);
		
		this.add(bCardPanel, BorderLayout.CENTER);
		
		//this.add(munchPanel, BorderLayout.CENTER);
		
		//this.add(munchPanel, BorderLayout.NORTH);
		//this.add(munchPanel,BorderLayout.NORTH);
		//this.add(Box.createRigidArea(new Dimension(5,0)));
		
		//this.add(dPanel, BorderLayout.WEST);
//		this.add(cardPanel, BorderLayout.EAST);
		
//		munchPanel.setPreferredSize(new Dimension(75, 240));
		
		
	   // panelCenter.setPreferredSize(new Dimension(panelCenter.getWidth(), 100));
	    bCardPanel.setPreferredSize(new Dimension(0, 225));
		
		
		
		this.setVisible(true);
	}

	public void paintComponent(Graphics g) {

	}
}
