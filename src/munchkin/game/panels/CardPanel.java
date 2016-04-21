package munchkin.game.panels;

import munchkin.game.MFrame;
import munchkin.game.buttons.NewGameButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardPanel extends Panel {

	public JTextArea aboutOrigin;
	public JTextArea aboutDest;
	// public JTextArea aboutPOI;
	public BufferedImage largeCard;
	public NewGameButton ngb;

	public CardPanel(MFrame frame) throws IOException {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel about = new JLabel("Restart game:");
		this.add(about, JPanel.CENTER_ALIGNMENT);
		// this.setMinimumSize(new Dimension (2000,2000));

		// this.aboutOrigin = new JTextArea(5,30);
		// this.aboutDest = new JTextArea(5,30);
		this.aboutOrigin = new JTextArea(5, 30);
		this.aboutDest = new JTextArea(5, 30);

		aboutOrigin.setLineWrap(true);
		aboutDest.setLineWrap(true);

		// aboutOrigin.setMaximumSize(new Dimension(450,75));
		// aboutDest.setMaximumSize(new Dimension(450,75));
		aboutOrigin.setMaximumSize(new Dimension(50, 75));
		aboutDest.setMaximumSize(new Dimension(50, 75));

		this.add(aboutOrigin);
		this.add(aboutDest);

		JLabel poi = new JLabel("Cards:");
		this.add(poi);

		// this.aboutPOI = new JTextArea();
		this.largeCard = ImageIO.read(new File("src\\m1.PNG"));

		// aboutPOI.setMaximumSize(new Dimension(100,100));
		// this.add(aboutPOI);

		this.setVisible(false);
		this.repaint();
		// this.add(Box.createRigidArea(new Dimension(5,0)));

		// JScrollPane scrolly = new JScrollPane(aboutPOI);
		// scrolly.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// scrolly.setMaximumSize(new Dimension(450,320));
		// this.add(scrolly);
	}

	public void paintComponent(Graphics go) {

		super.paintComponents(go);

		go.drawImage(this.largeCard, 1000, 0, 180, 180, null);

		// go.drawImage(this.cardImage,0,250,null);

	}

}
