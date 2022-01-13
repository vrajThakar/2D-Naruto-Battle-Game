package com.vraj.narutogame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import com.vraj.narutogame.Handler;
import com.vraj.narutogame.entities.creatures.Opponent;
import com.vraj.narutogame.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	private Opponent player2;
	private ArrayList<Entity> entities;

	//Constructor
	public EntityManager(Handler handler, Player player, Opponent player2){
		this.handler = handler;
		this.player = player;
		this.player2 = player2;

		entities = new ArrayList<Entity>();

		addEntity(player);
		addEntity(player2);
	}

	//update method (120 times per second)
	public void update(){
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.update();
		}

	}

	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}

	}

	public void addEntity(Entity e){
		entities.add(e);
	}

	//Getters and setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}
	public Opponent getPlayer2() {
		return player2;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}