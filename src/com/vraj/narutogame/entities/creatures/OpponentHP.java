package com.vraj.narutogame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import com.vraj.narutogame.gfx.Assets;
import com.vraj.narutogame.states.CharacterState;
import com.vraj.narutogame.states.GameState;


//The UI in game for the Opponents
//HP bar and their charge up for
//the special abilities
public class OpponentHP{

	//variables
	private int health;
	private int dmgTaken; 
	private long timer, timer2;
	private static int playerDmgMultiplier = 10;
	private boolean full = false;
	private int counter = 0;
	private double t = 15000;

	//Constructor is null
	public OpponentHP() {
	}

	//Updates the health bar based on damage taken
	public void update() { 
		dmgTaken = GameState.getPlayerHits();
		health = 120 - (dmgTaken*playerDmgMultiplier);
	}

	//Render method
	public void render(Graphics g) {
		
		//HP bar
		g.setColor(Color.white);
		g.fillRect(950, 555, 120, 17);

		if(health > 40) {
			g.setColor(Color.green);
		}
		else if(health <= 40 && health > 10) {
			g.setColor(Color.yellow);
		}
		else if(health <= 10) {
			g.setColor(Color.red);
		}

		if(health > 0) {
			g.fillRect(1070 - health, 555,  health, 17);
		}
		else g.fillRect(950, 555, 120, 17);

		//HP frame
		if(CharacterState.getPlayer2() == "Naruto")
			g.drawImage(Assets.narutoHPL, 930, 550, null); 
		else if(CharacterState.getPlayer2() == "Sasuke")
			g.drawImage(Assets.sasukeHPL, 930, 550, null); 
		else if(CharacterState.getPlayer2() == "Sakura") 
			g.drawImage(Assets.sakuraHPL, 930, 550, null);
		else if(CharacterState.getPlayer2() == "Kakashi") 
			g.drawImage(Assets.kakashiHPL, 930, 550, null);
		else if(CharacterState.getPlayer2() == "Neji") 
			g.drawImage(Assets.nejiHPL, 930, 550, null);
		else if(CharacterState.getPlayer2() == "Shikamaru") 
			g.drawImage(Assets.shikamaruHPL, 930, 550, null);

		//Default ability shooting timer
		g.setColor(Color.gray);
		g.fillRect(1002, 585, 50, 50);
		g.setColor(Color.white);
		if(Opponent.OpponentShoot())
			timer = new Date().getTime();
		if(new Date().getTime() >= timer + 2000) {
			g.setColor(Color.blue);
			g.fillRect(1007, 590, 40, 6);
		}
		if(new Date().getTime() >= timer + 1500)
			g.fillRect(1007, 601, 40, 6);
		if(new Date().getTime() >= timer + 1000)
			g.fillRect(1007, 612, 40, 6);
		if(new Date().getTime() >= timer + 500)
			g.fillRect(1007, 623, 40, 6);

		//Special ability shooting timer
		counter++;
		int x = 827;
		g.setColor(new Color(255,255,255,127));
		//This is purposely for making the Ability timer flashing
		//Draws players attention that their ability is ready
		if(full) {
			if(counter%2 == 0) g.setColor(Color.red);
			else g.setColor(Color.green);
		}
		g.fillRect(822, 585, 170, 50);

		if(Opponent.OpponentSpecial()) {
			timer2 = new Date().getTime();
			full = false;
		}
		if(new Date().getTime() >= timer2 + t) {
			g.setColor(new Color(255,0,0));
			g.fillRect(x, 590, 10, 40);
			full = true;
		}
		if(new Date().getTime() >= timer2 + t - (t/16)){
			g.setColor(new Color(0,255,0));
			g.fillRect(x+10, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*2)){
			g.setColor(new Color(0,0,255));
			g.fillRect(x+20, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*3)){
			g.setColor(new Color(255,255,0));
			g.fillRect(x+30, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*4)){
			g.setColor(new Color(0,255,255));
			g.fillRect(x+40, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*5)){
			g.setColor(new Color(255,0,255));
			g.fillRect(x+50, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*6)){
			g.setColor(new Color(128,0,0));
			g.fillRect(x+60, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 +t - ((t/16)*7)){
			g.setColor(new Color(128,128,0));
			g.fillRect(x+70, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*8)){
			g.setColor(new Color(0,128,0));
			g.fillRect(x+80, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*9)){
			g.setColor(new Color(128,0,128));
			g.fillRect(x+90, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*10)){
			g.setColor(new Color(0,128,128));
			g.fillRect(x+100, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*11)){
			g.setColor(new Color(0,0,128));
			g.fillRect(x+110, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*12)){
			g.setColor(new Color(255,255,255));
			g.fillRect(x+120, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*13)){
			g.setColor(new Color(192,192,192));
			g.fillRect(x+130, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*14)){
			g.setColor(new Color(128,128,128));
			g.fillRect(x+140, 590, 10, 40);
		}
		if(new Date().getTime() >= timer2 + t - ((t/16)*15)){
			g.setColor(new Color(0,0,0));
			g.fillRect(x+150, 590, 10, 40);
		}
	}

	//Setter
	public void setTime(double time) {
		t = time;
	}


}
