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
import com.vraj.narutogame.gfx.Assets;


public class CharacterState extends State {

	//character selection buttons
	private Rectangle naruto;
	private Rectangle sasuke;
	private Rectangle kakashi;
	private Rectangle sakura;
	private Rectangle neji;
	private Rectangle shikamaru;
	private Rectangle start;

	private boolean instructions;

	private boolean nar, sas, sak, kak, nej, shi;

	private boolean chosen;

	private boolean flag1, flag2, flag3, flag4, flag5, flag6 = false;


	private boolean[] flaq = new boolean[6];
	private static String Player1, Player2; //Their String must be updated once chosen below

	//Constructor
	public CharacterState(Handler handler) {
		super(handler);

		//character selection buttons
		naruto = new Rectangle(28, 230, 166, 322);
		sasuke = new Rectangle(214, 230, 166, 322);
		sakura = new Rectangle(400, 230, 166, 322);
		kakashi = new Rectangle(590, 230, 166, 322);
		neji = new Rectangle(780, 230, 166, 322);
		shikamaru = new Rectangle(967, 230, 166, 322);
		start = new Rectangle(485, 570, 200, 55);

	}

	//Resets user choices
	private void restart() {
		nar = false; sas = false; sak = false; kak = false; nej = false; shi = false;
		chosen = false;
		flag1= false; flag2= false; flag3= false; flag4= false; flag5= false; flag6= false;
		Player1 = null; Player2 = null;
		for (int i  = 0; i  <6; i++) flaq[i] = false;
	}

	@Override
	public void update() {

		if(nar) {
			if(sas) chosen = true;
			else if(sak) chosen = true;
			else if(kak) chosen = true;
			else if(nej) chosen = true;
			else if(shi) chosen = true;
		}
		else if (sas) {
			if(nar) chosen = true;
			else if(sak) chosen = true;
			else if(kak) chosen = true;
			else if(nej) chosen = true;
			else if(shi) chosen = true;
		}
		else if(sak) {
			if(sas) chosen = true;
			else if(nar) chosen = true;
			else if(kak) chosen = true;
			else if(nej) chosen = true;
			else if(shi) chosen = true;
		}
		else if(kak ){
			if(sas) chosen = true;
			else if(sak) chosen = true;
			else if(nar) chosen = true;
			else if(nej) chosen = true;
			else if(shi) chosen = true;
		}
		else if(nej) {
			if(sas) chosen = true;
			else if(sak) chosen = true;
			else if(kak) chosen = true;
			else if(nar) chosen = true;
			else if(shi) chosen = true;
		}
		else if(shi) {
			if(sas) chosen = true;
			else if(sak) chosen = true;
			else if(kak) chosen = true;
			else if(nej) chosen = true;
			else if(nar) chosen = true;
		}

	}


	public boolean hovering(Rectangle rounds){
		//check if mouse is in the bounds of a character selection button
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

		//check if left clicked
		if (handler.getMouseManager().isLeftPressed()) {
			return true;
		}
		return false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.characterBg, 0, 0, null);

		int alpha = 127; // 50% transparent
		Color myColour = new Color(255, 0, 0, alpha);
		g.setFont(new Font("Geeza Pro", Font.BOLD, 22));

		//if mouse hovers over a character selection button, draw that character to the screen and highlight the button
		//if character selection button is pressed, display which player has chosen the character

		////////////////////////NARUTO/////////////////////////////////////////

		if(hovering(naruto) && !nar && !chosen) {
			g.setColor(myColour);
			g.fillRect((int) naruto.getX() , (int) naruto.getY(), (int) naruto.getWidth() , (int)naruto.getHeight());
			if(!(sas || sak || kak || nej || shi)) {
				g.drawImage(Assets.narutoStandingR[0], 150, 80,70, 100, null );
			}
			else if((sas || sak || kak || nej || shi)) {
				g.drawImage(Assets.narutoStandingL[0], 930, 80,70, 100, null );
			}
			if(clicked()) {
				nar = true;
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");
			}
			else {
				g.setColor(Color.white);
				g.drawString("Naruto's", 40, 370);
				g.drawString("Special Ability:", 40, 390);
				g.setColor(Color.green);
				g.drawString("Rasengan!", 40, 420);
			}
		}

