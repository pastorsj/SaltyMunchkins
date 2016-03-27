package munchkin.game;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
					System.out.println("next");
					showCard();
				} catch (IOException e1) {
				}
			}
		});
		
		BufferedImage rulesPic = ImageIO.read(new File(cardPaths.get(0)));
		
        icon = new ImageIcon(scaled);
        picLabel = new JLabel();
        picLabel.setIcon(icon);
        panel.add(prevButton);
        panel.add(picLabel);
        panel.add(nextButton);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
		
	}
	
	private void showCard() throws IOException{

		System.out.println("showing " + currentCard);
		BufferedImage rulesPic = ImageIO.read(new File(cardPaths.get(currentCard)));
		icon = new ImageIcon(scaled);
		picLabel.setIcon(icon);
		panel.revalidate();
	}

	
}
