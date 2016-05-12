package munchkin.game;

import javax.swing.*;
import java.awt.*;

public class LogWindow {
	
	
	private static LogWindow instance;
	private JFrame frame;
	private JTextArea text;
	private JScrollPane scrollPane;
	
	private LogWindow(){
		
		frame = new JFrame("Game Log");
		this.text = new JTextArea("Game Log");
		scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		frame.setPreferredSize(new Dimension(400,200));
		frame.pack();
		frame.add(scrollPane);
		frame.setVisible(true);
	}
	
	public static LogWindow getInstance(){
		if(instance == null){
			instance = new LogWindow();
		}
		
		return instance;
		
	}
	
	public void logMessage(String message){
		String newText = message + "\n" + text.getText();
		text.setText(newText);
		frame.repaint();
	}
	
}
