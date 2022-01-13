package com.vraj.narutogame.entities.statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.vraj.narutogame.Handler;
import com.vraj.narutogame.gfx.Assets;

public class WoodPlatform extends StaticEntity {

	public WoodPlatform(Handler handler, float x, float y) {
		super(handler, x, y, 128, 34);

		//width and bounds of the wood platforms
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 128;
		bounds.height = 34;
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics g) {
		//render to the screen
		g.drawImage(Assets.woodFloor, (int) x, (int) y, width, height, null);

	}

	//get the bounds of the wood platforms
	public Rectangle getBounds() {
		return new Rectangle ((int) x, (int) y, 128, 34);

	}

}