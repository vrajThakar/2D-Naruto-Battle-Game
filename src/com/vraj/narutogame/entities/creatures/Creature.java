package com.vraj.narutogame.entities.creatures;

import java.awt.image.BufferedImage;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.entities.Entity;
import com.vraj.narutogame.gfx.Animation;
import com.vraj.narutogame.gfx.Assets;

//Entities that are creatures (i.e. Player and Opponent)
public abstract class Creature extends Entity {

	//Variables
	public static final int DEFAULT_HEALTH = 10; //All caps for final variables 
	public static final float DEFAULT_SPEED = 0.05f;
	public static final int DEFAULT_CREATURE_WIDTH = 39,
			DEFAULT_CREATURE_HEIGHT = 50;
	protected int health;
	protected float speed;
	protected boolean jump;
	public static final double JUMP_STRENGTH = 20;
	protected float xMove, yMove;
	protected boolean jumping = false;
	protected boolean falling = false;
	protected boolean jumpLock = false;
	protected int direction = 2;
	float gravity = 0.5f;    //Gravity velocity; downwards pull

	protected Animation nWalkRight;
	protected Animation nStandingR;
	protected Animation nStandingL;
	protected Animation nWalkLeft;
	protected Animation nRunRight;
	protected Animation nRunLeft;
	protected Animation nJumpR;
	protected Animation nJumpL;

	protected Animation sWalkRight;
	protected Animation sStandingR;
	protected Animation sStandingL;
	protected Animation sWalkLeft;
	protected Animation sRunRight;
	protected Animation sRunLeft;
	protected Animation sJumpR;
	protected Animation sJumpL;

	protected Animation saWalkRight;
	protected Animation saStandingR;
	protected Animation saStandingL;
	protected Animation saWalkLeft;
	protected Animation saRunRight;
	protected Animation saRunLeft;
	protected Animation saJumpR;
	protected Animation saJumpL;

	protected Animation kWalkRight;
	protected Animation kStandingR;
	protected Animation kStandingL;
	protected Animation kWalkLeft;
	protected Animation kRunRight;
	protected Animation kRunLeft;
	protected Animation kJumpR;
	protected Animation kJumpL;

	protected Animation nejWalkRight;
	protected Animation nejStandingR;
	protected Animation nejStandingL;
	protected Animation nejWalkLeft;
	protected Animation nejRunRight;
	protected Animation nejRunLeft;
	protected Animation nejJumpR;
	protected Animation nejJumpL;

	protected Animation shiWalkRight;
	protected Animation shiStandingR;
	protected Animation shiStandingL;
	protected Animation shiWalkLeft;
	protected Animation shiRunRight;
	protected Animation shiRunLeft;
	protected Animation shiJumpR;
	protected Animation shiJumpL;

	//Constructor
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;

		//All the animations for each character
		nStandingR = new Animation(500, Assets.narutoStandingR);
		nStandingL = new Animation(500, Assets.narutoStandingL);
		nWalkRight = new Animation(150, Assets.narutoWalkingRight);
		nWalkLeft = new Animation(150, Assets.narutoWalkingLeft);
		nRunRight = new Animation(150, Assets.narutoRunningRight);
		nRunLeft = new Animation(150, Assets.narutoRunningLeft);
		nJumpR = new Animation(50, Assets.narutoJumpR);
		nJumpL = new Animation(150, Assets.narutoJumpL);

		sStandingR = new Animation(500, Assets.sasukeStandingR);
		sStandingL = new Animation(500, Assets.sasukeStandingL);
		sWalkRight = new Animation(150, Assets.sasukeWalkingRight);
		sWalkLeft = new Animation(150, Assets.sasukeWalkingLeft);
		sRunRight = new Animation(150, Assets.sasukeRunningRight);
		sRunLeft = new Animation(150, Assets.sasukeRunningLeft);
		sJumpR = new Animation(50, Assets.sasukeJumpR);
		sJumpL = new Animation(150, Assets.sasukeJumpL);

