package munchkin.game;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		initMain();
	}

	public static void initMain() throws IOException {
		new MFrame(new Game(2));
	}

}