		if (nar) {
			g.setColor(myColour);
			g.fillRect(28, 230, 166, 322);//naruto chosen
			g.setColor(Color.BLACK);
			g.drawString("Naruto", 40, 370);
			g.drawString("was Chosen", 40, 390);
			if((sas || sak || kak || nej || shi) && flag1 == false) {
				g.drawString("by Player2", 40, 410);
				Player2 = "Naruto";
				g.drawImage(Assets.narutoStandingL[0], 930, 80,70, 100, null );
				flaq[0] = true;
			}
			else if(!(sas && sak && kak && nej && shi)) {
				g.drawString("by Player1", 40, 410);
				flag1 = true;
				Player1 = "Naruto";
				g.drawImage(Assets.narutoStandingR[0], 150, 80,70, 100, null );

			}
		}

		////////////////////////SASUKE/////////////////////////////////////////

		if(hovering(sasuke) && !sas && !chosen) {
			g.setColor(myColour);
			g.fillRect((int) sasuke.getX() , (int) sasuke.getY(), (int) sasuke.getWidth() , (int)sasuke.getHeight());
			if(!(nar || sak || kak || nej || shi)) {
				g.drawImage(Assets.sasukeStandingR[0], 150, 80,70, 100, null );
			}
			else if((nar || sak || kak || nej || shi)) {
				g.drawImage(Assets.sasukeStandingL[0], 930, 80,70, 100, null );
			}
			if(clicked()) {
				sas = true;
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");
			}
			else {
				g.setColor(Color.white);
				g.drawString("Sasuke's", 226, 370);
				g.drawString("Special Ability:", 226, 390);
				g.setColor(Color.green);
				g.drawString("Fireball!", 226, 420);
			}
		}

		if (sas ) {
			g.setColor(myColour);
			g.fillRect(214, 230, 166, 322);
			g.setColor(Color.BLACK);
			g.drawString("Sasuke", 226, 370);
			g.drawString("was Chosen", 226, 390);
			if((nar || sak || kak || nej || shi) && flag2 == false) {
				g.drawString("by Player2", 226, 410);
				Player2 = "Sasuke";
				g.drawImage(Assets.sasukeStandingL[0], 930, 80,70, 100, null );
				flaq[1] = true;
			}
			else if(!(nar && sak && kak && nej && shi)) {
				g.drawString("by Player1", 226, 410);
				flag2 = true;
				Player1 = "Sasuke";
				g.drawImage(Assets.sasukeStandingR[0], 150, 80,70, 100, null );
			}
		}


		////////////////////////SAKURA/////////////////////////////////////////

		if(hovering(sakura) && !sak && !chosen) {
			g.setColor(myColour);
			g.fillRect((int) sakura.getX() , (int) sakura.getY(), (int) sakura.getWidth() , (int)sakura.getHeight());
			if(!(nar || sas || kak || nej || shi)) {
				g.drawImage(Assets.sakuraStandingR[0], 150, 80,70, 100, null );
			}
			else if((nar || sas || kak || nej || shi)) {
				g.drawImage(Assets.sakuraStandingL[0], 930, 80,70, 100, null );
			}
			if(clicked()) {
				sak = true;
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");
			}
			else {
				g.setColor(Color.white);
				g.drawString("Sakura's", 412, 370);
				g.drawString("Special Ability:", 412, 390);
				g.setColor(Color.green);
				g.drawString("Regeneration!", 412, 420);
			}
		}

		if(sak) {

			g.setColor(myColour);
			g.fillRect(400, 230, 166, 322);
			g.setColor(Color.BLACK);
			g.drawString("Sakura", 412, 370);
			g.drawString("was Chosen", 412, 390);
			if((nar || sas || kak || nej || shi) && flag3 == false) {
				g.drawString("by Player2", 412, 410);
				Player2 = "Sakura";
				flaq[2] = true;
				g.drawImage(Assets.sakuraStandingL[0], 930, 80,70, 100, null );
			}
			else if(!(nar && sas && kak && nej && shi)) {
				g.drawString("by Player1", 412, 410);
				flag3 = true;
				Player1 = "Sakura";
				g.drawImage(Assets.sakuraStandingR[0], 150, 80,70, 100, null );
			}
		}

