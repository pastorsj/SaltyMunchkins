package munchkin.game;

import javax.swing.*;
import java.awt.*;

public class LogWindow {
	
	
	private static LogWindow instance;
	private JFrame frame;
	private JLabel statusLabel;
	
	private LogWindow(){
		
		frame = new JFrame("Game Log");
		JPanel panel = new JPanel();
		statusLabel = new JLabel();
		
		panel.add(statusLabel);
		
		frame.setPreferredSize(new Dimension(400,200));
		frame.pack();
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static LogWindow getInstance(){
		if(instance == null){
			instance = new LogWindow();
		}
		
		return instance;
		
	}
	
	public void logMessage(String message){
		statusLabel.setText(message);
		frame.repaint();
	}
	
}
