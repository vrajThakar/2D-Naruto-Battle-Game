package com.vraj.narutogame.states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import com.vraj.narutogame.Game;
import com.vraj.narutogame.Handler;
import com.vraj.narutogame.display.Display;
import com.vraj.narutogame.gfx.Assets;
import com.vraj.narutogame.input.MouseManager;



public class MenuState extends State{

	private boolean ruleState = true;
	private ArrayList<String> rules = new ArrayList<String>();

	//Constructor
	public MenuState(Handler handler) {

		super(handler);

		//file input/output
		try {
			file();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {


		if(handler.getKeyManager().esc)
			ruleState = true;

		if(handler.getKeyManager().back) {
			JFrame frame = Display.getFrame();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

		if(!ruleState) {
			if(hovering(new Rectangle(680, 375, 380, 40))) {
				if(clicked()) {
					Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\clickSound.wav");
					State.setState(handler.getGame().characterState);
					MouseManager.setLeftPressed(false);
				}
			}
			if(hovering(new Rectangle(680, 475, 380, 40))) {
				if(clicked()) {
					Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\clickSound.wav");
					JFrame frame = Display.getFrame();
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		}
	} 

	@Override
	public void render(Graphics g){  

		//renders to the screen
		g.drawImage(Assets.narutoBg, -800, -250, null);

		g.drawImage(Assets.bigRock, 450, 50, null);
		g.setColor(Color.GREEN);
		g.setFont(new Font("Serif", Font.BOLD, 22)); 
		g.drawString("Welcome to", 515, 110);
		g.drawString("Naruto Fight Game!", 480, 140);

		g.setColor(Color.ORANGE);
		g.fillRect(680, 375, 380, 40);

		g.fillRect(680, 475, 380, 40);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Geeza Pro", Font.BOLD, 18));
		g.drawString("Click to choose Characters", 750, 400);
		g.drawString("Click to Exit Application", 750, 500);



		if(!ruleState) {
			int alpha = 127; // 50% transparent
			Color myColour = new Color(0, 255, 51, alpha);
			if(hovering(new Rectangle(680, 375, 380, 40))) {
				g.setColor(myColour);
				g.fillRect(680, 375, 380, 40);

				Graphics2D g2 = (Graphics2D) g;
				Stroke original = g2.getStroke();
				g2.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g2.drawRect(680, 375, 380, 40);
				g2.setStroke(original);
			}

			if(hovering(new Rectangle(680, 475, 380, 40))) {
				g.setColor(myColour);
				g.fillRect(680, 475, 380, 40);

				Graphics2D g2 = (Graphics2D) g;
				Stroke original = g2.getStroke();
				g2.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g2.drawRect(680, 475, 380, 40);
				g2.setStroke(original);
			}
		}

		//render rules 
		if(ruleState) {
			Color bg = new Color(255, 255, 255, 230);
			g.setColor(bg);
			g.fillRect(25, 25, 1102, 590);
			g.setColor(Color.BLACK);
			g.drawString(rules.get(0), 90, 65);
			g.drawString("Official Rules:", 90, 85);
			g.setFont(new Font("Geeza Pro", Font.PLAIN, 11));
			int ypos = 0;
			int xpos = 100;
			for(int i=1; i<rules.size(); i++) {
				if(i == 10 || i == 11 || i == 14 || i == 16 || i == 18 || i == 20 || i == 22 || i == 24 || i == 28 || i == 29 || i == 30)
					xpos = 120;
				else if(i == 15 || i == 17 || i == 19 || i == 21 || i == 23 || i == 25)
					xpos = 140;
				else xpos = 100;
				g.drawString(rules.get(i), xpos, 95+ypos);
				ypos+=15;
			}

		}
		if(clicked() && ruleState) {
			Game.playEffect(System.getProperty("user.dir") + "\\resources\\music\\selectSound.wav");//("C:\\EclipseJava\\updatedgame\\resources\\music\\selectSound.wav", false);
			//in case you click over start game or exit 
			//it doesn't instantly go there
			try {
				Thread.sleep(300);
			}catch(Exception e) {
				e.printStackTrace();
				new Thread().start();
				System.exit(0);
			}
			ruleState = false;
		}

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

	//file input/output
	public void file() throws IOException{

		File file = new File("rules.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			rules.add(reader.nextLine());

		}	
		reader.close();
	}

}