		////////////////////////KAKASHI/////////////////////////////////////////

		if(hovering(kakashi) && !kak && !chosen) {
			g.setColor(myColour);
			g.fillRect((int) kakashi.getX() , (int) kakashi.getY(), (int) kakashi.getWidth() , (int)kakashi.getHeight());
			if(!(nar || sas || sak || nej || shi)) {
				g.drawImage(Assets.kakashiStandingR[0], 150, 80,70, 100, null );
			}
			else if((nar || sas || sak || nej || shi)) {
				g.drawImage(Assets.kakashiStandingL[0], 930, 80,70, 100, null );
			}
			if(clicked()) {
				kak = true;
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");
			}else {
				g.setColor(Color.white);
				g.drawString("Kakashi's", 602, 370);
				g.drawString("Special Ability:", 602, 390);
				g.setColor(Color.green);
				g.drawString("Lightning!", 602, 420);
			}
		}

		if(kak) {
			g.setColor(myColour);
			g.fillRect(590, 230, 166, 322);
			g.setColor(Color.BLACK);
			g.drawString("Kakashi", 602, 370);
			g.drawString("was Chosen", 602, 390);
			if((nar || sas || sak || nej || shi) && flag4 == false) {
				g.drawString("by Player2", 602, 410);
				Player2 = "Kakashi";
				g.drawImage(Assets.kakashiStandingL[0], 930, 80,70, 100, null );
				flaq[3] = true;
			}
			else if(!(nar && sas && sak && nej && shi)) {
				g.drawString("by Player1", 602, 410);
				flag4 = true;
				Player1 = "Kakashi";
				g.drawImage(Assets.kakashiStandingR[0], 150, 80,70, 100, null );
			}
		}

		////////////////////////NEJI/////////////////////////////////////////

		if(hovering(neji) && !nej && !chosen) {
			g.setColor(myColour);
			g.fillRect((int) neji.getX() , (int) neji.getY(), (int) neji.getWidth() , (int)neji.getHeight());
			if(!(nar || sas || sak || kak || shi)) {
				g.drawImage(Assets.nejiStandingR[0], 150, 80,70, 100, null );
			}
			else if((nar || sas || sak || kak || shi)) {
				g.drawImage(Assets.nejiStandingL[0], 930, 80,70, 100, null );
			}
			if(clicked()) {
				nej = true;
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");
			}
			else {
				g.setColor(Color.white);
				g.drawString("Neji's", 792, 370);
				g.drawString("Special Ability:", 792, 390);
				g.setColor(Color.green);
				g.drawString("Mud Walls!", 792, 420);
			}
		}
		if(nej) {
			g.setColor(myColour);
			g.fillRect(780, 230, 166, 322);
			g.setColor(Color.BLACK);
			g.drawString("Neji", 792, 370);
			g.drawString("was Chosen", 792, 390);
			if((nar || sas || sak || kak || shi) && flag5 == false) {
				g.drawString("by Player2", 792, 410);
				Player2 = "Neji";
				g.drawImage(Assets.nejiStandingL[0], 930, 80,70, 100, null );
				flaq[4] = true;
			}
			else if(!(nar && sas && sak && kak && shi)) {
				g.drawString("by Player1", 792, 410);
				flag5 = true;
				Player1 = "Neji";
				g.drawImage(Assets.nejiStandingR[0], 150, 80, 70, 100, null );
			}
		}