		saStandingR = new Animation(500, Assets.sakuraStandingR);
		saStandingL = new Animation(500, Assets.sakuraStandingL);
		saWalkRight = new Animation(150, Assets.sakuraWalkingRight);
		saWalkLeft = new Animation(150, Assets.sakuraWalkingLeft);
		saRunRight = new Animation(150, Assets.sakuraRunningRight);
		saRunLeft = new Animation(150, Assets.sakuraRunningLeft);
		saJumpR = new Animation(50, Assets.sakuraJumpR);
		saJumpL = new Animation(150, Assets.sakuraJumpL);

		kStandingR = new Animation(500, Assets.kakashiStandingR);
		kStandingL = new Animation(500, Assets.kakashiStandingL);
		kWalkRight = new Animation(150, Assets.kakashiWalkingRight);
		kWalkLeft = new Animation(150, Assets.kakashiWalkingLeft);
		kRunRight = new Animation(150, Assets.kakashiRunningRight);
		kRunLeft = new Animation(150, Assets.kakashiRunningLeft);
		kJumpR = new Animation(50, Assets.kakashiJumpR);
		kJumpL = new Animation(150, Assets.kakashiJumpL);

		nejStandingR = new Animation(500, Assets.nejiStandingR);
		nejStandingL = new Animation(500, Assets.nejiStandingL);
		nejWalkRight = new Animation(150, Assets.nejiWalkingRight);
		nejWalkLeft = new Animation(150, Assets.nejiWalkingLeft);
		nejRunRight = new Animation(150, Assets.nejiRunningRight);
		nejRunLeft = new Animation(150, Assets.nejiRunningLeft);
		nejJumpR = new Animation(50, Assets.nejiJumpR);
		nejJumpL = new Animation(150, Assets.nejiJumpL);

