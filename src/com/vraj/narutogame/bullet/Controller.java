package com.vraj.narutogame.bullet;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;

import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;

//class that controls bullets/projectiles
public class Controller {

	//variables
	public boolean outOfBounds;

	public boolean hit1;
	public boolean hit2;

	//linked list to keep track of bullets
	public LinkedList<Bullet> b = new LinkedList<Bullet>();
	//arraylist to keep track of bullets hitbox
	public ArrayList<Rectangle>bBox = new ArrayList<Rectangle>();

	Game game;
	Handler handler;

	//temporary bullet
	Bullet tempBullet = new Bullet(0.0,0.0,handler, 0, 1, null);

	//constructor
	public Controller(Handler handler){
		this.handler = handler;
	}

	//update method (120 times per second)
	public void update() {
		for(int i=0; i<b.size(); i++) {
			Rectangle temp = new Rectangle();
			temp.setBounds((int)tempBullet.getX(), (int)tempBullet.getY(), 15, 15);
			if(b.size() > bBox.size())
				bBox.add(null);
			bBox.set(i, temp);

			tempBullet = b.get(i);
			outOfBounds = false;

			//removes bullet when it goes out of bounds
			if(tempBullet.getX()< 0){
				removeBullet(tempBullet);
				outOfBounds = true;

			}
			if(tempBullet.getX()> 1152){
				removeBullet(tempBullet);
				outOfBounds = true;
			}
			tempBullet.update();
		}
	}

	//renders the bullet
	public void render(Graphics g) {
		for(int i=0; i<b.size(); i++) {
			tempBullet = b.get(i);
			//gets the render depending on Bullet class Render
			tempBullet.render(g);
		}
	}

	//getters and setters
	public void addBullet(Bullet block) {
		//add bullet to linked list
		b.add(block);
	}
	
	public void removeBullet(Bullet block) {
		//remove bullet from linked list
		b.remove(block);
	}

	public double getX() {
		return tempBullet.getX();
	}
	
	public double getY() {
		return tempBullet.getY();
	}

}
