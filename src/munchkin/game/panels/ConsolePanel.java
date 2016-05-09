package munchkin.game.panels;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel {
	
	
	private static ConsolePanel instance;
	private JFrame frame;
	private JLabel statusLabel;
	
	private ConsolePanel(){
		
		frame = new JFrame("Game Log");
		JPanel panel = new JPanel();
		statusLabel = new JLabel();
		
		panel.add(statusLabel);
		
		frame.setPreferredSize(new Dimension(400,200));
		frame.pack();
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static ConsolePanel getInstance(){
		if(instance == null){
			instance = new ConsolePanel();
		}
		
		return instance;
		
	}
	
	public void logMessage(String message){
		statusLabel.setText(message);
		frame.repaint();
	}
	
}
