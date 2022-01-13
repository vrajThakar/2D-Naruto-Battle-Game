package com.vraj.narutogame.gfx;

import java.awt.image.BufferedImage;


public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;

	//Constructor
	public Animation(int speed, BufferedImage[] frames){
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	public void update(){
		//updates through all the frames
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.length)
				index = 0;
		}
	}

	//gets the index of the current animation frame
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}

}