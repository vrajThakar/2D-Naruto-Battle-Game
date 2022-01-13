package com.vraj.narutogame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.vraj.narutogame.display.Display;
import com.vraj.narutogame.gfx.Assets;
import com.vraj.narutogame.input.KeyManager;
import com.vraj.narutogame.input.MouseManager;
import com.vraj.narutogame.states.GameState;
import com.vraj.narutogame.states.MenuState;
import com.vraj.narutogame.states.PauseState;
import com.vraj.narutogame.states.CharacterState;
import com.vraj.narutogame.states.State;
import com.vraj.narutogame.states.WinState;

public class Game implements Runnable {

	//frames per second
	private static int fps;

	//GUI general information
	private Display display;
	public int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;

	//Audio class variables
	public static Clip clip;
	private static float volume = -20.0f;

	//States
	public State gameState;
	public State menuState;
	public State pauseState;
	public State characterState;
	public State winState;

	//Player inputs
	private KeyManager keyManager;
	private MouseManager mouseManager;

	//Handler manages all variables
	private Handler handler;

	//Game Constructor
	public Game(String title, int width, int height, int fps) {
		Game.fps = fps;
		this.width = width;
		this.height = height; 
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	//run time method
	public void run() {
		init();
		playMusic();

		//amount of times the update and render method are called
		//frames per second = 120;
		//1 second divided by frames per second
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
		}
		stop();
	} 

	//Main Game loop
	private void init() {

		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);

		Display.getFrame().addMouseListener(mouseManager);
		Display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);


		Assets.init();

		handler = new Handler(this);
		//game state object
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		pauseState = new PauseState(handler);
		characterState = new CharacterState(handler);
		winState = new WinState(handler);
		//Game Starts in menu
		State.setState(menuState);


	}

	//Game updates 120 times per second (frames per second)
	private void update() {
		keyManager.update();
		if(State.getState() != null) {
			State.getState().update();
		}


	}

	private void render() {
		//BufferStrategy tells the computer how to draw 'stuff' to the screen
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);

		//Draw here
		if(State.getState() != null) {
			State.getState().render(g);
		}

		//End drawing
		bs.show();
		g.dispose();
	}

	//Game-time running methods
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Method to play Game music
	public static void playMusic() {
		String fileLocation = (System.getProperty("user.dir") + "\\resources\\music\\narutoThemeSong.wav");
		try {
			File musicPath = new File (fileLocation);

			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);

				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				//volume can be modified in game to change the sound
				gainControl.setValue(volume);

				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else System.out.println("Cannot find file");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Method to play Game sound effects
	public static void playEffect(String file) {
		String fileLocation = file;

		try {
			File musicPath = new File (fileLocation);

			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);

				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				//volume can be modified in game to change the sound
				//sound effects were low, so they are manually adjusted
				//max gain control is 6.2
				if(volume >= 0)
					gainControl.setValue(6.0f);
				else
					gainControl.setValue(volume + 5.0f);

				clip.start();
			}
			else System.out.println("Cannot find file");

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	//getters and setters
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public static void setVolume(float volume) {
		Game.volume = volume;
	}

	public static float getVolume() {
		return volume;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}


}