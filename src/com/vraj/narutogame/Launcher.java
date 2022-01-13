package com.vraj.narutogame;

public class Launcher {
	public static void main (String[] args) {
		//Launches game
		Game game = new Game("Naruto Battle", 1152, 640, 120);
		game.start();
	}

}