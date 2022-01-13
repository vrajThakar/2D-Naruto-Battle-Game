package com.vraj.narutogame.states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.entities.creatures.Opponent;
import com.vraj.narutogame.entities.creatures.Player;
import com.vraj.narutogame.gfx.Assets;
import com.vraj.narutogame.map.Map;


public class GameState extends State {

	public static boolean hit1;
	public static boolean hit2;
	private static int numberOfHitsP2 = 0;
	private static int numberOfHitsP1 = 0;
	private static int end;


	private Map map;


	//Constructor
	public GameState(Handler handler) {
		super(handler);

		map = new Map(handler);

		handler.setMap(map);



	}

	@Override
	public void update() {

		map.update();

		//if escape key is pressed, go to pause menu
		if(handler.getKeyManager().esc) {
			State.setState(handler.getGame().pauseState);
		}

		if(hovering(new Rectangle(0,0,50,50))) {
			if(clicked()) {
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\resetSound.wav");
				State.setState(handler.getGame().pauseState);
			}
		}


		Rectangle opponentRight = handler.getMap().getEntityManager().getPlayer2().getBoundsRight();

		Rectangle playerRight = handler.getMap().getEntityManager().getPlayer().getBoundsRight();

		Rectangle playerBullet =handler.getMap().getEntityManager().getPlayer().bulletHitBox();
		Rectangle opponentbullet = handler.getMap().getEntityManager().getPlayer2().bulletHitBox();

		//check if a bullet has interested with either the player or opponent
		if(opponentRight.intersects(playerBullet)) {
			hit1 = true;
		}
		if(!(opponentRight.intersects(playerBullet))) {
			hit1 = false;
		}

		if(playerRight.intersects(opponentbullet) ) {
			hit2 = true;
		}
		if(!(playerRight.intersects(opponentbullet))) {
			hit2 = false;
		}


		if(Player.getCounter() > 0) {
			int consecutiveHits = Player.getCounter();

			for(int i=0; i<consecutiveHits; i++) {
				if(hit1){
					if(Player.attack.equals("Default")) {
						numberOfHitsP2++;
						//sound effect when a player is hit by a regular ability
						Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\hit1.wav");
					}
					else if (Player.attack.equals("Special")) {
						numberOfHitsP2 += 5;
						//sound effect when a player is hit by a special ability
						Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\hit2.wav");
					}

					if(Player.attack.equals("Freeze")) {
						Player.froze = "frozen";
					}
				}
				if(!(playerBullet.intersects(opponentRight)));//
			}
		}




		if(Opponent.getCounter() > 0) {
			int consecutiveHits = Opponent.getCounter();

			for(int i=0; i<consecutiveHits; i++) {
				if(hit2){
					if(Opponent.attack.equals("Default")) {
						numberOfHitsP1++;
						Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\hit1.wav");
					}
					else if(Opponent.attack.equals("Special")) {
						numberOfHitsP1 += 5;
						Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\hit2.wav");
					}
					if(Opponent.attack.equals("Freeze")) {
						Opponent.froze = "frozen";
					}
				}
				if(!(opponentbullet.intersects(playerRight))) {
				}
			}
		}

	}


	@Override
	public void render(Graphics g) {


		//renders to the screen
		g.drawImage(Assets.bg2, 0, 0, null);
		Player.getHP().render(g);
		Opponent.getHP().render(g);

		g.setColor(Color.gray);
		g.fillRoundRect(0, 0, 50, 50, 50, 50);
		g.setColor(Color.WHITE);
		g.fillRect(15, 10, 7, 30);
		g.fillRect(30, 10, 7, 30);
		if(hovering(new Rectangle(0,0,50,50))) {
			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRoundRect(0, 0, 50, 50, 50, 50);
			g2.setStroke(original);
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("Geeza Pro", Font.BOLD, 13));


		if(numberOfHitsP1 >= 12 && numberOfHitsP2 >= 12) {
			if(numberOfHitsP1 == numberOfHitsP2)
				end = 0;
			else if(numberOfHitsP1 > numberOfHitsP2)
				end = 2;
			else 
				end = 1;
			State.setState(handler.getGame().winState);
		}
		else if(numberOfHitsP1 >= 12) {
			end = 2;
			State.setState(handler.getGame().winState);
		}
		else if(numberOfHitsP2 >= 12) {
			end = 1;
			State.setState(handler.getGame().winState);
		}

		map.render(g);

	}

	public boolean hovering(Rectangle rounds){

		int mouseX = handler.getMouseManager().getMouseX();
		int mouseY = handler.getMouseManager().getMouseY();
		if((mouseX >= rounds.getX() && mouseX <= rounds.getX() + rounds.getWidth()) && ( mouseY >= rounds.getY() && mouseY <= rounds.getY() + rounds.getHeight())) {
			return true;
		}
		else {
			return false;
		}
	} 
	public boolean clicked(){

		if (handler.getMouseManager().isLeftPressed()) {
			return true;
		}
		return false;
	}

	public static int getPlayerHits() {
		return numberOfHitsP2;
	}
	public static int getOpponentHits() {
		return numberOfHitsP1;
	}
	public static void setOpponentHits(int num) {
		numberOfHitsP1 = num;
	}
	public static void setPlayerHits(int num) {
		numberOfHitsP2 = num;
	}
	public static int getEnd() {
		return end;
	}





}