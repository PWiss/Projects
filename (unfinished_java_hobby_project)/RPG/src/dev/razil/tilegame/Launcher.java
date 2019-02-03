package dev.razil.tilegame;

import dev.razil.tilegame.display.Display;

public class Launcher {
	
	
	

	public static void main(String[] args) {
		Game game = new Game("Super RPG", 800,600);
		game.start();
	}

}
