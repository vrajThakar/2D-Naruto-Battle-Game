package com.vraj.narutogame.map;
import java.awt.Graphics;

import com.vraj.narutogame.Handler;
import com.vraj.narutogame.entities.EntityManager;
import com.vraj.narutogame.entities.creatures.Opponent;
import com.vraj.narutogame.entities.creatures.Player;
import com.vraj.narutogame.entities.statics.WoodPlatform;

public class Map {

	private Handler handler;

	private static EntityManager entityManager;

	//Constructor
	public Map(Handler handler) {
		this.handler = handler;	 

		//entity manager is initialized, with the player and opponent x and y starting coordinates
		entityManager = new EntityManager(handler, new Player(handler, 200, 100), new Opponent(handler, 900, 100));

		map();

	}

	public void map() {
		//adds the wood platforms to the entity array list
		entityManager.addEntity(new WoodPlatform(handler,50,350));
		entityManager.addEntity(new WoodPlatform(handler,178,350));
		entityManager.addEntity(new WoodPlatform(handler,384,500));
		entityManager.addEntity(new WoodPlatform(handler,512,500));
		entityManager.addEntity(new WoodPlatform(handler,640,500));
		entityManager.addEntity(new WoodPlatform(handler,850,350));
		entityManager.addEntity(new WoodPlatform(handler,978,350));

		entityManager.addEntity(new WoodPlatform(handler,178,180));
		entityManager.addEntity(new WoodPlatform(handler,306,180));
		entityManager.addEntity(new WoodPlatform(handler,512,335));
		entityManager.addEntity(new WoodPlatform(handler,722,180));
		entityManager.addEntity(new WoodPlatform(handler,850,180));

		entityManager.addEntity(new WoodPlatform(handler,448,60));
		entityManager.addEntity(new WoodPlatform(handler,576,60));
	}


	public void update() {
		//updates the entity manager
		entityManager.update();
	}

	public void render(Graphics g) {
		//renders the entity manager to the screen
		entityManager.render(g);

	}

	//getter for entity manager
	public EntityManager getEntityManager() {
		return entityManager;
	}



}