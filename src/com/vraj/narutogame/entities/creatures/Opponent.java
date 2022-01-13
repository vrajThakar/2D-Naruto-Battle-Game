package com.vraj.narutogame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;

import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.bullet.Bullet;
import com.vraj.narutogame.bullet.Controller;
import com.vraj.narutogame.entities.EntityManager;
import com.vraj.narutogame.entities.statics.Rock;
import com.vraj.narutogame.states.CharacterState;
import com.vraj.narutogame.states.GameState;

//Opponent class
public class Opponent extends Creature{

	//Variables
	private long jumpTime = 200;
	private boolean pressed = false;
	public int checkFreeze = 0;

	private Controller c;
	private static boolean isShooting = false;
	private static boolean isShooting2 = false;
	private static int counter = 0;
	private int counterList;

	private Handler handler;
	private boolean hit2;
	private ArrayList<Boolean> hit = new ArrayList<Boolean>();
	private int listsCount, totalCount;
	private long lastUpdated, lastUpdated2, lastUpdated3, time;

	private static OpponentHP HP =  new OpponentHP();
	public static String attack;
	public static String froze = "";

	//Constructor
	public Opponent(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		this.handler = handler;
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

		if(c.outOfBounds)counter = 0;

		if((counter > 0) && (GameState.hit2)) {
			counterList = counter;
			counter = 0;
		}
	}

	//input method
	private void getInput() {

		//moving to the right
		//D key
		if (handler.getKeyManager().right2) {
			xMove += speed;
			direction = 2;
			if(xMove > 2.5f) {
				xMove = 2.5f;
			}
		}
		
		//moving to the left
		//A key
		else if (handler.getKeyManager().left2) {
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

		//Jumping 
		if(!jumping && !jumpLock && handler.getKeyManager().up2){
			//Sound effect
			Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\jump.wav");

			yMove = -10.0f;
			jumping = true;
			falling = true;
			jumpLock = true;
		}

		//Until the up key is released, the jumpLock true, not allowing the user to jump again
		if (!handler.getKeyManager().up2)
			jumpLock = false;
		


		//regular bullet
		if(handler.getKeyManager().res && !isShooting && (new Date().getTime() > lastUpdated + 2000) 
				&& (new Date().getTime() > lastUpdated2 + 2000) && (new Date().getTime() > lastUpdated3 + 2000)) { 
			Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\ArrowWhoosh.wav");
			counter++;
			c.update();
			//so it doesnt collide with own character model
			if(direction == 4) {
				c.addBullet(new Bullet(x, y, handler, direction, 1, CharacterState.getPlayer2()));
			}
			if(direction == 2) {
				c.addBullet(new Bullet(x+bounds.width, y, handler, direction, 1, CharacterState.getPlayer2()));
			}
			isShooting = true;
			lastUpdated = new Date().getTime();
			attack = "Default";

		}
		if (!(handler.getKeyManager().res)) isShooting = false;

		//fireball/extra damage bullet
		if((CharacterState.getPlayer2().equals("Naruto")||CharacterState.getPlayer2().equals("Sasuke")||CharacterState.getPlayer2().equals("Kakashi"))
				&& (new Date().getTime() > lastUpdated + 2000)) {
			if(handler.getKeyManager().e && (new Date().getTime() > lastUpdated2 + 15000) && !isShooting2) { 
				HP.setTime(15000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\fireball.wav");
				counter++;
				c.update();
				if(direction == 4) {
					c.addBullet(new Bullet(x, y, handler, direction, 2, CharacterState.getPlayer2()));
				}

				if(direction == 2) {
					c.addBullet(new Bullet(x+bounds.width, y, handler, direction, 2, CharacterState.getPlayer2()));
				}
				isShooting2 = true;
				lastUpdated2 = new Date().getTime();
				attack = "Special";
			}
			if (!(handler.getKeyManager().e)) isShooting2 = false;
		}

		//Rock wall ability
		else if (CharacterState.getPlayer2().equals("Neji")) {
			if (handler.getKeyManager().e && (new Date().getTime() > lastUpdated2 + 30000) && !isShooting2) {
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
			if (!(handler.getKeyManager().e)) isShooting2 = false;
		}

		//Healing ability
		else if(CharacterState.getPlayer2().equals("Sakura")) {
			if (handler.getKeyManager().e && (new Date().getTime() > lastUpdated2 + 30000) && (GameState.getPlayerHits() > 0) && !isShooting2) {
				HP.setTime(30000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\heal.wav");
				GameState.setPlayerHits(GameState.getPlayerHits() - 6);
				if(GameState.getPlayerHits() < 0)
					GameState.setPlayerHits(0);
				lastUpdated2 = new Date().getTime();
				isShooting2 = true;
			}
			if (!(handler.getKeyManager().e)) isShooting2 = false;
		}

		//Freeze bullet/Paralyzing shot
		else if(CharacterState.getPlayer2().equals("Shikamaru") && (new Date().getTime() > lastUpdated + 2000)) {
			if(handler.getKeyManager().e && (new Date().getTime() > lastUpdated3 + 30000) && !isShooting2) { 
				HP.setTime(30000);
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\fireball.wav");
				counter++;
				c.update();
				if(direction == 4) {
					c.addBullet(new Bullet(x, y, handler, direction, 2, CharacterState.getPlayer2()));
				}
				if(direction == 2) {
					c.addBullet(new Bullet(x+bounds.width, y, handler, direction, 2, CharacterState.getPlayer2()));
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
			if (!(handler.getKeyManager().e)) isShooting2 = false;
		}
		//if Player freezes opponent
		if(Player.froze.equals("frozen")) {
			freeze();
		}
	}

	//Render method
	@Override
	public void render(Graphics g) {
		c.render(g);

		if(CharacterState.getPlayer2() == "Naruto") {
			g.drawImage(narutoAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer2() == "Sasuke") {
			g.drawImage(sasukeCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer2() == "Sakura") {
			g.drawImage(sakuraCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer2() == "Kakashi") {
			g.drawImage(kakashiCurrentAnimationFrame(), (int) x, (int) y,width,height, null); 
		}
		else if(CharacterState.getPlayer2() == "Neji") {
			g.drawImage(nejiCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
		else if(CharacterState.getPlayer2() == "Shikamaru") {
			g.drawImage(shikamaruCurrentAnimationFrame(), (int) x, (int) y, null); 
		}
	}

	//When Opponent gets frozen
	public void freeze() {
		xMove = 0;
		yMove = 0;
		isShooting = true;
		isShooting2 = true;
	}
	//Projectile hit boxes
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

	//Getters and setters
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
	public static boolean OpponentShoot() {
		return isShooting;
	}
	public static boolean OpponentSpecial() {
		return isShooting2;
	}
	public static OpponentHP getHP() {
		return HP;
	}

}