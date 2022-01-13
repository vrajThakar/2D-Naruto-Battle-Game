package com.vraj.narutogame.states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.WindowEvent;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.display.Display;
import com.vraj.narutogame.gfx.Assets;



public class PauseState extends State {

	//Constructor
	public PauseState(Handler handler) {
		super(handler);

	}

	@Override
	public void update() {


		if(hovering(new Rectangle(380, 275, 380, 40))) {
			if(clicked()) {
				Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\clickSound.wav");
				State.setState(handler.getGame().gameState);
			}
		}

		else if(handler.getKeyManager().back) {
			JFrame frame = Display.getFrame();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

		if(hovering(new Rectangle(380, 350, 380, 40))) {
			if(clicked()) {

				JFrame frame = Display.getFrame();
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}

		}

	}


	@Override
	public void render(Graphics g) {

		//render to the screen
		g.drawImage(Assets.pauseBg, -430, -300, null);


		g.setColor(Color.ORANGE);

		g.fillRect(380, 275, 360, 40);//go to main menu
		g.fillRect(380, 350, 360, 40);//exit application
		g.setColor(Color.BLACK);
		g.setFont(new Font("Geeza Pro", Font.BOLD, 18));

		g.drawString("Click to go into the Game", 440, 300);
		g.drawString("Click to Exit Application", 440, 380);

		g.setColor(Color.WHITE);
		g.drawString("You are in the settings/pause menu", 400, 100);

		int alphaG = 127; // 50% transparent
		Color myGColour = new Color(0, 255, 51, alphaG);

		if(hovering(new Rectangle(380, 275, 360, 40))) {
			g.setColor(myGColour);
			g.fillRect(380, 275, 360, 40);

			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(380, 275, 360, 40);
			g2.setStroke(original);
		}
		else if(hovering(new Rectangle(380, 350, 360, 40))) {
			g.setColor(myGColour);
			g.fillRect(380, 350, 360, 40);

			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(380, 350, 360, 40);
			g2.setStroke(original);
		}

		g.setColor(Color.ORANGE);
		g.fillRoundRect(385, 445, 50, 50, 50, 50);
		g.drawImage(Assets.volume, 380, 440, null);
		g.fillRect(440, 463, 300, 10);

		g.fillRect(440, 453, 10, 30);
		g.fillRect(505, 456, 10, 24);
		g.fillRect(580, 453, 10, 30);
		g.fillRect(655, 456, 10, 24);
		g.fillRect(730, 453, 10, 30);

		FloatControl gainControl = (FloatControl) Game.clip.getControl(FloatControl.Type.MASTER_GAIN);
		if(hovering(new Rectangle(440, 453, 10, 30))) {
			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(440, 453, 10, 30);
			g2.setStroke(original);
			if(clicked()) {
				Game.setVolume(-30.0f);
				gainControl.setValue(Game.getVolume());
			}
		}
		if(hovering(new Rectangle(505, 456, 10, 24))) {
			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(505, 456, 10, 24);
			g2.setStroke(original);
			if(clicked()) {
				Game.setVolume(-20.0f);
				gainControl.setValue(Game.getVolume());
			}
		}
		if(hovering(new Rectangle(580, 453, 10, 30))) {
			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(580, 453, 10, 30);
			g2.setStroke(original);
			if(clicked()) {
				Game.setVolume(-10.0f);
				gainControl.setValue(Game.getVolume());
			}
		}
		if(hovering(new Rectangle(655, 456, 10, 24))) {
			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(655, 456, 10, 24);
			g2.setStroke(original);
			if(clicked()) {
				Game.setVolume(0.0f);
				gainControl.setValue(Game.getVolume());
			}
		}
		if(hovering(new Rectangle(730, 453, 10, 30))) {
			Graphics2D g2 = (Graphics2D) g;
			Stroke original = g2.getStroke();
			g2.setStroke(new BasicStroke(3));
			g.setColor(Color.BLACK);
			g2.drawRect(730, 453, 10, 30);
			g2.setStroke(original);
			if(clicked()) {
				Game.setVolume(6.0f);
				gainControl.setValue(Game.getVolume());
			}
		}

		g.setColor(Color.black);
		if(Game.getVolume() == -30.0f)
			g.fillRoundRect(437, 460, 16, 16, 16, 16);
		if(Game.getVolume() == -20.0f)
			g.fillRoundRect(502, 460, 16, 16, 16, 16);
		if(Game.getVolume() == -10.0f)
			g.fillRoundRect(577, 460, 16, 16, 16, 16);
		if(Game.getVolume() == 0.0f)
			g.fillRoundRect(652, 460, 16, 16, 16, 16);
		if(Game.getVolume() == 6.0f)
			g.fillRoundRect(727, 460, 16, 16, 16, 16);



	}

	public boolean hovering(Rectangle rounds){

		int mouseX = handler.getMouseManager().getMouseX();
		int mouseY = handler.getMouseManager().getMouseY();
		if((mouseX >= rounds.getX() && mouseX <= rounds.getX() + rounds.getWidth()) && ( mouseY >= rounds.getY() && mouseY <= rounds.getY() + rounds.getHeight())) {

			return true;

		}
		else {
			return false;
		}

	} 
	public boolean clicked(){

		if (handler.getMouseManager().isLeftPressed()) {//isRightPressed()) {
			return true;
		}
		return false;
	}





}