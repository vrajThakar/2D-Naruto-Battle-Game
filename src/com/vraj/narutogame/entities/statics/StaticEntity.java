package com.vraj.narutogame.entities.statics;

import com.vraj.narutogame.Handler;
import com.vraj.narutogame.entities.Entity;

//Static Entity includes entities that do not move, like platforms and rocks
public abstract class StaticEntity extends Entity {

	//Constructor
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super (handler, x, y, width, height);
	}


}