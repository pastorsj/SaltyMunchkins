package munchkin.game.buttons;

import munchkin.game.Game;
import munchkin.game.MFrame;
import munchkin.game.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewGameButton extends JButton implements ActionListener {

	private MFrame frame;

	public NewGameButton(MFrame frame) {

		super.setMinimumSize(new Dimension(130, 30));
		super.setFont(new Font("Arial", Font.PLAIN, 15));
		super.setText("Reset Game");

		this.frame = frame;
		Game.gameSetUp = false;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.frame.dispose();
		try {
			Main.initMain();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
