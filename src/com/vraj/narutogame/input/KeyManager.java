package com.vraj.narutogame.input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right, up2, down2, left2, right2, 
	esc, spc, res, shf, back, one, two, thr, fou, fiv, six, e, ent;

	//Constructor
	public KeyManager() {
		//Chose an arbitrarily large number
		keys = new boolean[256];
	}

	public void update() {
		up = keys[KeyEvent.VK_UP];//UP
		down = keys[KeyEvent.VK_DOWN];//DOWN
		left = keys[KeyEvent.VK_LEFT];//LEFT
		right = keys[KeyEvent.VK_RIGHT];//RIGHT

		up2 = keys[KeyEvent.VK_W];
		down2 = keys[KeyEvent.VK_S];
		left2 = keys[KeyEvent.VK_A];
		right2 = keys[KeyEvent.VK_D];

		esc = keys[KeyEvent.VK_ESCAPE];
		spc = keys[KeyEvent.VK_SPACE];
		res = keys[KeyEvent.VK_R];
		shf = keys[KeyEvent.VK_SHIFT];
		back = keys[KeyEvent.VK_BACK_SPACE];
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		thr = keys[KeyEvent.VK_3];
		fou = keys[KeyEvent.VK_4];
		fiv = keys[KeyEvent.VK_5];
		six = keys[KeyEvent.VK_6];
		e = keys[KeyEvent.VK_E];
		ent = keys[KeyEvent.VK_ENTER];

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//true if key is pressed
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//false if key is released
		keys[e.getKeyCode()] = false;

	}

}