package com.vraj.narutogame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import com.vraj.narutogame.Handler;
import com.vraj.narutogame.display.Display;
import com.vraj.narutogame.gfx.Assets;

public class WinState extends State{

	//Constructor
	public WinState(Handler handler){
		super(handler);
	}

	//update method
	@Override
	public void update() {

		//exit game
		if(handler.getKeyManager().back) {
			JFrame frame = Display.getFrame();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		//exit game
		if(clicked()) {
			JFrame frame = Display.getFrame();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}

	//render method
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1152, 640);
		g.setColor(Color.WHITE);
		if (GameState.getEnd() == 0) {
			g.drawImage(Assets.tie, 0, 0, null);

			if(CharacterState.getPlayer1() == "Naruto") 
				g.drawImage(Assets.narutoW, 350, 0, null);
			else if(CharacterState.getPlayer1() == "Sasuke") 
				g.drawImage(Assets.sasukeW, 280, 80, null);
			else if(CharacterState.getPlayer1() == "Sakura") 
				g.drawImage(Assets.sakuraW, 280, 90, null);
			else if(CharacterState.getPlayer1() == "Neji") 
				g.drawImage(Assets.nejiW, 280, 80, null);
			else if(CharacterState.getPlayer1() == "Kakashi") 
				g.drawImage(Assets.kakashiW, 260, 80, null);
			else if(CharacterState.getPlayer1() == "Shikamaru") 
				g.drawImage(Assets.shikamaruW, 300, 0, null);

			if(CharacterState.getPlayer2() == "Naruto") 
				g.drawImage(Assets.narutoW, 650, 0, null);
			else if(CharacterState.getPlayer2() == "Sasuke") 
				g.drawImage(Assets.sasukeW, 580, 80, null);
			else if(CharacterState.getPlayer2() == "Sakura")
				g.drawImage(Assets.sakuraW, 580, 90, null);
			else if(CharacterState.getPlayer2() == "Neji") 
				g.drawImage(Assets.nejiW, 580, 80, null);
			else if(CharacterState.getPlayer2() == "Kakashi") 
				g.drawImage(Assets.kakashiW, 560, 80, null);
			else if(CharacterState.getPlayer2() == "Shikamaru") 
				g.drawImage(Assets.shikamaruW, 600, 0, null);
		}

		else if(GameState.getEnd() == 2) {
			g.drawImage(Assets.win2, 0, 0, null);
			if(CharacterState.getPlayer2() == "Naruto") 
				g.drawImage(Assets.narutoW, 500, 0, null);
			else if(CharacterState.getPlayer2() == "Sasuke") 
				g.drawImage(Assets.sasukeW, 430, 80, null);
			else if(CharacterState.getPlayer2() == "Sakura") 
				g.drawImage(Assets.sakuraW, 430, 90, null);
			else if(CharacterState.getPlayer2() == "Kakashi") 
				g.drawImage(Assets.kakashiW, 410, 80, null); 
			else if(CharacterState.getPlayer2() == "Neji") 
				g.drawImage(Assets.nejiW, 430, 80, null);
			else if(CharacterState.getPlayer2() == "Shikamaru") 
				g.drawImage(Assets.shikamaruW, 450, 0, null);
		}
		else if(GameState.getEnd() == 1) {
			g.drawImage(Assets.win1, 0, 0, null);
			if(CharacterState.getPlayer1() == "Naruto") 
				g.drawImage(Assets.narutoW, 500, 0, null);
			else if(CharacterState.getPlayer1() == "Sasuke") 
				g.drawImage(Assets.sasukeW, 430, 80, null);
			else if(CharacterState.getPlayer1() == "Sakura") 
				g.drawImage(Assets.sakuraW, 430, 90, null);
			else if(CharacterState.getPlayer1() == "Kakashi") 
				g.drawImage(Assets.kakashiW, 410, 80, null); 
			else if(CharacterState.getPlayer1() == "Neji") 
				g.drawImage(Assets.nejiW, 430, 80, null);
			else if(CharacterState.getPlayer1() == "Shikamaru") 
				g.drawImage(Assets.shikamaruW, 450, 0, null); 
		}

		g.setFont(new Font("Serif", Font.BOLD, 22)); 
		g.drawString("[Backspace] to Exit Application", 10, 30);
		g.drawString("Click Anywhere to Exit Application", 10, 60);

	}

	//mouse clicks method
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

		if (handler.getMouseManager().isLeftPressed()) {
			return true;
		}
		return false;
	}

}
