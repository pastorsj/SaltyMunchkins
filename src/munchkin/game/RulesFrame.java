package munchkin.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RulesFrame {

	private ArrayList<String> cardPaths;
	private int currentCard;
	
	private JButton prevButton;
	private JButton nextButton;
	private JPanel panel;
	private ImageIcon icon;
	private JLabel picLabel;
	
	public RulesFrame() throws IOException{
		
		cardPaths = new ArrayList<String>();
		
		cardPaths.add("resources/cthulhu_rules-1.png");
		cardPaths.add("resources/cthulhu_rules-2.png");
		cardPaths.add("resources/cthulhu_rules-3.png");
		cardPaths.add("resources/cthulhu_rules-4.png");
		cardPaths.add("resources/cthulhu_rules-5.png");
		cardPaths.add("resources/cthulhu_rules-6.png");
		
		
		JFrame frame = new JFrame();
		panel = new JPanel();
		
		currentCard = 0;
		
		prevButton = new JButton("previous");
		prevButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentCard >0)
					currentCard--;
				try {
					showCard();
				} catch (IOException e1) {
				}
			}
		});
		
		
		nextButton = new JButton("next");
		nextButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentCard < cardPaths.size()-1)
					currentCard++;
				try {
					showCard();
				} catch (IOException e1) {
				}
			}
		});
		
		BufferedImage rulesPic = ImageIO.read(new File(cardPaths.get(0)));
		Image scaled = rulesPic.getScaledInstance(600, 900, 0);
		
        icon = new ImageIcon(scaled);
        picLabel = new JLabel();
        picLabel.setIcon(icon);
        panel.add(prevButton);
        panel.add(picLabel);
        panel.add(nextButton);
        panel.setPreferredSize(new Dimension(1000,900));
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
		
	}
	
	private void showCard() throws IOException{

		BufferedImage rulesPic = ImageIO.read(new File(cardPaths.get(currentCard)));
		Image scaled = rulesPic.getScaledInstance(600, 900, 0);
		icon = new ImageIcon(scaled);
		picLabel.setIcon(icon);
		panel.revalidate();
	}

	
}
