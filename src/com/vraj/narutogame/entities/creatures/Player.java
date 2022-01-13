package com.vraj.narutogame.entities.creatures;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Date;

import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.bullet.Bullet;
import com.vraj.narutogame.bullet.Controller;
import com.vraj.narutogame.entities.EntityManager;
import com.vraj.narutogame.entities.statics.Rock;
import com.vraj.narutogame.states.CharacterState;
import com.vraj.narutogame.states.GameState;

//Player class
public class Player extends Creature{

	//Variables
	private float gravity = 1.0f;
	private long jumpTime = 200;
	private boolean pressed = false;
	public int checkFreeze = 0;

	private Controller c;
	private static boolean isShooting = false;
	private static boolean isShooting2 = false;
	private static int counter;
	private int counterList;

	private long lastUpdated, lastUpdated2, lastUpdated3, time;

	private static PlayerHP HP = new PlayerHP();
	public static String attack;
	public static String froze = "";

	//Constructor
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.width = 39;
		bounds.height = 50;

		c = new Controller(handler);
	}

	@Override
	public void update() {
		getInput();
		moveX();
		moveY();
		jump();
		Collision();
		c.update();
		HP.update();

		int check = 0;
		if(c.outOfBounds) counter = 0;
		else if((counter > 0) && (GameState.hit1)) { 
			counterList = counter;
			counter = 0;
		}


	}

	//Input method
	private void getInput() {

		//Moving to the right
		//Right arrow key
		if (handler.getKeyManager().right) {
			xMove += speed;
			direction = 2;
			if(xMove > 2.5f) {
				xMove = 2.5f;
			}
		}

		//Moving to the left
		//Left arrow key
		else if (handler.getKeyManager().left) {
			xMove -= speed;
			direction = 4; 
			if(xMove < -2.5f) {
				xMove = -2.5f;
			}
		}

		//Slow down movement when not moving
		//Physics
		else {
			if(xMove > 0) {
				xMove -= 0.4;
				if(xMove < 0) {
					xMove = 0;
				}
			}
			else if(xMove < 0) {
				xMove += 0.4;
				if(xMove > 0) {
					xMove = 0;
				}
			}
		}

		//jumping method
		if(!jumping && !jumpLock && handler.getKeyManager().up){
			//Sound effect
			Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\jump.wav");

			yMove = -10.0f;
			jumping = true;
			falling = true;
			jumpLock = true;
		}
		//Until the up key is released, the jumpLock true, not allowing the user to jump again
		if (!handler.getKeyManager().up) {
			jumpLock = false;
		}

		//regular bullet
		if(handler.getKeyManager().ent && !isShooting && (new Date().getTime() > lastUpdated + 2000) 
				&& (new Date().getTime() > lastUpdated2 + 2000) && (new Date().getTime() > lastUpdated3 + 2000)) { 
			Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\ArrowWhoosh.wav");
			counter++;
			c.update();
			if(direction == 4) {
				c.addBullet(new Bullet(x, y, handler, direction, 1, CharacterState.getPlayer1()));
			}

			if(direction == 2) {
				c.addBullet(new Bullet(x+bounds.width, y, handler, direction, 1, CharacterState.getPlayer1()));
			}
			isShooting = true;
			lastUpdated = new Date().getTime();
			attack = "Default";
		}
		if (!(handler.getKeyManager().ent)) isShooting = false;

		//Extra damage bullet
		if((CharacterState.getPlayer1().equals("Naruto")||CharacterState.getPlayer1().equals("Sasuke")||CharacterState.getPlayer1().equals("Kakashi")) 
				&& (new Date().getTime() > lastUpdated + 2000)) {
			if(handler.getKeyManager().shf && (new Date().getTime() > lastUpdated2 + 15000) && !isShooting2) { 
				HP.setTime(15000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\fireball.wav");
				counter++;
				c.update();
				if(direction == 4) {
					c.addBullet(new Bullet(x, y, handler, direction, 2, CharacterState.getPlayer1()));
				}
				if(direction == 2) {
					c.addBullet(new Bullet(x+bounds.width, y, handler, direction, 2, CharacterState.getPlayer1()));
				}
				isShooting2 = true;
				lastUpdated2 = new Date().getTime();
				attack = "Special";

			}
			if (!(handler.getKeyManager().shf)) isShooting2 = false;
		}

		//Mud walls ability
		else if (CharacterState.getPlayer1().equals("Neji")) {
			if (handler.getKeyManager().shf && (new Date().getTime() > lastUpdated2 + 30000) && !isShooting2) {
				HP.setTime(30000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\mud.wav");
				EntityManager e = handler.getMap().getEntityManager();
				if(direction == 2)
					e.addEntity(new Rock(handler,(int)x+40 ,(int)y-10));
				else if(direction == 4)
					e.addEntity(new Rock(handler,(int)x-70,(int)y-10));
				lastUpdated2 = new Date().getTime();
				isShooting2 = true;
			}
			if (!(handler.getKeyManager().shf)) isShooting2 = false;
		}

		//Healing ability
		else if(CharacterState.getPlayer1().equals("Sakura")) {
			//Healing
			if (handler.getKeyManager().shf && (new Date().getTime() > lastUpdated2 + 30000) && (GameState.getOpponentHits() > 0) && !isShooting2) {
				HP.setTime(30000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\heal.wav");
				GameState.setOpponentHits(GameState.getOpponentHits() - 6);
				if(GameState.getOpponentHits() < 0)
					GameState.setOpponentHits(0);
				lastUpdated2 = new Date().getTime();
				isShooting2 = true;
			}
			if (!(handler.getKeyManager().shf)) isShooting2 = false;
		}

		//Freeze bullet/Paralyzing shot
		else if(CharacterState.getPlayer1().equals("Shikamaru") && (new Date().getTime() > lastUpdated + 2000)) {
			if(handler.getKeyManager().shf && (new Date().getTime() > lastUpdated3 + 30000) && !isShooting2) { 
				HP.setTime(30000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\fireball.wav");
				counter++;
				c.update();
				if(direction == 4) {
					c.addBullet(new Bullet(x, y, handler, direction, 2, CharacterState.getPlayer1()));
				}

				if(direction == 2) {
					c.addBullet(new Bullet(x+bounds.width, y, handler, direction, 2, CharacterState.getPlayer1()));
				}
				isShooting2 = true;
				lastUpdated3 = new Date().getTime();
				attack = "Freeze";
				checkFreeze = 0;
			}
			if(new Date().getTime() > time + 5000) {
				checkFreeze++;
				time = new Date().getTime();
			}
			if(checkFreeze > 1) {
				froze = "";
			}
			if (!(handler.getKeyManager().shf)) isShooting2 = false;
		}

		//if opponent freezes player
		if(Opponent.froze.equals("frozen")) {
			freeze();
		}
	}

	//Render method
	@Override
	public void render(Graphics g) {
		c.render(g);

		if(CharacterState.getPlayer1() == "Naruto") {

			g.drawImage(narutoAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer1() == "Sasuke") {
			g.drawImage(sasukeCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer1() == "Sakura") {
			g.drawImage(sakuraCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer1() == "Kakashi") {
			g.drawImage(kakashiCurrentAnimationFrame(), (int) x, (int) y,width,height,null); 
		}
		else if(CharacterState.getPlayer1() == "Neji") {
			g.drawImage(nejiCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer1() == "Shikamaru") {
			g.drawImage(shikamaruCurrentAnimationFrame(), (int) x, (int) y, null); 
		}

	}

	//When player gets frozen
	public void freeze() {
		xMove = 0;
		yMove = 0;
		isShooting = true;
		isShooting2 = true;
	}
	//Projectiles hitboxes
	public Rectangle bulletHitBox() {

		Rectangle r = new Rectangle();
		r.setBounds((int)c.getX(), (int)c.getY(), 15, 15);
		return r;
	}
	public Rectangle specialtHitBox() {

		Rectangle r = new Rectangle();
		r.setBounds((int)c.getX(), (int)c.getY(), 15, 15);
		return r;
	}

	public double getControllerX() {
		return c.getX();
	}
	public double getControllerY() {
		return c.getY();
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int num) {
		counter = num;
	}
	public int getCounterList() {
		return counterList;
	}
	public static boolean PlayerShoot() {
		return isShooting;
	}
	public static boolean PlayerSpecial() {
		return isShooting2;
	}
	public static PlayerHP getHP() {
		return HP;
	}
}