package com.vraj.narutogame.entities.statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.vraj.narutogame.Handler;
import com.vraj.narutogame.gfx.Assets;

public class Rock extends StaticEntity {

	//Constructor
	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);

		//width and height of the bounds of the rectangle
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.height = 64;
		bounds.setBounds(bounds);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {

		//render to the screen 
		g.drawImage(Assets.smallR, (int) x, (int) y, width, height, null);

	}

	//get the bounds of the rock
	public Rectangle getBounds() {
		return new Rectangle ((int) x, (int) y, 64, 64);

	}



}