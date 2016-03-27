package munchkin.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import munchkin.game.panels.MPanel;


public class MFrame extends JFrame {
	public MPanel mainPanel;

	public MFrame(Game game){
		super();
		
		//this.setSize(new Dimension(1300, 600));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		
		try {
			this.mainPanel = new MPanel(this,game);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(this.mainPanel);
		setTitle("Munchkin");
		
		createMenuBar();
		
		this.setVisible(true);
		
		JOptionPane.showMessageDialog(null,"Welcome to Munchkin Cthulhu! "
				+ "This is a two player Munchkin game. For instructions on \n how to play, please "
				+ "refer to the rules in the File menu. Otherwise, have fun!");
		
		
	}

	private void createMenuBar() {
		
		 JMenuBar menubar = new JMenuBar();

	        JMenu file = new JMenu("File");
	        file.setMnemonic(KeyEvent.VK_F);

	        JMenuItem helpItem = new JMenuItem("Instructions");
	        helpItem.setMnemonic(KeyEvent.VK_I);
	        helpItem.setToolTipText("Instructions");
	        helpItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	try {
						RulesFrame frame = new RulesFrame();
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	        });
	        
	        file.add(helpItem);
	        
	        JMenuItem exitItem = new JMenuItem("Exit");
	        exitItem.setMnemonic(KeyEvent.VK_E);
	        exitItem.setToolTipText("Exit application");
	        exitItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                System.exit(0);
	            }
	        });

	        file.add(exitItem);
	        menubar.add(file);

	        setJMenuBar(menubar);
	}
	
	
}