		////////////////////////Shikamaru/////////////////////////////////////////
		if(hovering(shikamaru) && !shi && !chosen) {
			g.setColor(myColour);
			g.fillRect((int) shikamaru.getX() , (int) shikamaru.getY(), (int) shikamaru.getWidth() , (int)shikamaru.getHeight());
			if(!(nar || sas || sak || kak || nej)) {
				g.drawImage(Assets.shikamaruStandingR[0], 150, 80,70, 100, null );
			}
			else if((nar || sas || sak || kak || nej)) {
				g.drawImage(Assets.shikamaruStandingL[0], 930, 80,70, 100, null );
			}
			if(clicked()) {
				shi = true;
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");
			}
			else {
				g.setColor(Color.white);
				g.drawString("Shikamaru", 979, 370);
				g.drawString("Special Ability:", 979, 390);
				g.setColor(Color.green);
				g.drawString("Paralyze Shot!", 979, 420);
			}
		}

		if(shi) {
			g.setColor(myColour);
			g.fillRect(967, 230, 166, 322);
			g.setColor(Color.BLACK);
			g.drawString("Shikamaru", 979, 370);
			g.drawString("was Chosen", 979, 390);
			if((nar || sas || sak || kak || nej) && flag6 == false) {
				g.drawString("by Player2", 979, 410);
				Player2 = "Shikamaru";
				g.drawImage(Assets.shikamaruStandingL[0], 930, 80,70, 100, null );
				flaq[5] = true;
			}
			else if(!(nar && sas && sak && kak && nej)) {
				g.drawString("by Player1", 979, 410);
				flag6 = true;
				Player1 = "Shikamaru";
				g.drawImage(Assets.shikamaruStandingR[0], 150, 80,70, 100, null );
			}
		}


		g.setColor(Color.BLACK);
		g.fillRect(380, 175, 410, 40);
		g.setColor(Color.WHITE);
		g.drawString("Click to Reset Character Choices", 420, 200);

		if(hovering(new Rectangle(380, 175, 410, 40))) {
			g.setColor(myColour);
			g.fillRect(380, 175, 410, 40);
			if(clicked()) {
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\resetSound.wav");
				restart();
			}
		}

		if(chosen == true && (flag1 || flag2 || flag3 || flag4 || flag5 || flag6)) {
			g.setColor(Color.YELLOW);
			g.fillRect((int) start.getX(), (int) start.getY(), (int) start.getWidth(), (int) start.getHeight());
			g.setColor(Color.BLACK);
			g.drawString("Start Game", 525, 605);

			if(hovering(start)) {
				Graphics2D g2 = (Graphics2D) g;
				Stroke original = g2.getStroke();
				g2.setStroke(new BasicStroke(3));
				g.setColor(Color.GREEN);
				g2.drawRect((int) start.getX(), (int) start.getY(), (int) start.getWidth(), (int) start.getHeight());
				g2.setStroke(original);
				if(clicked()) {
					instructions = true;
				}
			}
			if(instructions) {
				Color bg = new Color(255, 255, 255, 230);
				g.setColor(bg);
				g.fillRect(50, 50, 1052, 500);
				g.setFont(new Font("Geeza Pro", Font.BOLD, 22));
				g.setColor(Color.gray);
				g.drawString("Player 1", 205, 300-20);
				g.drawString("Player 2", 875, 300-20);
				g.setColor(Color.black);
				g.drawString("Special Ability", 300, 230-20);
				g.drawString("Special Ability", 720, 230-20);
				g.drawString("Normal Ability", 100, 230-20);
				g.drawString("Normal Ability", 910, 230-20);
				g.drawString("Movement", 190, 520-20);
				g.drawString("Movement", 860, 520-20);
				g.setColor(Color.green);
				g.drawString("Click Here to Start the Game", 420, 290);
				g.drawImage(Assets.keys, 0, -20, null);

				//delays so it doesn't instantly exit
				try {
					Thread.sleep(100);
				}catch(Exception e) {
					e.printStackTrace();
					new Thread().start();
					System.exit(0);
				}

				if(hovering(new Rectangle(50, 50, 1052, 500))) {
					if(clicked()) {
						Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\clickSound.wav");
						State.setState(handler.getGame().gameState);
					}
				}
				else {
					if(clicked())
						instructions = false;
				}
			}

		}

	}

	//get player 1 and player 2
	public static String getPlayer1() {
		return Player1;
	}
	public static String getPlayer2() {
		return Player2;
	}
}