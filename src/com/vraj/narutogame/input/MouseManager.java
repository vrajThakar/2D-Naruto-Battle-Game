package com.vraj.narutogame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class MouseManager implements MouseListener, MouseMotionListener{

	private static boolean leftPressed;
	private boolean rightPressed;
	private int mouseX, mouseY;

	//Constructor is null
	public MouseManager() {

	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	//check if left clicked
	public static void setLeftPressed(boolean leftPressed) {
		MouseManager.leftPressed = leftPressed;
	}

	//check if right clicked
	public boolean isRightPressed() {
		return rightPressed;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//return true if left or right clicked
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;

		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//false return false if left or right mouse click is released
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;

		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {

	}

	//get x any y position of mouse
	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

}