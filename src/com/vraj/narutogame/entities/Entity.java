package com.vraj.narutogame.entities;


import java.awt.Graphics;
import java.awt.Rectangle;

import com.vraj.narutogame.Handler;

public abstract class Entity {

	//variables
	protected Handler handler;
	protected double x, y;
	protected int width;
	protected int height;
	protected Rectangle bounds; 
	protected Rectangle collision; 

	//Constructor
	public Entity(Handler handler, double x, double y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		//HitBox of entities
		bounds = new Rectangle(0, 0, width, height );
	}

	//update and render method get overridden 
	//in their respective classes
	public abstract void update();
	public abstract void render(Graphics g);


	//Getters and setters
	public Rectangle getBounds(){
		return new Rectangle((int)x + (bounds.width/2) - (bounds.width/4) , (int) y + (bounds.height/2),  bounds.width/2, bounds.height/2);
	}

	public Rectangle getBoundsTop(){
		return new Rectangle((int)x + (bounds.width/2) - (bounds.width/4), (int) y,  bounds.width/2, bounds.height/2);
	}

	public Rectangle getBoundsRight(){
		return new Rectangle((int)x + bounds.width -5 , (int) y +5,  5, bounds.height - 10);
	}

	public Rectangle getBoundsLeft(){
		return new Rectangle((int)x , (int) y + 5,  5, bounds.height - 10);
	}

	public double getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

}