		shiStandingR = new Animation(500, Assets.shikamaruStandingR);
		shiStandingL = new Animation(500, Assets.shikamaruStandingL);
		shiWalkRight = new Animation(150, Assets.shikamaruWalkingRight);
		shiWalkLeft = new Animation(150, Assets.shikamaruWalkingLeft);
		shiRunRight = new Animation(150, Assets.shikamaruRunningRight);
		shiRunLeft = new Animation(150, Assets.shikamaruRunningLeft);
		shiJumpR = new Animation(50, Assets.shikamaruJumpR);
		shiJumpL = new Animation(150, Assets.shikamaruJumpL);
	}


	//Movement for all the creatures
	public void moveX(){
		x += xMove;

		//barriers on the sides of the display
		if(x<=0)
			x = 0;
		if(x>=1110) 
			x = 1109;
	}

	public void moveY(){
		y += yMove;

		//Character is able to walk on the bottom
		if(y > 580){
			y = 580;
			yMove = 0.0f;
			jumping = false;
			falling = false;
		}
	}

	//Jump method
	public void jump() {
		if( falling || jumping) {
			yMove += gravity;
			y += yMove;
			x += xMove;
		}
	}

	//Collisions
	public void Collision() {

		for(Entity e : handler.getMap().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}

			if(e.equals(handler.getMap().getEntityManager().getEntities().get(0))){
				if (e.getBounds().intersects(handler.getMap().getEntityManager().getEntities().get(1).getBounds())) {
					continue;
				}
			}

			if(e.equals(handler.getMap().getEntityManager().getEntities().get(1))){
				if (e.getBounds().intersects(handler.getMap().getEntityManager().getEntities().get(0).getBounds())) {
					continue;
				}
			}


			if (e.getBounds().intersects(getBoundsTop())) {
				int yTemp = handler.getMap().getEntityManager().getEntities().indexOf(e);
				y = handler.getMap().getEntityManager().getEntities().get(yTemp).getY() + e.getHeight(); 
				yMove = 0.0f;

			}

			if (e.getBounds().intersects(getBounds())) {
				int yTemp = handler.getMap().getEntityManager().getEntities().indexOf(e);
				y = handler.getMap().getEntityManager().getEntities().get(yTemp).getY() - bounds.height;
				yMove = 0.0f;
				falling = false;
				jumping = false;


			} else {
				falling = true; 

				if (e.getBounds().intersects(getBoundsRight())) {
					int xTemp = handler.getMap().getEntityManager().getEntities().indexOf(e);
					xMove = speed; 
					x = handler.getMap().getEntityManager().getEntities().get(xTemp).getX() - bounds.width;
				}
				if (e.getBounds().intersects(getBoundsLeft())) {
					int xTemp = handler.getMap().getEntityManager().getEntities().indexOf(e);
					xMove = speed;
					x = (handler.getMap().getEntityManager().getEntities().get(xTemp).getX()) + e.getWidth();

				}
			}
		}
	}





	//Getters and setters
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	//Returning all the animation frames 
	protected BufferedImage narutoAnimationFrame() {

		if (jumping && direction == 2) {
			nJumpR.update();
			return nJumpR.getCurrentFrame();
		}

		else if (jumping && direction == 4) {
			nJumpL.update();
			return nJumpL.getCurrentFrame();
		}

		else if (xMove < 0 && xMove > -2.4) {
			nWalkLeft.update();
			return nWalkLeft.getCurrentFrame();
		}

		else if (xMove <= -2.5) {
			nRunLeft.update();
			return nRunLeft.getCurrentFrame();
		}

		else if(xMove > 0 && xMove < 2.4) {
			nWalkRight.update();
			return nWalkRight.getCurrentFrame();
		}

		else if (xMove >= 2.5) {
			nRunRight.update();
			return nRunRight.getCurrentFrame();
		}


		else if (xMove < 0 && jumping) {
			nJumpL.update();
			return nJumpL.getCurrentFrame();
		}
		
		else if (xMove == 0 && direction == 2) {
			nStandingR.update();
			return nStandingR.getCurrentFrame();
		}
		
		else {
			nStandingL.update();
			return nStandingL.getCurrentFrame();
		}

	}

	protected BufferedImage sasukeCurrentAnimationFrame() {


		if (jumping && direction == 2) {
			sJumpR.update();
			return sJumpR.getCurrentFrame();
		}

		else if (jumping && direction == 4) {
			sJumpL.update();
			return sJumpL.getCurrentFrame();
		}


		else if (xMove < 0 && xMove > -2.4) {
			sWalkLeft.update();
			return sWalkLeft.getCurrentFrame();
		}

		else if (xMove <= -2.5) {
			//System.out.println("am here");
			sRunLeft.update();
			return sRunLeft.getCurrentFrame();
		}

		else if(xMove > 0 && xMove < 2.4) {
			sWalkRight.update();
			return sWalkRight.getCurrentFrame();
		}

		else if (xMove >= 2.5) {
			//System.out.println("am here");
			sRunRight.update();
			return sRunRight.getCurrentFrame();
		}

		else if (xMove < 0 && jumping) {
			sJumpL.update();
			return sJumpL.getCurrentFrame();
		}
		
		else if (xMove == 0 && direction == 2) {
			sStandingR.update();
			return sStandingR.getCurrentFrame();
		}
		
		else {
			sStandingL.update();
			return sStandingL.getCurrentFrame();
		}
	}

	protected BufferedImage sakuraCurrentAnimationFrame() {


		if (jumping && direction == 2) {
			saJumpR.update();
			return saJumpR.getCurrentFrame();
		}

		else if (jumping && direction == 4) {
			saJumpL.update();
			return saJumpL.getCurrentFrame();
		}

		else if (xMove < 0 && xMove > -2.4) {
			saWalkLeft.update();
			return saWalkLeft.getCurrentFrame();
		}

		else if (xMove <= -2.5) {
			saRunLeft.update();
			return saRunLeft.getCurrentFrame();
		}

		else if(xMove > 0 && xMove < 2.4) {
			saWalkRight.update();
			return saWalkRight.getCurrentFrame();
		}

		else if (xMove >= 2.5) {
			saRunRight.update();
			return saRunRight.getCurrentFrame();
		}

		else if (xMove < 0 && jumping) {
			saJumpL.update();
			return saJumpL.getCurrentFrame();
		}
		
		else if (xMove == 0 && direction == 2) {
			saStandingR.update();
			return saStandingR.getCurrentFrame();
		}
		else {
			saStandingL.update();
			return saStandingL.getCurrentFrame();
		}

	}

	protected BufferedImage kakashiCurrentAnimationFrame() {

		if (jumping && direction == 2) {
			kJumpR.update();
			return kJumpR.getCurrentFrame();
		}

		else if (jumping && direction == 4) {
			kJumpL.update();
			return kJumpL.getCurrentFrame();
		}

		else if (xMove < 0 && xMove > -2.4) {
			kWalkLeft.update();
			return kWalkLeft.getCurrentFrame();
		}

		else if (xMove <= -2.5) {
			kRunLeft.update();
			return kRunLeft.getCurrentFrame();
		}

		else if(xMove > 0 && xMove < 2.4) {
			kWalkRight.update();
			return kWalkRight.getCurrentFrame();
		}

		else if (xMove >= 2.5) {
			kRunRight.update();
			return kRunRight.getCurrentFrame();
		}

		else if (xMove < 0 && jumping) {
			kJumpL.update();
			return kJumpL.getCurrentFrame();
		}
		
		else if (xMove == 0 && direction == 2) {
			kStandingR.update();
			return kStandingR.getCurrentFrame();
		}
		
		else {
			kStandingL.update();
			return kStandingL.getCurrentFrame();
		}
	}

	protected BufferedImage nejiCurrentAnimationFrame() {

		if (jumping && direction == 2) {
			nejJumpR.update();
			return nejJumpR.getCurrentFrame();
		}

		else if (jumping && direction == 4) {
			nejJumpL.update();
			return nejJumpL.getCurrentFrame();
		}

		else if (xMove < 0 && xMove > -2.4) {
			nejWalkLeft.update();
			return nejWalkLeft.getCurrentFrame();
		}

		else if (xMove <= -2.5) {
			nejRunLeft.update();
			return nejRunLeft.getCurrentFrame();
		}

		else if(xMove > 0 && xMove < 2.4) {
			nejWalkRight.update();
			return nejWalkRight.getCurrentFrame();
		}

		else if (xMove >= 2.5) {
			nejRunRight.update();
			return nejRunRight.getCurrentFrame();
		}

		else if (xMove < 0 && jumping) {
			nejJumpL.update();
			return nejJumpL.getCurrentFrame();
		}
		
		else if (xMove == 0 && direction == 2) {
			nejStandingR.update();
			return nejStandingR.getCurrentFrame();
		}
		
		else {
			nejStandingL.update();
			return nejStandingL.getCurrentFrame();
		}
	}

	protected BufferedImage shikamaruCurrentAnimationFrame() {

		if (jumping && direction == 2) {
			shiJumpR.update();
			return shiJumpR.getCurrentFrame();
		}

		else if (jumping && direction == 4) {
			shiJumpL.update();
			return shiJumpL.getCurrentFrame();
		}

		else if (xMove < 0 && xMove > -2.4) {
			shiWalkLeft.update();
			return shiWalkLeft.getCurrentFrame();
		}

		else if (xMove <= -2.5) {
			shiRunLeft.update();
			return shiRunLeft.getCurrentFrame();
		}

		else if(xMove > 0 && xMove < 2.4) {
			shiWalkRight.update();
			return shiWalkRight.getCurrentFrame();
		}

		else if (xMove >= 2.5) {
			shiRunRight.update();
			return shiRunRight.getCurrentFrame();
		}

		else if (xMove < 0 && jumping) {
			shiJumpL.update();
			return shiJumpL.getCurrentFrame();
		}
		
		else if (xMove == 0 && direction == 2) {
			shiStandingR.update();
			return shiStandingR.getCurrentFrame();
		}
		
		else {
			shiStandingL.update();
			return shiStandingL.getCurrentFrame();
		}
	}
}