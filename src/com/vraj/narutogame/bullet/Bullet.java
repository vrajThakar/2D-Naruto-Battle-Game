package com.vraj.narutogame.bullet;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.gfx.*;
import com.vraj.narutogame.entities.Entity;

//Class for all projectiles
public class Bullet{

	//variables
	private int direction;
	private int speed = 10;

	private double x;
	private double y;
	private Handler handler;
	private int attack; 
	private String character;

	//constructor
	public Bullet(double x, double y, Handler handler, int direction, int attack, String character) {
		this.x = x;
		this.y = y;

		this.handler = handler;
		this.direction = direction;
		this.attack = attack;
		this.character = character;
	}

	//update method (120 times per second)
	public void update() {
		Collision();

		if(direction == 4) x-=speed; //left
		if(direction == 2) x+=speed; //right


	}

	//render method
	public void render(Graphics g) {

		//Changes the image depending on the character
		//All the projectile special abilities look different

		if(attack == 1)
			g.drawImage(Assets.narutoBlade, (int) x, (int) y, null); 
		
		if(attack == 2) {
			
			if(character.equals("Naruto"))
				g.drawImage(Assets.rasengan, (int) x, (int) y, null);

			else if(character.equals("Sasuke")) {
				if(direction == 2)
					g.drawImage(Assets.fireball, (int) x, (int) y, null);
				else if(direction == 4)
					g.drawImage(Assets.fireballL, (int) x, (int) y, null);
			}

			else if(character.equals("Kakashi")) {
				if(direction == 2)
					g.drawImage(Assets.lightning, (int) x, (int) y, null);
				else if(direction == 4)
					g.drawImage(Assets.lightningL, (int) x, (int) y, null);
			}

			else {
				if(direction == 2)
					g.drawImage(Assets.narutoTK, (int) x, (int) y, null); 
				else if(direction == 4)
					g.drawImage(Assets.narutoTKL, (int) x, (int) y, null); 
			}
		}
	}

	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}

	//Bullet collision with players and static objects
	public void Collision() {

		for(Entity e : handler.getMap().getEntityManager().getEntities()) {
			Rectangle r = new Rectangle();
			r.setBounds((int)x, (int)y, 15, 15);

			if(e.getBoundsRight().intersects(r)) {
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\hitWall.wav");
				//sets bullet out of bounds
				//in controller when the bullet goes out of frame it deletes
				x = -100;

			}
		}
	}
}
